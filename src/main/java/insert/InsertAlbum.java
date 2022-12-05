package insert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseConnection.ConnectionPostGres;

@WebServlet("/InsertAlbum")
public class InsertAlbum extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int maxAlbumId = 0;
    public InsertAlbum() {
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
        Connection connection = null;
        
        try {
        	connection = ConnectionPostGres.getConnection();

            String sql = "SELECT MAX(ID_ALBUM) FROM ALBUM;";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                maxAlbumId = rs.getInt(1) + 1;
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
        request.getRequestDispatcher("WEB-INF/insert/InsertAlbum.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String identifier = request.getParameter("identifier");
        String title = request.getParameter("title");
        String dateCopyright = request.getParameter("dateCopyright");
        String format = request.getParameter("format");
        String musSSN = request.getParameter("musSSN");
        Date date=Date.valueOf(dateCopyright);
        Connection c = null;
        try {
            String sql = "INSERT INTO Album VALUES (?,?,?,?,?,?) ";
            c = ConnectionPostGres.getConnection();
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, maxAlbumId);
            ps.setString(2, title);
            ps.setDate(3, date);
            ps.setString(4, format);
            ps.setString(5, musSSN);
            ps.setString(6, identifier);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (c != null) {
                    c.close();
                    System.out.println("Connection Closed: Insert Album");
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        //response.sendRedirect("selectMusician.java");
        request.getRequestDispatcher("WEB-INF/index.jsp").forward(request, response);
    }
}
