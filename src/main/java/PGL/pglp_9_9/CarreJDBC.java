package PGL.pglp_9_9;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreJDBC implements DAO<Carre>{
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
	public CarreJDBC() {
		   try{
			      connect = DAO.getConnection();
			      if(connect!= null)
			    	  System.out.println("Connected database successfully...");
			      else
			    	  System.out.println("NOPE");

			      //STEP 4: Execute a query
			      System.out.println("Creating table in given database...");
			      stmt = connect.createStatement();
			      
			      String sql = "CREATE TABLE carres " +
			                   "(name VARCHAR(30) not NULL, " +
			                   " x DOUBLE, " + 
			                   " y DOUBLE, " + 
			                   " l DOUBLE, " + 
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
	public Carre create(Carre obj) {
		try{
		    connect = DAO.getConnection();
			PreparedStatement prepare = 
					connect.prepareStatement("INSERT INTO carres(name,x,y,l,gid)"
												+ " VALUES(?,?,?,?,?)");
			prepare.setString(1,obj.getName());
			prepare.setDouble(2,obj.getBottomLeft().getX());
			prepare.setDouble(3,obj.getBottomLeft().getY());
			prepare.setDouble(4,obj.getLength());
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
	public Carre update(Carre obj) {
	    connect = DAO.getConnection();
	    PreparedStatement update =  null;
	    String updateString = "update carres set x = ?, "
	        + "y = ?, r = ?, gid = ? where name = ?";
	    try {
	      update = connect.prepareStatement(updateString);
	      update.setDouble(1, obj.getBottomLeft().getX());
	      update.setDouble(2, obj.getBottomLeft().getY());
	      update.setDouble(3, obj.getLength());
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
	public Carre delete(String name) {
	    connect = DAO.getConnection();
		try{
		PreparedStatement prepare=connect.prepareStatement("delete from carres where name=?");
		prepare.setString(1,name);
		prepare.executeUpdate();
		connect.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Carre find(String name) {
	    connect = DAO.getConnection();
	    Carre c = null;
		try{
		PreparedStatement prepare=connect.prepareStatement("SELECT * FROM carres WHERE name=?");
		prepare.setString(1,name);
		ResultSet result =prepare.executeQuery();
		if(result.first()){
			c = new Carre( result.getString("name"), result.getInt("gid"),
					result.getDouble("l"), 
					new Point( result.getDouble("x"), result.getDouble("y")));
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
