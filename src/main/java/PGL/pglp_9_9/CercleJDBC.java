package PGL.pglp_9_9;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleJDBC implements DAO<Cercle>{
	/**
	 * 
	 */
	private Connection connect = null;
	/**
	 * 
	 */
	private java.sql.Statement stmt;
	
	public CercleJDBC() {
		connect = DAO.getConnection();
		try {
			ResultSet r = connect.getMetaData().getTables(null, null, "CERCLES", null);
			stmt = connect.createStatement();
			if(!r.next()) {
				stmt.execute("CREATE TABLE CERCLES(name varchar(50) NOT NULL PRIMARY KEY, " 
					      + " x double NOT NULL, y double NOT NULL, r double Not Null,gid integer)");
			}
		    stmt.close();
		    connect.close();
		}catch(SQLException e) {
		      e.printStackTrace();
		}
	}
	@Override
	public Cercle create(Cercle obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO CERCLES(name,x,y,r,gid)"
												+ " VALUES(?,?,?,?,?)");
			prepare.setString(1,obj.getName());
			prepare.setDouble(2,obj.getCentre().getX());
			prepare.setDouble(3,obj.getCentre().getY());
			prepare.setDouble(4,obj.getRayon());
			prepare.setDouble(5,obj.getGroupId());
			
			prepare.executeUpdate();
			connect.close();
			}
		catch(SQLException e){
			e.printStackTrace();
			}
		return obj;
	}

	@Override
	public Cercle update(Cercle obj) {
	    connect = DAO.getConnection();
	    PreparedStatement update =  null;
	    String updateString = "update cercles set x = ?, "
	        + "y = ?, r = ?, gid = ? where name = ?";
	    try {
	      update = connect.prepareStatement(updateString);
	      update.setDouble(1, obj.getCentre().getX());
	      update.setDouble(2, obj.getCentre().getY());
	      update.setDouble(3, obj.getRayon());
	      update.setInt(4, obj.getGroupId());
	      update.setString(5, obj.getName());
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
	public Cercle delete(String name) {
	    connect = DAO.getConnection();
		try{
		PreparedStatement prepare=connect.prepareStatement("delete from CERCLES where name = ?");
		prepare.setString(1,name);
		prepare.executeUpdate();
		connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Cercle find(String name) {
	    connect = DAO.getConnection();
	    Cercle c = null;
		try{
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM CERCLES WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.next()){
			c = new Cercle( result.getString("name"), result.getInt("gid"),
					new Point( result.getDouble("x"), result.getDouble("y")), 
					result.getDouble("r"));
			connect.close();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}
	public java.sql.Statement getPreparedStatement() {
		return stmt;
	}
	public void setPreparedStatement(Statement stmt1) {
		stmt = (java.sql.Statement) stmt1;
	}
	

}
