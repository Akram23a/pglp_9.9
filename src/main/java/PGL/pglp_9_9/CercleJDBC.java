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
		   try{
			      connect = DAO.getConnection();
			      if(connect!= null)
			    	  System.out.println("Connected database successfully...");
			      else
			    	  System.out.println("NOPE");

			      //STEP 4: Execute a query
			      System.out.println("Creating table in given database...");
			      stmt = connect.createStatement();
			      
			      String sql = "CREATE TABLE CERCLES " +
			                   "(name VARCHAR(30) not NULL, " +
			                   " x DOUBLE, " + 
			                   " y DOUBLE, " + 
			                   " r DOUBLE, " + 
			                   " gid INTEGER, " + 
			                   " PRIMARY KEY ( name ))"; 
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
	public Cercle create(Cercle obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO cercles(name,x,y,r,gid)"
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
	        + "y = ?, redius = ?, groupId = ? where name = ?";
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
		PreparedStatement prepare=connect.prepareStatement("delete from cercles where name = ?");
		prepare.setString(1,name);
		prepare.executeQuery();
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
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM cercles WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.first()){
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
