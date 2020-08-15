package finalPriceSystem;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


 class DBConnection{ //链接数据库用,因为包含了用户密码信息使用只能包内运用
     public static Connection getConnection() throws ClassNotFoundException {  
/**
 * throws是方法可能抛出异常的声明。(用在声明方法时，表示该方法可能要抛出异常)   ；
 * 语法：[(修饰符)](返回值类型)(方法名)([参数列表])[throws(异常类)]{......}      
 * 当某个方法可能会抛出某种异常时用于throws 声明可能抛出的异常，然后交给上层调用它的方法程序处理。
 */
//此处为方法的重写，用于导入存储在代码中的URL、账号和密码
     String JDBC_DRIVER = "com.mysql.jdbc.Driver";//驱动名
     String URL = "jdbc:mysql://localhost:3306/price";//mysql.url
     String USER = "root"; //mysql.u用户名root
     String PASSWORD = "123456";//密码123456
     Connection conn = null;  //connection类属于包内

                                         //与数据库建立连接  
             Class.forName(JDBC_DRIVER);
         try {
             conn=  (Connection) DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("连接数据库");

         } catch (SQLException ex) {
             Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
         } 								//都是这样写的,是模板



        return conn;  
    }  

}
