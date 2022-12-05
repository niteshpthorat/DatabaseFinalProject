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
import pojo.Instrument;

@WebServlet("/SelectInstrument")
public class SelectInstrument extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectInstrument() {
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
        List<Instrument> instruments = new ArrayList<Instrument>();
        Connection connncetion = null;
        try {
            connncetion = ConnectionPostGres.getConnection();

            String sql = "SELECT * from INSTRUMENT ORDER BY ID_INSTRU ASC;";

            PreparedStatement st = connncetion.prepareStatement(sql);

            ResultSet rs = st.executeQuery();


            while (rs.next()) {
                Instrument instrum = new Instrument();
                instrum.setIdInstrument(rs.getInt("ID_INSTRU"));
                instrum.setName(rs.getString("INST_NAME"));
                instrum.setKeys(rs.getString("MUSICAL_KEYS"));

                instruments.add(instrum);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        } finally {
            try {
                if (connncetion != null) {
                    System.out.println("Connection CLOSED");
                    connncetion.close();
                }
            } catch (SQLException e) {
                throw new ServletException(e);
            }
        }
        getServletContext().setAttribute("instr", instruments);


        request.getRequestDispatcher("WEB-INF/select/SelectInstrument.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
