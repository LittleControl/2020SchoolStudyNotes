package exper8;

/**
 * @author LittleControl
 * @date 2020/6/29 下午 07:52
 * @website www.littlecontrol.cn
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class CreateTable {
    public static void main(String[] args) throws Exception {
        // 1\加载驱动
        // 把com.mysql.jdbc.Driver这份字节码加载进JVM
        // 当一份字节码加载进JVM的时候，就会执行字节码文件中的静态代码块
        // 这里加载该字节码之后会实例化一个驱动器
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_db";
        String username = "root";
        String password = "zjj19970517";
        // 2\ 连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3\创建sql语句
        String sql = "create table stu (id int , name varchar(20), age int)";
        // 4\执行sql语句
        Statement st = connection.createStatement();
        int row = st.executeUpdate(sql);
        // 5\释放
        st.close();
        connection.close();

    }
}
