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
import pojo.InstrumentPlayer;

@WebServlet("/SelectInstrumentPlayer")
public class SelectInstrumentPlayer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectInstrumentPlayer() {
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
        List<InstrumentPlayer> instrplayer = new ArrayList<InstrumentPlayer>();
        Connection connection = null;
        try {
            connection = ConnectionPostGres.getConnection();

            String sql = "SELECT * from INSTRUMENT_PLAYER ORDER BY ID_INST_PLA ASC;";

            PreparedStatement st = connection.prepareStatement(sql);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                InstrumentPlayer a = new InstrumentPlayer();
                a.setId(rs.getInt("ID_INST_PLA"));
                a.setIdInstrument(rs.getInt("ID_INSTRU"));
                a.setMusSSN(rs.getString("MUS_SSN"));

                instrplayer.add(a);
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
        getServletContext().setAttribute("instrplayer", instrplayer);
        request.getRequestDispatcher("WEB-INF/select/SelectInstrumentPlayer.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
