package sunseng.weekend.midterm;

import java.sql.*;

   public class ConnectionManager {

      static Connection con;
      static String url;
            
      public static Connection getConnection()
      {

         try
         {
            String url = "jdbc:mysql://localhost:3306/customer_managment"; 
            // assuming "DataSource" is your DataSource name

            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Class.forName("com.mysql.jdbc.Driver");
            //Class.forName("com.mysql.fabric.jdbc.FabricMySQLDriver");
            
            try
            {            	
               con = DriverManager.getConnection(url,"root","092522087"); 
                								
            // assuming your SQL Server's	username is "username"               
            // and password is "password"
                 
            }
            
            catch (SQLException ex)
            {
               ex.printStackTrace();
            }
         }

         catch(ClassNotFoundException e)
         {
            System.out.println(e);
         }
         
      return con;
}
}