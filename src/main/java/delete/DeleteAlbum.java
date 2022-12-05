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

@WebServlet("/DeleteAlbum")
public class DeleteAlbum extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DeleteAlbum() {
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
        int id = Integer.parseInt(request.getParameter("id"));

        Connection c = null;
        try {
            String sql = "DELETE FROM ALBUM WHERE ID_ALBUM=? ";
            c = ConnectionPostGres.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
        } catch (SQLException e) {
            getServletContext().setAttribute("de", "Album cannot be deleted. Album must be empty.");
            request.getRequestDispatcher("WEB-INF/select/SelectAlbum.jsp").forward(request, response);
            //throw new ServletException(e);
        } finally {
            try {
                if (c != null) {
                    c.close();
                    System.out.println("Connection Closed: Delete Album");
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        //response.sendRedirect("SelectAlbum");

    }

}
