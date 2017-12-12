import com.hsb.practice.annotation.example1.entity.Apple;
import com.hsb.practice.annotation.example1.util.AnnotationUtil;
import com.hsb.practice.annotation.example2.HelloAnnotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@HelloAnnotation(say = "Hello World")
public class MainTest {
    private static void test1() {
        String sql = null;
        try {
            sql = AnnotationUtil.createTable(Apple.class);
        } catch (Exception e) {
            System.out.println("解析sql语句失败");
            e.printStackTrace();
        }
        System.out.println(sql);
        Connection connection = getConnection();
        if (connection != null) {
            try {
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.executeUpdate();
                System.out.println("创建成功！");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("执行创建表语句失败1");
            }
        }else {
            System.out.println("执行创建表语句失败2");
        }
    }

    private static Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/annotation","root","");
        } catch (Exception e) {
            System.out.println("数据库链接失败3");
        }
        return connection;
    }

    private static void test2() {
        HelloAnnotation annotation = MainTest.class.getAnnotation(HelloAnnotation.class);
        System.out.println(annotation.say());
    }

    public static void main(String[] args) {
        test2();
    }
}