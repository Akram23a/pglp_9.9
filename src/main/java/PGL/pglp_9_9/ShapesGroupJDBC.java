package PGL.pglp_9_9;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShapesGroupJDBC implements DAO<ShapesGroup>{
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
	

	public ShapesGroupJDBC() {
		connect = DAO.getConnection();
		try {
			ResultSet r = connect.getMetaData().getTables(null, null, "SHAPESGROUPS", null);
			stmt = connect.createStatement();
			if(!r.next()) {
				stmt.execute("CREATE TABLE IF NOT EXISTS SHAPESGROUPS " +
		                   "(name id(30) not NULL, " +
		                   " name VARCHAR(30), " +
		                   " PRIMARY KEY ( id ))");
			}
		    stmt.close();
		    connect.close();
		}catch(SQLException e) {
		      e.printStackTrace();
		}
	}
	@Override
	public ShapesGroup create(ShapesGroup obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO SHAPESGROUPS(name,id)"
												+ " VALUES(?,?)");
			prepare.setString(1,obj.getName());
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
	public ShapesGroup update(ShapesGroup obj) {
	    connect = DAO.getConnection();
	    PreparedStatement update =  null;
	    String updateString = "update SHAPESGROUPS set name = ?, where id = ?";
	    try {
	      update = connect.prepareStatement(updateString);
	      update.setInt(1, obj.getGroupId());
	      update.setString(2, obj.getName());
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
	public ShapesGroup delete(String name) {
	    connect = DAO.getConnection();
		try{
		PreparedStatement prepare=connect.prepareStatement("delete from SHAPESGROUPS where name=?");
		prepare.setString(1,name);
		prepare.executeUpdate();
		connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ShapesGroup find(String name) {
		connect = DAO.getConnection();
		ShapesGroup c = null;
		try{
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM SHAPESGROUPS WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.next()){
			c = new ShapesGroup(result.getString("name"), result.getInt("id"));
			connect.close();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}

}
