import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class deleteMysql {

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
			String sql = "select *from db_database01.tb_user";
			ResultSet rs = stmt.executeQuery(sql);// 创建数据对象
			System.out.println("id" + "\t" + "账号" + "\t" + "密码");
			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.println(rs.getString(3) + "\t");
			}
			
			//删除数据
			String sql3="delete from db_database01.tb_user where id=?";
			PreparedStatement pst = conn.prepareStatement(sql3);
			pst = conn.prepareStatement(sql3);
			pst.setInt(1,1);
			pst.executeUpdate();
			
			String sql4 = "select *from db_database01.tb_user";
			ResultSet rs2 = stmt.executeQuery(sql4);

			System.out.println("id" + "\t" + "账号" + "\t" + "密码");
			while (rs2.next()) {
				System.out.print(rs2.getInt(1) + "\t");
				System.out.print(rs2.getString(2) + "\t");
				System.out.println(rs2.getString(3) + "\t");
			}
			
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
