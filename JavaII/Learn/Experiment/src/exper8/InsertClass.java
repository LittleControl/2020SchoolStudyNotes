package exper8;

/**
 * @author LittleControl
 * @date 2020/6/29 下午 07:53
 * @website www.littlecontrol.cn
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
public class InsertClass {
    public static void main(String[] args) {
        // ================ 插入数据 ================
        Connection conn = null;
        Statement st = null;
        try {
            // 1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、创建连接
            String url = "jdbc:mysql://localhost:3306/mytest";
            String user = "root";
            String password = "zjj19970517";
            conn = DriverManager.getConnection(url, user, password);
            // 3、创建sql语句
            String sql = "insert into stu values(1, 'zjj', 20)";
            st = conn.createStatement();
            // 4、执行语句
            int row = st.executeUpdate(sql);
            System.out.println(row);
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 5、释放
            if(st!=null) {
                try {
                    st.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null) {
                try {
                    conn.close();
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
