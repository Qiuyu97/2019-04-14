<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<!-- 导入jstl标签库，其中，prefix="c"就表示用户自定义的扩展标签，需要jstl进行解释的,c这个名字可以任意修改 
	 这一套内容，进行了一个命名空间的包装
	 如：InputStream OutputStream 都归 java.io
	 针对互联网内容，归类的时候，提供一个类似网址的名称
	 
	 JSTL标签库，必须配合 EL表达式
	 
-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
	//默认测试数据
	pageContext.setAttribute("x", 5);
	pageContext.setAttribute("y", 5);
	pageContext.setAttribute("id", 2);         
	pageContext.setAttribute("name", null);  
%>

<!-- 有名字，显示欢迎，没有显示超链接 -->
<c:if test="${name!=null}">
	欢迎您：${name}
</c:if>
<c:if test="${name==null}">
	<a href="#">登录</a>
</c:if>



<!-- 类似switch -->
<c:choose>
	<c:when test="${x==1}">aaa</c:when>
	<c:when test="${x==2}">bbb</c:when>
	<c:when test="${x==3}">ccc</c:when>
	<c:otherwise>没有这个项</c:otherwise>
</c:choose>



<!-- 循环
	它这个循环允许自己定义属性，可以替代所有的循环方式
	var表示定义的循环变量 类似于 for(int i)
	begin表示初始值 i=1
	end表示结束
-->
<c:forEach var="i" begin="1" end="5">
   	单独输出： <c:out value="${i}"/><br />   
</c:forEach>

<hr />
<c:forEach var="i" begin="1" end="5">
   	<input type="text" value="${i}" /> 
   	<c:if test="${i==3}"><span style="color:#ff0000;">*</span></c:if>  
   	<br />
</c:forEach>








</body>
</html>