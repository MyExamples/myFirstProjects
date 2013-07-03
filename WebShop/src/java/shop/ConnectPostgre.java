package shop;

import java.sql.*;

//класс для работы с БД
public class ConnectPostgre {
    private static Connection db;//тут будут храниться подключения
    private static Statement sql;//через этот объект будут выполняться запросы
    
    private static String database = "shop";//имя базы данных
    private static String username = "postgres";//имя пользователя,
                           //через которого будет происходить подключение 
    private static String password = "11";//пароль

//метод установления подключения:
    private static boolean connect(){
    	
    	try{
    		Class.forName("org.postgresql.Driver");//загружаем JDBC 
                                //(Java Data Base Driver) драйвер - для БД 
    		db = DriverManager.getConnection("jdbc:postgresql:"+database,
    				username,
    				password);
    		
    		return true;
    	} catch (Exception ex){
            System.out.println("Eeexxappppption: "+ex);
    		return false;
    	}
    	
    }

 //Метод выполняет запрос и возвращает ResultSet:
    public static ResultSet executeQuery(String query){
    	
    if(!connect()){
      System.out.println("Errrrrrrroooooorrrr!!!");
      return null;
     }
    	try {
			sql = db.createStatement();//получаем возможность выполнить запрос в базу
			
			ResultSet set = sql.executeQuery(query);//делаем запрос в базу
			int i = 0;
			return set;
			
		} catch (SQLException e) {
                    System.out.println("======================== "+e.getMessage());
                    e.printStackTrace();
			return null;
		
                }
    }
    
}
