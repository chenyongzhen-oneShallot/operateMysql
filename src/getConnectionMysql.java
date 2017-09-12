

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.net.ssl.SSLEngineResult.Status;

public class getConnectionMysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//链接数据�?
		try{
			Class.forName("com.mysql.jdbc.Driver");//调用Class.forName()方法加载驱动程序
			System.out.println("成功加载mysql驱动");
		}catch(ClassNotFoundException e1){
			System.out.println("找不到MySQL驱动!");
            e1.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/mysql";
		String username="root";
		String password="user@123";
		//调用DriverManager对象的getConnection()方法，获得一个Connection对象
		Connection conn;
		try{
			conn=DriverManager.getConnection(url,username,password);
			Statement stmt=conn.createStatement();//创建Statement对象
			System.out.println("成功链接到数据库");
			stmt.close();
			conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

	}
}
