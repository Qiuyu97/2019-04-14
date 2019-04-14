<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 
		EL表达式，是一种内容的描述格式，目的是提供jsp开发时候，简化代码的
		【只能jsp使用】
	 -->

	<%
		int x = 5;
	%>
	<!-- 输出这个变量的值 -->
	<% out.print(x); %><!-- 调用内置对象out -->

	<%= x %><!-- 简易写法 -->

	<!-- EL表达式
		 它不能直接操作代码中的信息，
		 需要通过表达式加入的内容，必须添加到上下文中
		 pageContext.setAttribute()
	 -->
	 <%
	 	pageContext.setAttribute("x", 999);
	 %>
	<span>${x}</span>


	<hr />
	<!-- 允许对象: 用数组 -->
	<%
		pageContext.setAttribute("arr", new int[]{11,22,33,44,55,66});
	%>
	<span>${arr[0]}</span>



	<hr />
	<%
		//利用hashmap对象操作
		//这个操作支持所有class中的属性
		//前提，这个属性必须public
		HashMap<String,String> hm = new HashMap<String,String>();
		hm.put("id", "1");
		hm.put("name","admin");
		pageContext.setAttribute("user", hm);
	%>
	<span>${user.id} - ${user.name}</span>


	<hr />
	
	<%
		//如果用户的登录后，已经有一个session，
		//允许将指定的数据，加入指定的容器中
		//第三个参数就是指定的容器
		pageContext.setAttribute("userName", "manager", pageContext.SESSION_SCOPE);//session
		pageContext.setAttribute("userName", "manager", pageContext.REQUEST_SCOPE);
		pageContext.setAttribute("userName", "manager", pageContext.APPLICATION_SCOPE);
		pageContext.setAttribute("userName", "manager", pageContext.PAGE_SCOPE);
	%>
	<span>session: ${sessionScope.userName}</span><br />
	<span>application: ${applicationScope.userName}</span><br />
	<span>request: ${requestScope.userName}</span><br />
	<span>page: ${pageScope.userName}</span><br />


	<hr />
	<%
		pageContext.setAttribute("a", 5);
		pageContext.setAttribute("b", 6);
	%>
	<div>${3+6}</div>

	<div>${a+b}</div>

	<div>${a>b}</div>



















<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />
<br /><br /><br /><br /><br /><br /><br /><br /><br /><br />

</body>
</html>