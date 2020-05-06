package java_0506;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        // 0. 准备工作,需要先在数据库中创建好数据库和数据表
        // 1. 创建 DataSource 对象,这个对象是"程序级",每个程序创建一个 DataSource 即可
        // 单例
        DataSource dataSource = new MysqlDataSource();
        // 2. 设置 dataSource 的属性,为和数据库建立连接做准备
        // MySQL 是个服务器,要想访问 MySQL, 需要知道 MySQL 的 ip 地址,端口号
        // 以及想要访问的数据库名,以及用户名和密码
        ((MysqlDataSource)dataSource).setURL("jdbc:mysql://127.0.0.1:3306/java15_0506?characterEncoding=utf8&useSSL=true");
        ((MysqlDataSource)dataSource).setUser("root");
        ((MysqlDataSource)dataSource).setPassword("1120");
        // 3. 创建 Connection 对象,用来表示和数据库建立了一次连接
        Connection connection = dataSource.getConnection();
        // 4. 可以操作数据库了,核心就是拼装 SQL 语句
        // ? 是占位符,可以把具体的变量替换到 ? 的位置上
        // 此处并没有真的执行 SQL
        String sql = "insert into student values(?, ?)";
        // statement 是用来辅助拼装 SQL 的, setXXX 的类型需要和数据库表的类型匹配
        // ? 的下标从 1 开始算
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, "蔡徐坤");
        statement.setInt(2, 20);
        System.out.println(statement);
        // 5. 执行 SQL
        int ret  = statement.executeUpdate();
        System.out.println(ret);
        // 6. 释放相关资源,一定是先释放 statement, 再释放 connection,顺序不能错
        statement.close();
        connection.close();
    }

    private static void testSelect() {

    }
}
