package sqlBaisc;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import usersManager.user;

public class sqlBasic {
	public static Connection connect = null;

	public sqlBasic() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // ¼ÓÔØMYSQL JDBCÇý¶¯³ÌÐò
			// Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("Success loading Mysql Driver!");
		} catch (Exception e) {
			System.out.print("Error loading Mysql Driver!");
			e.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp?useSSL=false", "visitorIDEA",
					"Idea1234");
		} catch (SQLException e) {
			System.out.println("SQLException : " + e);
		}

	}

	public static int change(String s) {
		try {
			System.out.println(s+"will be change");
			Statement ps = connect.createStatement();
			int m = ps.executeUpdate(s);
			System.out.println("checked " + m);
			ps.close();
			return m;
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}

	}

	private static ResultSet query(String s) {
		try {
			System.out.println(s+"will be query");
			Statement ps = connect.createStatement();
			ResultSet r = ps.executeQuery(s);
			//ps.close();
			return r; 

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public static user sqlSetUser(String s) {
		ResultSet r = query(s);
		user u = new user();
		try {
			while (r.next()) {
				u.setId(r.getInt(1));
				u.setName(r.getString(2));
				u.setMonth(r.getString(3));
			}
			r.close();
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public void close() {
		try {
			connect.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
	}

	public String totalInfo(String s) {
		// TODO Auto-generated method stub		
		int sm=0,sr1=0,su=0,sr2=0;
		su = (s.length()>32)?2:1;
		ResultSet r = query(s.substring(0, 31));
		int m = Integer.parseInt(s.substring(31,31+su))-1;
		su=0;
		try {
			while (r.next()) {
				sm++;
				switch(r.getString(1).charAt(m)) {
				case '0':
					su++;
					break;
				case '1':
					sr1++;
					break;
				case '2':
					sr2++;
					break;
				}
			}
			String rs = sm+","+sr1+","+sr2+","+su+",";
			System.out.println("total"+rs);
			r.close();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
