package PGL.pglp_9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 
 * @author Akram
 *
 * @param <T>
 */
public interface DAO<T> {
	/**
	 * Create
	 * @param obj
	 * @return
	 */
	public T create(T obj);
	/**
	 * Update
	 * @param obj
	 * @return
	 */
	public T update(T obj);
	/**
	 * delete
	 * @param obj
	 * @return
	 */
	public T delete(String name);
	/**
	 * Find
	 * @param obj
	 * @return
	 */
	public T find(String name);
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		
		Properties connectionProps=new Properties();
		
		connectionProps.put("user","root");
		connectionProps.put("password","");
		
	    Connection conn = null;
	    String driver = "com.mysql.jdbc.Driver";
	    try {
	      Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    try {
	      conn = DriverManager.getConnection("jdbc:mysql://localhost/test",connectionProps );
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return conn;
	  }
}
