package select;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnection.ConnectionPostGres;
import pojo.Song;

@WebServlet("/SelectSong")
public class SelectSong extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectSong() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Song> songs = new ArrayList<Song>();
        Connection connection = null;
        try {
            connection = ConnectionPostGres.getConnection();

            String sql = "SELECT * from SONG ORDER BY ID_SONG ASC ";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Song song = new Song();
                song.setIdSong(rs.getInt("ID_SONG"));
                song.setTitle(rs.getString("SONG_TITLE"));
                song.setAuthor(rs.getString("AUTHOR"));
                song.setIdAlbum(rs.getInt("ID_ALBUM"));
                songs.add(song);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (connection != null) {
                    System.out.println("Connection CLOSED");
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        getServletContext().setAttribute("songs", songs);


        request.getRequestDispatcher("WEB-INF/select/SelectSong.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
