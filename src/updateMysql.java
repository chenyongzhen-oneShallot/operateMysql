import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class updateMysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 链接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");// 调用Class.forName()方法加载驱动程序
			System.out.println("成功加载mysql驱动");
		} catch (ClassNotFoundException e1) {
			System.out.println("找不到MySQL驱动!");
			e1.printStackTrace();
		}
		String url = "jdbc:mysql://localhost:3306/mysql";
		String username = "root";
		String password = "user@123";
		// 调用DriverManager对象的getConnection()方法，获得一个Connection对象
		Connection conn;
		try {
			conn = DriverManager.getConnection(url, username, password);
			Statement stmt = conn.createStatement();// 创建Statement对象
			System.out.println("成功链接到数据库");

			//修改数据库
			String sql2="update db_database01.tb_user set username=? where id=?";
			PreparedStatement pst = conn.prepareStatement(sql2);
			pst.setString(1,"chenyzh");//第一个参数
            pst.setInt(2,1);//第二个参数
            pst.executeUpdate();
 
			String sql = "select *from db_database01.tb_user";
			ResultSet rs = stmt.executeQuery(sql);// 创建数据对象
			System.out.println("id" + "\t" + "账号" + "\t" + "密码");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3) + "\t");
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
