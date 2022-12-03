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
import pojo.Album;

@WebServlet("/SelectAlbum")
public class SelectAlbum extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SelectAlbum() {
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
        List<Album> album = new ArrayList<Album>();
        Connection connection = null;
        try {
            connection = ConnectionPostGres.getConnection();
            String sql = "SELECT * from ALBUM ORDER BY ID_ALBUM ASC ";
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Album entry = new Album();
                entry.setAlbumId(rs.getInt("id_album"));
                entry.setTitle(rs.getString("title"));
                entry.setDateCopyRight(rs.getDate("date_copyright"));;
                entry.setFormat(rs.getString("format"));
                entry.setMusSSN(rs.getString("mus_ssn"));;
                album.add(entry);
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
        getServletContext().setAttribute("album", album);


        request.getRequestDispatcher("/WEB-INF/select/SelectAlbum.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int albID = Integer.parseInt(request.getParameter("id_album"));
        System.out.println("total alb ID" + albID);

        request.getRequestDispatcher("WEB-INF/select/SelectAlbum.jsp").forward(request, response);
    }

}
