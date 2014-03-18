import java.sql.*;

public class Sql {
	   Connection conn;
		
		public void close(){
			
			try {
				conn.close();  // disconnects from database
				System.out.println("Closing Database Connection");
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		
		public void connect(){
			try {
				Class.forName("org.h2.Driver");
				conn = DriverManager.getConnection("jdbc:h2:"+ // Protocol
				System.getProperty("user.dir") +"/movies", //db file path
				"sa", //user
				""); //password
				
				//conn.close(); // disconnects from database
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		public void create(){
			try {
				Statement statement = conn.createStatement();
				statement.execute("create table actor("+
						"id varchar(100),"+
						"name varchar(100),"+
						"constraint pk_actor_id primary key(id));");
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
			
		public static void main(String[] args) 
		  { 
			Sql h2 = new Sql();
			h2.connect();
			
			h2.close();
		  }
	}
	
	
