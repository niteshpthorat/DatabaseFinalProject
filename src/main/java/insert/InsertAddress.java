package insert;

import java.io.IOException;
import java.sql.Connection;
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

@WebServlet("/InsertAddress")
public class InsertAddress extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int maxId = 0;
    public InsertAddress() {
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

            String sql = "SELECT MAX(ID) FROM TOWN ";

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                maxId = rs.getInt(1) + 1;
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
        request.getRequestDispatcher("WEB-INF/insert/InsertAddress.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String address = request.getParameter("address");
        System.out.println(address);
        String phoneNumber = request.getParameter("phoneNumber");
        Connection c = null;
        try {
            String sql = "INSERT INTO Town VALUES (?,?,?) ";
            System.out.println(sql);
            c = ConnectionPostGres.getConnection() ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, maxId);
            ps.setString(2, address);
            ps.setString(3, phoneNumber);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (c != null) {
                    c.close();
                    System.out.println("Connection Closed: Insert Musician");
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
       // response.sendRedirect("selectMusician.java");
        request.getRequestDispatcher("WEB-INF/insert/SelectMusician.jsp").forward(request, response);
    }
}
