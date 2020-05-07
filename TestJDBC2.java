package java_0507;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestJDBC2 {
    private static void testInsert() throws SQLException {
        // 0. 准备工作,需要先在数据库中创建好数据库和数据表
        // 1. 创建 DataSource 对象,程序级的,每个程序创建一个
        // "单例"
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性,为和数据库建立连接做准备
        // MySQL 是个服务器,需要知道 ip 地址,端口号
        // 以及要访问的数据库名,以及用户名和密码
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java15_0506?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1120");
        // 3. 创建 Connection 对象,用来表示和数据库建立了一次连接
        Connection connection = dataSource.getConnection();
        // 4. 连接建立成功就可以操作数据库了,拼装 SQL 语句
        // ? 是占位符,可以替换
        String sql = "insert into student values(?, ?)";
        // statement 用来辅助拼装 SQL setXXX 的类型和数据库表的类型匹配
        // ? 的下标从 1 开始计算
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "蔡徐坤");
        statement.setInt(2, 20);
        System.out.println(statement);
        // 5. 执行 SQL
        int ret = statement.executeUpdate();
        System.out.println(ret);
        // 6. 释放相关资源
        statement.close();
        connection.close();
    }

    private static void testSelect() throws SQLException {
        // 0. 准备好库和表
        // 1. 创建 DataSource 对象
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性,为和数据库建立连接做准备
        // MySQL 是个服务器,需要知道 ip 地址,端口号
        // 以及要访问的数据库名,以及用户名和密码
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java15_0506?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1120");
        // 3. 建立连接
        Connection connection = dataSource.getConnection();
        // 4. 拼装 SQL 语句
        String sql = "select * from student";
        PreparedStatement statement = connection.prepareStatement(sql);
        // 5. 此处没有 ? 不需要替换,直接执行
        ResultSet resultSet = statement.executeQuery();
        // 6. 遍历结果集合
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            System.out.println(name + ":" + age);
        }
        // 7. 释放资源,顺序不能颠倒
        // 先创建的要后释放
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        testSelect();
    }
}
