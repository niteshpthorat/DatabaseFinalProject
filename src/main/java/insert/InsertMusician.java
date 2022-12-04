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

@WebServlet("/InsertMusician")
public class InsertMusician extends HttpServlet {
    private static final long serialVersionUID = 1L;
    int maxMus = 0;
    public InsertMusician() {
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

            String sql = "SELECT MAX(ID_MUSICIAN) FROM MUSICIAN ";

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                maxMus = rs.getInt(1) + 1;
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
        request.getRequestDispatcher("WEB-INF/insert/InsertMusician.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ssn = request.getParameter("ssn");
        String name = request.getParameter("name");
        String phone_no = request.getParameter("phone_no");
        Connection c = null;
        try {
            String sql = "INSERT INTO Musician VALUES (?,?,?,?) ";
            System.out.println(sql);
            c = ConnectionPostGres.getConnection() ;
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, maxMus);
            ps.setString(2, ssn);
            ps.setString(3, name);
            ps.setString(4, phone_no);
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
        response.sendRedirect("selectMusician.java");
        //request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
