package PGL.pglp_9_9;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 
 * @author Akram
 *
 */
public class RectangleJDBC implements DAO<Rectangle>{
	/**
	 * 
	 */
	private Connection connect = null;
	/**
	 * 
	 */
	private java.sql.Statement stmt;
	/**
	 * Constructor
	 */

	public RectangleJDBC() {
		connect = DAO.getConnection();
		try {
			ResultSet r = connect.getMetaData().getTables(null, null, "RECTANGLES", null);
			stmt = connect.createStatement();
			if(!r.next()) {
				stmt.execute("CREATE TABLE IF NOT EXISTS RECTANGLES " +
					    "(name VARCHAR(30) not NULL, " +
					    " x DOUBLE, " + 
					    " y DOUBLE, " + 
					    " h DOUBLE, " + 
					    " w DOUBLE, " + 
					    " gid INTEGER, " + 
					    " PRIMARY KEY ( name ))");
			}
		    stmt.close();
		    connect.close();
		}catch(SQLException e) {
		      e.printStackTrace();
		}


	}
	@Override
	public Rectangle create(Rectangle obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO RECTANGLES(name,x,y,h,w,gid)"
												+ " VALUES(?,?,?,?,?,?)");
			prepare.setString(1,obj.getName());
			prepare.setDouble(2,obj.getBottomLeft().getX());
			prepare.setDouble(3,obj.getBottomLeft().getY());
			prepare.setDouble(4,obj.getHeight());
			prepare.setDouble(5,obj.getWidth());
			prepare.setInt(6,obj.getGroupId());
			
			prepare.executeUpdate();
			connect.close();
			}
		catch(SQLException e){
			e.printStackTrace();
			}
		return obj;
	}

	@Override
	public Rectangle update(Rectangle obj) {
	    connect = DAO.getConnection();
	    PreparedStatement update =  null;
	    String updateString = "update RECTANGLES set x = ?, "
	        + "y = ?, h = ?,w = ?, gid = ? where name = ?";
	    try {
	      update = connect.prepareStatement(updateString);
	      update.setDouble(1, obj.getBottomLeft().getX());
	      update.setDouble(2, obj.getBottomLeft().getY());
	      update.setDouble(3,obj.getHeight());
	      update.setDouble(4,obj.getWidth());
	      update.setInt(5, obj.getGroupId());
	      update.setString(6, obj.getName());
	      update.executeUpdate();
	      connect.close();
	    } catch (SQLException e) {
	      e.printStackTrace();
	    }
	    try {
	      if (update != null) {
	        update.close();
	      }
	    } catch (SQLException e1) {
	      e1.printStackTrace();
	    }
	    return obj;
	}

	@Override
	public Rectangle delete(String name) {
	    connect = DAO.getConnection();
		try{
		PreparedStatement prepare=connect.prepareStatement("delete from RECTANGLES where name=?");
		prepare.setString(1,name);
		prepare.executeUpdate();
		connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Rectangle find(String name) {
	    connect = DAO.getConnection();
	    Rectangle c = null;
		try{
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM RECTANGLES WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.next()){
			c = new Rectangle(result.getString("name"), 
					result.getInt("gid"), new Point( result.getDouble("x"), 
							result.getDouble("y")),
					result.getDouble("h"), result.getDouble("w"));
			connect.close();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}
	/**
	 * 
	 * @return
	 */
	public java.sql.Statement getPreparedStatement() {
		return stmt;
	}
	/**
	 * 
	 * @param stmt1
	 */
	public void setPreparedStatement(final Statement stmt1) {
		stmt = (java.sql.Statement) stmt1;
	}


}
