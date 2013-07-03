package forum;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Julia
 */
public class ConnectPostgre {
    private static Connection db;//connections will be stored here
    private static Statement sql;//requests will be run by this object
    
    private static String database = "forum";//database name
    private static String username = "postgres";//this is user name (in database),
                           
    private static String password = "11";//password for database

//This method is for the connection establishing:
    private static boolean connect(){
    	
    	try{
    		Class.forName("org.postgresql.Driver");//load JDBC 
                                 
    		db = DriverManager.getConnection("jdbc:postgresql:"+database,
    				username,
    				password);
    		
    		return true;
    	} catch (Exception ex){
            System.out.println("Eeexxappppption: "+ex);
    		return false;
    	}
    	
    }

 //This method runs request to DataBase and gets response ResultSet:
    public static ResultSet executeQuery(String query){
    	
    if(!connect()){
      System.out.println("Errrrrrrroooooorrrr!!!");
      return null;
     }
    	try {
			sql = db.createStatement();
			
			ResultSet set = sql.executeQuery(query);//request to database
			int i = 0;
			return set;
			
		} catch (SQLException e) {
                    System.out.println("======================== "+e.getMessage());
                    e.printStackTrace();
			return null;
		
                }
    }
    
    
}
