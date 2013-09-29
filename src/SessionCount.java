import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCount extends HttpServlet implements HttpSessionListener {
	private static final long serialVersionUID = 1L;
	private static int counter = 0;   
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().println("count: "+counter);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		counter++;		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		counter--;		
	}
	
	public static int getTotalActiveSessions(){
		return counter;
	}

}
