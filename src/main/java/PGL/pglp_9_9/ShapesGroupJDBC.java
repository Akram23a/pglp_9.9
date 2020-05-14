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
	 try {
	      connect = DAO.getConnection();
	      if(connect!= null)
	    	  System.out.println("Connected database successfully...");
	      else
	    	  System.out.println("NOPE");

	      //STEP 4: Execute a query
	      System.out.println("Creating table in given database...");
	      stmt = connect.createStatement();
	      
	      String sql = "CREATE TABLE IF NOT EXISTS shapesgroups " +
	                   "(name id(30) not NULL, " +
	                   " name VARCHAR(30), " +
	                   " PRIMARY KEY ( id ))"; 
	      stmt.executeUpdate(sql);
	      System.out.println("Created table in given database...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	        	connect.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(connect!=null)
	        	connect.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try


	}
	@Override
	public ShapesGroup create(ShapesGroup obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO shapesgroups(name,id)"
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
	    String updateString = "update shapesgroups set name = ?, where id = ?";
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
		PreparedStatement prepare=connect.prepareStatement("delete from shapesgroups where name=?");
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
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM shapesgroups WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.first()){
			c = new ShapesGroup(result.getString("name"), result.getInt("id"));
			connect.close();
		}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return c;
	}

}
