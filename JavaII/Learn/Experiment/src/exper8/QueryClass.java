package exper8;

/**
 * @author LittleControl
 * @date 2020/6/29 下午 07:53
 * @website www.littlecontrol.cn
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryClass {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        // TODO Auto-generated method stub
        // ================ 查询数据 ================
        // 1\加载驱动
        // 把com.mysql.jdbc.Driver这份字节码加载进JVM
        // 当一份字节码加载进JVM的时候，就会执行字节码文件中的静态代码块
        // 这里加载该字节码之后会实例化一个驱动器
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mytest";
        String username = "root";
        String password = "zjj19970517";
        // 2\ 连接数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        // 3\创建sql语句
        String sql = "select count(*) as total from stu"; // 查询一共有几行数据
        // 4\执行sql语句
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if(rs.next()) {
            int count = rs.getInt("total");
            System.out.println(count); // 1
        }
        // 5\释放
        st.close();
        connection.close();
    }
}
