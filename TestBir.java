package java_0508;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestBir {
    private static void testInsert() throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0508?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1120");
        Connection connection = dataSource.getConnection();
        String sql = "insert into bir values(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "张海龙");
        statement.setInt(2, 1999);
        statement.setInt(3, 10);
        statement.setInt(4, 21);
        statement.setString(1, "宋寒冬");
        statement.setInt(2, 1998);
        statement.setInt(3, 12);
        statement.setInt(4, 05);
        statement.setString(1, "张智彬");
        statement.setInt(2, 1999);
        statement.setInt(3, 03);
        statement.setInt(4, 02);
        statement.setString(1, "纪然");
        statement.setInt(2, 1998);
        statement.setInt(3, 05);
        statement.setInt(4, 04);
        statement.setString(1, "赵子恒");
        statement.setInt(2, 1997);
        statement.setInt(3, 11);
        statement.setInt(4, 20);
        statement.setString(1, "朱梓瑞");
        statement.setInt(2, 1999);
        statement.setInt(3, 03);
        statement.setInt(4, 26);
        System.out.println(statement);
        int ret = statement.executeUpdate();
        System.out.println(ret);
        statement.close();
        connection.close();
    }

    private static void testSelect() throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0508?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1120");
        Connection connection = dataSource.getConnection();
        String sql = "select * from bir";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int year = resultSet.getInt("year");
            int month = resultSet.getInt("month");
            int day = resultSet.getInt("day");
            System.out.println(name + ":" + year + "-" + month + "-" + day);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    private static void testOrder() throws SQLException {
        DataSource dataSource = new MysqlDataSource();
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java_0508?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1120");
        Connection connection = dataSource.getConnection();
        String sql = "select name from bir order by bedNum asc";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            String name = resultSet.getString("name");
            int bedNum = resultSet.getInt("bedNum");
            System.out.println(name + ":" + bedNum);
        }
        resultSet.close();
        statement.close();
        connection.close();
    }

    public static void main(String[] args) throws SQLException {
        //testSelect();
        testOrder();
        //testInsert();
    }
}
