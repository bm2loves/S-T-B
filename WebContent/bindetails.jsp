<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.util.List" %>
     <%@ page import="stbbean.Trashbindetails" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Smart Trash-Bin</title>
</head>

<%
List<Trashbindetails> bindetails = (List<Trashbindetails>)request.getAttribute("bindetails");
%>
<body>
	
<font size="5" color="white">Trash-Bin Details</font>

<BR>
			<table border="2">
			<tr>
			
			<td><font size="2" color="#00FF00">Sno.</font></td>
			<td><font size="2" color="#00FF00">Bin Id</font></td>
			<td><font size="2" color="#00FF00">Bin Name</font></td>
			<td><font size="2" color="#00FF00">Location</font></td>
			<td><font size="2" color="#00FF00">Status</font></td>
			<td><font size="2" color="#00FF00">Build on</font></td>
			
			</tr>
			<%
			int i=0;
			for(Trashbindetails stbdetails : bindetails){
				%>
				<tr>
				<td><font color="black"><%=i=i+1 %></font></td>
				<td><font color="black"><%=stbdetails.getBinId() %></font></td>
				<td><font color="black"><%=stbdetails.getBinName() %></font></td>
				<td><font color="black"><%=stbdetails.getLocation() %></font></td>
				<td><font color="black"><%=stbdetails.getStatus() %></font></td>
				<td><font color="black"><%=stbdetails.getInstdt() %></font></td>
				
			</tr>
				<%
			}
			%>
		</table>
		
		<form action="stbwelcome.html"><input type="submit" value="Search more!"></form>
</body>
</html>