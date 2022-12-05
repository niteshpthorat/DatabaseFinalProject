package delete;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnection.ConnectionPostGres;

@WebServlet("/DeleteSong")
public class DeleteSong extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteSong() {
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int songId = Integer.parseInt(request.getParameter("id"));

        System.out.println("song_id " + songId);

        Connection connection = null;
        try {
            String sql = "DELETE FROM SONG WHERE ID_SONG= ?";
            connection =  ConnectionPostGres.getConnection();
            PreparedStatement ps  = connection.prepareStatement(sql);
            ps.setInt(1, songId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection Closed: Delete Song");
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        request.getRequestDispatcher("WEB-INF/select/index.jsp").forward(request, response);
    }

}
