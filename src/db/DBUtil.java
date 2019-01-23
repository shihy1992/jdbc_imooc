package db;

import java.sql.*;

/**
 * @ClassName: DBUtil.java
 * @Description:
 * @Version: v1.0.0
 * @author: shihy
 * @date 2019Äê01ÔÂ23ÈÕ
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/imooc";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private static  Connection conn = null;

    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static  Connection getConnection() {
        return conn;
    }

    public static void main(String[] args) throws Exception {


        Statement sta = conn.createStatement();
        ResultSet res = sta.executeQuery("select t.*  from imooc_goddess t");
        while (res.next()) {
            System.out.println(res.getString("user_name") + res.getString("age") + res.getString("birthday"));
        }

    }
}
