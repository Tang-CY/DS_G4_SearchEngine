
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WELCOME TO PORSCHE'S WORLD</title>
<input type ="button" onclick="javascript:location.href='file:///C:/Users/IreneCV/Desktop/porsche/single.html'" value="Back to Search Page" style="width:150px;height:30px;font-size:10px;"></input>
<p align="center"><b><font style="Comic Sans MS" size="6"><font color="#BB5E00">PORSCHE SEARCH ENGINE</font></font></b></p>
<p> 
<form>
<table  border="0">
<tr>
	<p align="center"><img src="images/logo1.png" width="280" height="210"></p>
	</td>
	
</tr>

</table>
</form>
</p>
</head>
<body bgcolor="#FFEEDD">
	
<%
String[][] orderList = (String[][])  request.getAttribute("query");
for(int i =0 ; i < orderList.length;i++){%>
	<a href='<%= orderList[i][1] %>'>
	<%= orderList[i][0] %></a><br><h style="font-size:2px ;"><%= orderList[i][1] %></h><br><br>
<%
}
%>
<%System.out.println("orderlist length: "+orderList.length); %>
</body>
</html>