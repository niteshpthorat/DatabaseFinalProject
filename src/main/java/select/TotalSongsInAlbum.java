package select;

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

@WebServlet("/TotalSongsInAlbum")
public class TotalSongsInAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TotalSongsInAlbum() {
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
		int albumId = Integer.parseInt(request.getParameter("albumId"));
		System.out.println("total alb ID" + albumId);

		int countSong = 0;
		String totalSong = null;
		Connection connection = null;
		try {
			connection = ConnectionPostGres.getConnection();
			String sql = "SELECT Count(*) FROM Song WHERE ID_ALBUM=? ";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, albumId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				countSong = rs.getInt(1);
			}
			totalSong = Integer.toString(countSong);
			System.out.println(totalSong);
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
		getServletContext().setAttribute("totalSong", totalSong);
		request.getRequestDispatcher("WEB-INF/select/SelectAlbum.jsp").forward(request, response);
	}
}
