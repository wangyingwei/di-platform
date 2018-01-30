<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>USER LIST</title>
<script type="text/javascript">
		window.onload=function(){
				
		}
</script>
</head>
<body>
    <h1>User List Page</h1>
    <br/>
    ${InfoMessage}
    <c:if test="${param.flag==1}">
    		删除User成功
    </c:if>
    <c:if test="${param.flag==0}">
    		删除User失败
    </c:if>
    <br/>
    <input type="button" value="新建" onclick="window.location.href='<%=basePath%>user/addUser'" />
    	<table border="1">
    	<tr>
    		<td>id</td>
    		<td>用户名</td>
    		<td>密码</td>
    		<td>年龄</td>
    		<td>性别</td>
    		<td>操作</td>
    	</tr>
		<c:forEach var="user"  items="${userList}">
		  	<tr>
		  		<td>${user.id}</td>
		  		<td>${user.userName}</td>
		  		<td>${user.password}</td>
		  		<td>${user.age}</td>
		  		<c:if test="${user.gender==0}">
		  				<td>男</td>
		  		</c:if>
		  		<c:if test="${user.gender==1}">
		  				<td>女</td>
		  		</c:if>
		  		<td>
		  		<a href="editUser?id=${user.id}">编辑</a>
		  		<a href="deleteUser?id=${user.id}">删除</a>
		  		</td>
		  	</tr>
	   	</c:forEach> 
	</table>
</body>
</html>