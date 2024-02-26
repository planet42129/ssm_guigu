package com.atguigu.mybatis.pojo;

/**
 * @author hyh
 * @date 2024/2/2
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCDemo {
    public static void main(String[] args) {
        // 数据库URL
        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
        // 数据库用户名
        String user = "root";
        // 数据库密码
        String password = "root";

        try {
            // 加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 建立连接
            Connection con = DriverManager.getConnection(url, user, password);

            // 创建Statement对象
            Statement stmt = con.createStatement();

            // 创建表
            String createTableSQL = "CREATE TABLE IF NOT EXISTS students (" +
                    "id INT AUTO_INCREMENT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "age INT)";
            stmt.execute(createTableSQL);

            // 插入数据
            String insertSQL = "INSERT INTO students (name, age) VALUES ('Alice', 20), ('Bob', 22)";
            stmt.executeUpdate(insertSQL);

            // 查询数据
            String selectSQL = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(selectSQL);

            // 处理结果集
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Age: " + rs.getInt("age"));
            }

            // 清理环境
            rs.close();
            stmt.close();
            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Database connection or operation failure.");
            e.printStackTrace();
        }
    }
}