package exper8;

/**
 * @author LittleControl
 * @date 2020/6/29 下午 07:51
 * @website www.littlecontrol.cn
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO Auto-generated method stub
        // 1、加载驱动
        // 把com.mysql.jdbc.Driver这份字节码加载进JVM
        // 当一份字节码加载进JVM的时候，就会执行字节码文件中的静态代码块
        // 这里加载该字节码之后会实例化一个驱动器
        Class.forName("com.mysql.jdbc.Driver");
        // 2、连接
        String url = "jdbc:mysql://localhost:3306/mytest";
        String username = "root";
        String password = "lzt20000323";
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3、验证连接
        System.out.println(connection); // 如果有输出，表明连接成功
    }
}
