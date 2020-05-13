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
	public T delete(T obj);
	/**
	 * Find
	 * @param obj
	 * @return
	 */
	public T find(T obj);
	/**
	 * 
	 * @return
	 */
	public static Connection getConnection() {
	    Connection conn = null;
	    String driver = "com.mysql.jdbc.Driver";
	    try {
	      Class.forName(driver);
	    } catch (ClassNotFoundException e) {
	      e.printStackTrace();
	    }
	    try {
	      conn = DriverManager.getConnection("jdbc:mysql://localhost/test");
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    return conn;
	  }
}
