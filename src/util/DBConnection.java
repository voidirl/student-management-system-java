package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String url = "jdbc:mysql://localhost:3306/student_db";
    private static final String user = "root";
    private static final String password = "@rVmT0312";

    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,user,password);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
