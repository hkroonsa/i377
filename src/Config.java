import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class Config implements ServletContextListener {
	private static final String create = "createDatabase.sql";
	private static final String insert = "insertIntoDataBase.sql";

	
	public void contextInitialized(ServletContextEvent event) {
		
		try {
			new SetupDao().createSchema(create);
			new SetupDao().createSchema(insert);
		} catch (Exception e) {			
			e.printStackTrace();
		}		

	}	
	
	public void contextDestroyed(ServletContextEvent event) {
		
	}

}
