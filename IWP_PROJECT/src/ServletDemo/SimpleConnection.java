package ServletDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SimpleConnection {

public Connection EstablishingConnection() {
		
		Connection con=null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			
			Properties p=new Properties();
			p.put("user","hr");
			p.put("password","hr");
			
			String url="jdbc:oracle:thin:@localhost:1521:XE";
			
			String username="hr";
			String password="hr";
			
			//DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","anonymous","hr");
			//DriverManager.getConnection(url,username,password);
			//DriverManager.getConnection(p);
			con=DriverManager.getConnection(url, p);
			
			System.out.println("connection established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;	
	}
	/*public static void main(String[] args) {
	
		SimpleConnection c=new SimpleConnection();
		c.EstablishingConnection();
	}*/
}


/*public class SimpleConnection {

	public static void main(String[] args) {
		
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver Loaded");
			
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","hr","hr");
			//DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-7AO1QST:1521:XE");
			System.out.println("connection established");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Statement stmt;
		try {
			stmt=con.createStatement();
			String sql="select USERNAME from empdetails";
			
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			//stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}*/

