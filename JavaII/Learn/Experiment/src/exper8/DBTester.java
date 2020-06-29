package exper8;

import java.sql.*;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * @author LittleControl
 * @date 2020/6/29 下午 06:59
 * @website www.littlecontrol.cn
 */
public class DBTester {
    public static void main(String[] args) throws Exception {
        Connection con;
        Statement stmt;
        ResultSet rs;
        Class.forName("com.mysql.jdbc.Driver");
        //注册mysql的驱动
        DriverManager.registerDriver(new Driver());
        String dbUrl = "jdbc:mysql://localhost:3306/STOREDB";
        String dbUser = "dbuser";
        String dbPwd = "1234";
        //连接数据库
        con = java.sql.DriverManager.getConnection(dbUrl, dbUser, dbPwd);
        stmt = con.createStatement();
        String name1 = new String("Wang".getBytes("GB2312"), "ISO-8859-1");
        String address1 = new String("Shanghai".getBytes("GB2312"), "ISO-8859-1");
        stmt.executeUpdate("insert into CUSTOMERS(NAME, AGE, ADDRESS" + "VALUES('"+ name1 + "', 20,'"+address1+"')");
        rs = stmt.executeQuery("select ID, NAME, AGE, ADDRESS from CUSTOMERS");
        while(rs.next()){
            long id = rs.getLong(1);
            String name = rs.getString(2);
            int age = rs.getInt(3);
            String address = rs.getString(4);
            if(name != null) {
                name = new String(name.getBytes("ISO-8859-1"), "GB2312");
            }
            if(address != null) {
                address = new String(address.getBytes("ISO-8859-1"), "GB2312");
            }
            System.out.println("id="+id+",name="+name+",age="+age+",address="+ address);
        }
        stmt.executeUpdate(("delete from CUSTOMERS where name='"+name1+"'"));
        rs.close();
        stmt.close();
        con.close();
    }

    private static class Driver implements java.sql.Driver {
        @Override
        public Connection connect(String url, Properties info) throws SQLException {
            return null;
        }

        @Override
        public boolean acceptsURL(String url) throws SQLException {
            return false;
        }

        @Override
        public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
            return new DriverPropertyInfo[0];
        }

        @Override
        public int getMajorVersion() {
            return 0;
        }

        @Override
        public int getMinorVersion() {
            return 0;
        }

        @Override
        public boolean jdbcCompliant() {
            return false;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    }
}
