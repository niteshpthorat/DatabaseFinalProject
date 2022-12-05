package select;

import java.io.IOException;
import java.sql.Connection;
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
import pojo.Town;

@WebServlet("/SelectTown")
public class SelectTown extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectTown() {
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
        List<Town> addresses = new ArrayList<Town>();
        Connection connection = null;
        try {
            connection = ConnectionPostGres.getConnection();

            String sql = "SELECT * from TOWN ORDER BY ID ASC;";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


            while (rs.next()) {
                Town tow = new Town();
                tow.setId(rs.getInt("id"));
                tow.setAddress(rs.getString("address"));
                tow.setPhoneNumber(rs.getString("phone_no"));
                addresses.add(tow);
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
        getServletContext().setAttribute("addresses", addresses);


        request.getRequestDispatcher("WEB-INF/select/SelectTown.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
