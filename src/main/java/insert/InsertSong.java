package insert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnection.ConnectionPostGres;

@WebServlet("/InsertSong")
public class InsertSong extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int maxSongId = 0;

    public InsertSong() {
        super();
    }

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new ServletException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection c = null;
        
        try {
            c = ConnectionPostGres.getConnection();

            String sql = "SELECT MAX(ID_SONG) FROM SONG ";
            PreparedStatement st = c.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                maxSongId = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (c != null) {
                    System.out.println("Connection CLOSED");
                    c.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        request.getRequestDispatcher("insert/InsertSong.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String songTitle = request.getParameter("songTitle");
        String author = request.getParameter("author");
        String idAlbum = request.getParameter("idAlbum");

        Connection c = null;
        try {
            String sql = "INSERT INTO Song(SONG_ID,TITLE,AUTHOR,ALBUM_ID) VALUES (?,?,?,?);";
            System.out.println(sql);
            c = ConnectionPostGres.getConnection();

            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, maxSongId);
            ps.setString(2, songTitle);
            ps.setString(3, author);
            ps.setInt(4, Integer.parseInt(idAlbum));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (c != null) {
                    c.close();
                    System.out.println("Connection Closed: Insert Song");
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        //response.sendRedirect("selectMusician.java");
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
