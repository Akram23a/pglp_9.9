package PGL.pglp_9_9;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
		
	    Connection connexion = null;
	    String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	    try {
	      Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    try {
	      connexion = DriverManager.getConnection("jdbc:derby:shapedb;create=true");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return connexion;
	  }
	  
}
