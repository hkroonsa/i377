import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String parameter = request.getParameter("do");

		if (parameter.endsWith("clear_data")) {			
				try {
					new DataDao().delete();
				} catch (SQLException e) {
					e.printStackTrace();
				}			
		}

		else if (parameter.equals("insert_data"))
			new SetupDao().createSchema("insertIntoDataBase.sql");

		response.sendRedirect("Search");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
	}

}