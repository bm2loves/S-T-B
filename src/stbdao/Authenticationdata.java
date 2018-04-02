package stbdao;

import java.sql.*;

public class Authenticationdata {
	public static Connection getConnection() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3333/stb","root","vicky@1997");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static boolean checkit(String Authname,String Authpass) {
		Connection con =getConnection();
		boolean status=false;
		try {
			 PreparedStatement authch=con.prepareStatement("select * from Auth where Authname=? and Authpass=?");
			 authch.setString(1, Authname);
			 authch.setString(2, Authpass);
			 
			 ResultSet authrs=authch.executeQuery();
			 while(authrs.next()) {
				 if(status=true) {
					 authrs.getString(1);
					 authrs.getString(2);
				 }
			 }
		}catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
