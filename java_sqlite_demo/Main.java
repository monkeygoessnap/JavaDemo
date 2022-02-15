//make sure sqlite jar file in classpath
//javac Main.java
//java -classpath ".;sqlite-jdbc-3.36.0.3.jar" Main
//make sure SQLexception is caught (error handling), if not program compilation will throw error

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Connection c = null;
        Statement stmt = null;
        try {
           Class.forName("org.sqlite.JDBC");
           c = DriverManager.getConnection("jdbc:sqlite:demo.db");
           c.setAutoCommit(false);
           System.out.println("Opened database successfully");
     
           stmt = c.createStatement();
           ResultSet rs = stmt.executeQuery( "SELECT * FROM users;" );
           
           while ( rs.next() ) {
              int id = rs.getInt("id");
              String  name = rs.getString("username");
              String pw  = rs.getString("password");
              
              System.out.println( "ID = " + id );
              System.out.println( "NAME = " + name );
              System.out.println( "PASSWORD = " + pw );

           }
           rs.close();
           stmt.close();
           c.close();
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName() + ": " + e.getMessage() );
           System.exit(0);
        }
        System.out.println("Operation done successfully");
       }
}
