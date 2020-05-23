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
public class TriangleJDBC implements DAO<Triangle>{
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
	public TriangleJDBC() {
		connect = DAO.getConnection();
		try {
			ResultSet r = connect.getMetaData().getTables(null, null, "TRIANGLES", null);
			stmt = connect.createStatement();
			if(!r.next()) {
				stmt.execute( "CREATE TABLE TRIANGLES " +
		                   "(name VARCHAR(30) not NULL, " +
		                   " x1 DOUBLE, " + 
		                   " y1 DOUBLE, " + 
		                   " x2 DOUBLE, " + 
		                   " y2 DOUBLE, " + 
		                   " x3 DOUBLE, " + 
		                   " y3 DOUBLE, " + 
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
	public Triangle create(Triangle obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO TRIANGLES"
							+ "(name,x1,y1,x2,y2,x3,y3,gid)"
							+ " VALUES(?,?,?,?,?,?,?,?)");
			prepare.setString(1,obj.getName());
			prepare.setDouble(2,obj.getP1().getX());
			prepare.setDouble(3,obj.getP1().getY());
			prepare.setDouble(4,obj.getP2().getX());
			prepare.setDouble(5,obj.getP2().getY());
			prepare.setDouble(6,obj.getP3().getX());
			prepare.setDouble(7,obj.getP3().getY());
			prepare.setInt(8,obj.getGroupId());
			
			prepare.executeUpdate();
			connect.close();
			}
		catch(SQLException e){
			e.printStackTrace();
			}
		return obj;
	}

	@Override
	public Triangle update(Triangle obj) {
	    connect = DAO.getConnection();
	    PreparedStatement update =  null;
	    String updateString = "update TRIANGLES set x1 = ?, y1 = ?,x2 = ?"
	    		+ ", y2 = ?,x3 = ?, y3 = ?, gid = ? where name = ?";
	    try {
	    	update = connect.prepareStatement(updateString);
	      	update.setDouble(1,obj.getP1().getX());
	      	update.setDouble(2,obj.getP1().getY());
			update.setDouble(3,obj.getP2().getX());
			update.setDouble(4,obj.getP2().getY());
			update.setDouble(5,obj.getP3().getX());
			update.setDouble(6,obj.getP3().getY());
			update.setInt(7,obj.getGroupId());
			update.setString(8, obj.getName());
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
	public Triangle delete(String name) {
	    connect = DAO.getConnection();
		try{
		PreparedStatement prepare=connect.prepareStatement("delete from TRIANGLES where name=?");
		prepare.setString(1,name);
		prepare.executeUpdate();
		connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Triangle find(String name) {
	    connect = DAO.getConnection();
	    Triangle c = null;
		try{
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM TRIANGLES WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.first()){
			c = new Triangle( result.getString("name"), result.getInt("gid"),
					new Point(result.getDouble("x1"), result.getDouble("y1")),
					new Point(result.getDouble("x2"), result.getDouble("y2")),
					new Point(result.getDouble("x3"), result.getDouble("y3")));
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
	public void setPreparedStatement(Statement stmt1) {
		stmt = (java.sql.Statement) stmt1;
	}

}
