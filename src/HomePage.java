import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class HomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;	

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {				
				String sessionId = request.getSession().getId();
				HttpSession session = request.getSession();				
				response.getWriter().println("Hello!");
				response.getWriter().println("Your session id is " + sessionId);				
				
				if (request.getParameter("param")!=null){
					String parameter = request.getParameter("param");				
					session.setAttribute("param",parameter);
					response.getWriter().println("Session attribute is "+session.getAttribute("param"));					
				}
				
				else 
					response.getWriter().println("Session attribute is "+session.getAttribute("param"));

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
