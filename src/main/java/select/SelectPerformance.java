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
import pojo.Album;
import pojo.Performance;

@WebServlet("/SelectPerformance")
public class SelectPerformance extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectPerformance() {
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
        List<Performance> performances = new ArrayList<Performance>();
        Connection connection = null;
        try {
        	connection = ConnectionPostGres.getConnection();

            String sql = "SELECT * from PERFORMANCE ORDER BY id_perf ASC;";

            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Performance performance = new Performance();
                performance.setIdPerformance(rs.getInt("id_perf"));
                performance.setIdSong(rs.getInt("id_song"));
                performance.setMusSSN(rs.getString("mus_ssn"));
                performances.add(performance);
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
        getServletContext().setAttribute("performances", performances);


        request.getRequestDispatcher("WEB-INF/select/SelectPerformance.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
