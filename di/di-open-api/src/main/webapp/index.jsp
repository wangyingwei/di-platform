<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Open Api</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript">
	    
</script>
	
</head>
<body>
	<h1>SunReal Open Api System!</h1>
	<br />
	<h2>晟融数据开放平台</h2>
	<br />
	参考：淘宝开放平台/用户API
	<br />
	网址：https://open.taobao.com/docs/api_list.htm?spm=a219a.7386653.1.22.rfkK4L
       <table border="1">
           <tr>
	           <td align="center">API列表</td>
	           <td align="center">类型（收费/免费）</td>
	           <td align="center">描述</td>
	       </tr>
	       <tr>
	           <td align="left">http://localhost:8082/api/demo/</td>
	           <td align="left">免费</td>
	           <td align="left">get，获取全部demo数据</td>
	       </tr>
	       <tr>
	           <td align="left">http://localhost:8082/api/demo/id</td>
	           <td align="left">免费</td>
	           <td align="left">get，获取单个demo数据</td>
	       </tr>
	       <tr>
	           <td align="left">http://localhost:8082/api/demo/</td>
	           <td align="left">免费</td>
	           <td align="left">post（附带json格式的demo数据），新建一个demo</td>
	       </tr>
	       <tr>
	           <td align="left">http://localhost:8082/api/demo/</td>
	           <td align="left">免费</td>
	           <td align="left">put（附带json格式的demo数据），更新一个demo</td>
	       </tr>
	       <tr>
	           <td align="left">http://localhost:8082/api/demo/id</td>
	           <td align="left">免费</td>
	           <td align="left">detete删除一个demo</td>
	       </tr>
       </table>
</body>
</html>