package stbdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import stbbean.Trashbindetails;

public class Detailsofstb {
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3333/stb","root","vicky@1997"); 
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public List<Trashbindetails> tsbdetails(String BinId){
		Connection con;
		List<Trashbindetails> tsbdt=new ArrayList<Trashbindetails>();
		
		try {
			con=getConnection();
			PreparedStatement pso=con.prepareStatement("select * from trashbin where BinId=?");
			pso.setString(1, BinId);
			ResultSet rs=pso.executeQuery();
			while(rs.next()) {
				Trashbindetails ud=new Trashbindetails();
				ud.setBinId(rs.getString(1));
				ud.setBinName(rs.getString(2));
				ud.setLocation(rs.getString(3));
				ud.setStatus(rs.getString(4));
				ud.setInstdt(rs.getString(5));
				tsbdt.add(ud);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tsbdt;
	}
}
