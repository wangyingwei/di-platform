<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%  
    String path = request.getContextPath();  
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";  
%>
<html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<base target="rightfrm">
</head>
<body class="left">
    <h3>Left Frame Page</h3>
	<table border="0" cellspacing="0" cellpadding="0" align="center">
		<tr>
			<td valign="top">
				<ul class="">
				    <li><a>Demo管理</a></li>
				</ul>
				<ul>
					<li><a href="<%=basePath %>demo/listAll" target="mainFrame">Demo列表</a></li>
				</ul>
				
				<ul class="">
					<li><a>用户管理</a></li>
				</ul>
				<ul>
					<li><a href="<%=basePath %>user/userListAll" target="mainFrame">用户列表</a></li>
				</ul>

			</td>
		</tr>

		<tr>

		</tr>
		<tr>

		</tr>
	</table>

</body>
</html>

