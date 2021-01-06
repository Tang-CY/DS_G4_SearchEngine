
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

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
for(int i =0 ; i < orderList.length-8;i++){%>
	<%if (orderList[i][1]!=null&&orderList[i][0]!=null) {%>
	<a href='<%= orderList[i][1] %>' >
	<%= orderList[i][0] %></a><br><br><br><% } %>
<%
}
%>
</body>
</html>