<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.sql.*" %> 
 
 <html>
 <head>
 	
 	<script type="text/javascript">
 		function watchit(){
 			
 		}
 	
 	</script>
 </head> 
 <body>
	<%  
String TBnum=request.getParameter("val");  
if(TBnum==null||TBnum.trim().equals("")){  
out.print("<p>Please enter unique number provided by Trash-Bin!</p>");  
}else{  
try{  
Class.forName("com.mysql.jdbc.Driver");  
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3333/stb","root","vicky@1997");  
PreparedStatement ps=con.prepareStatement("select * from trashbin where BinId like '"+TBnum+"%'");  
ResultSet rs=ps.executeQuery();  
  
if(!rs.isBeforeFirst()) {      
 out.println("<p>No Record Found!</p>");   
}else{   
out.print("<table border='1' color='#fff' cellpadding='2' width='100%'>");  
out.print("<tr><th>BinId</th><th>BinName</th><th>Status</th><th>Watch it</th></tr>");     
while(rs.next()){  
out.print("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(4)+"</td><td><form id='view' action='Watchit?BinId='+rs.getString(1)' value='+rs.getString(1)' name='BinId'' method='get'><input type='submit' value='View'></form></td></tr>");  
}  
//out.print("<tr><td>delete</td></tr>");
out.print("</table>");  
}//end of else for rs.isBeforeFirst  
con.close();  
}catch(Exception e){out.print(e);}  
}//end of else  
%>  
</body> 
</html>