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
import pojo.Musician;

@WebServlet("/SelectMusician")
public class SelectMusician extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectMusician() {
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
        List<Musician> musicians = new ArrayList<Musician>();
        Connection connection = null;
        try {
        	connection = ConnectionPostGres.getConnection();

            String sql = "SELECT * FROM MUSICIAN ORDER BY ID_MUSICIAN ASC;";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Musician musician = new Musician();
                musician.setMusicianId(rs.getInt("ID_MUSICIAN"));
                musician.setSsn(rs.getString("SSN"));
                musician.setName(rs.getString("M_NAME"));
                musician.setPhoneNo(rs.getString("PHONE_NO"));
                musicians.add(musician);
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
        getServletContext().setAttribute("musicians", musicians);
        request.getRequestDispatcher("WEB-INF/select/SelectMusician.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
