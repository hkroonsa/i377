import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

	public class Search extends HttpServlet {
		private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
			List<Data> data = new ArrayList<Data>();
			String parameter = request.getParameter("do");
			String search = request.getParameter("searchString");	
			
			if ("delete".equals(parameter)) {
				
				int input = Integer.parseInt(request.getParameter("id"));
				try {
					new DataDao().deleteId(input);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}	
			
			if (search !=null) {
				try {
					data = new DataDao().search(request.getParameter("searchString"));
				} catch (SQLException e) {					
					e.printStackTrace();
				}				
				
			}else {				
				try {
					data = new DataDao().findAllUnits();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
			
			
			
			request.setAttribute("units", data);
			request.getRequestDispatcher("search.jsp").forward(request,response);
		}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		}

	}

