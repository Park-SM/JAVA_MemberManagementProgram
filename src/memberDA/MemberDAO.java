package memberDA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MemberDAO {
	public Connection db;
	
	public MemberDAO(String host, String port, String id, String pass) {
		String className = "org.gjt.mm.mysql.Driver";
		String url = "jdbc:mysql://" + host + ":" + port + "/java_study?useSSL=false&useUnicode=true&characterEncoding=euckr";
		
		try {
			Class.forName(className);
			this.db = DriverManager.getConnection(url, id, pass);
			System.out.println(">> Connect Success!");
		} catch (ClassNotFoundException e) {
			System.out.println(">> Failed to loading the driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(">> Connect Failed!");
			e.printStackTrace();
		}
	}
	
	public void InsertMember(String name, int age, String phone, String address) {
		try {
			Statement stmt = this.db.createStatement();
			String query = "insert into membermanagement (name, age, phone, juso) values ('" + name + "', '" + age + "', '"	 + phone + "', '" + address + "')";
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	protected void finalize() { // Override finalize() in the Object class.
		try {
			if (this.db != null && !(this.db.isClosed())) this.db.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
