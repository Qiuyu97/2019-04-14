# 2019-04-14
单例模式 _拦截器Filter_EL表达式_JSPL标签库
 
 
##【Web应用程序的开发】
	
1、必须熟练，必须明确知道的：

	Servlet，Jsp，Session，Cookie，Request, Response

2、必须能够清楚且通顺的说明很多内容的原理及概念。【背】

======================================================

Request：是客户端发送的一个请求的具体的类对象，
	它里面收集了有关客户端请求的信息。

Response：是服务器对于客户端一个处理响应的类对象，
	它里面主要是针对服务器面向客户端浏览器进行的各种操作。

Cookie：是保留在客户端电脑中的一个变量，具体位置由浏览器决定的。
	它只能保存一个具体的字符串String信息。
	它是有时效的，通过设置时效进行存储，超过时效的，将由浏览器自动删除。
	Cookie会自动的与网站对应。网站创建cookie的时候，会自动记录网址域名的。

Session：保留在服务器内存上的一个会话级变量，
	客户端与服务器之间产生的各种交互连接，完整的一次request-response称之为一次会话。
	session有生命周期，
		服务器默认时间超过且无会话，自动删除
		会话过程中，任意一方离线，自动删除
		服务器自动删除内容为null的session


Application：服务器端应用程序级的变量，作用于整个应用程序，
	同名的只会创建一个，服务器重启后，变量消失。(投票，活动访问量...)


jsp：是由java代码和html组合的一个动态网页，
	它是一个特殊的Servlet，默认在编译的时候，自动创建好九大内置对象提供使用。
	它不是预编译的，每一次请求，服务器实时编译。


Servlet：运行在服务器端的一个java程序，一个类对象，继承于 HttpServlet 父类，
	它是纯java代码的产物。
	它必须预先编译好，把.java ----> .class字节码文件
	然后发布网站，这个字节码文件会到：WebContent/WEB-INF/classes/..
	
	
--------------------------------------------------------------------------------
客户端浏览器请求的servlet，实际上服务器上是一个多线程格式。
服务器会为每一个请求创建一个线程Thread，
只要客户端关闭浏览器，表示线程终止，服务器就知道结束会话可以删session了。
每一个线程中，访问的Servlet，它是一个单例模式的对象。
第一次访问，创建，
以后每一次访问，都是之前创建好的。


## JSP中一共预先定义了9个这样的对象，分别为：request、response、session、application、out、pagecontext、config、page、exception

1、request对象javax.servlet.http.HttpServletRequest
request对象代表了客户端的请求信息，主要用于接受通过HTTP协议传送到服务器的数据。（包括头信息、系统信息、请求方式以及请求参数等）。
request对 象的作用域为一次请求。

当Request对象获取客户提交的汉字字符时，会出现乱码问题，必须进行特殊处理。

Request常用的方法：getParameter(String strTextName) 获取表单提交的信息.


getProtocol() 获取客户使用的协议
String strProtocol=request.getProtocol();


getServletPath() 获取客户提交信息的页面。
String strServlet=request.getServletPath();

getMethod() 获取客户提交信息的方式 
String strMethod=request.getMethod();

getHeader() 获取HTTP头文件中的accept,accept-encoding和Host的值,
String strHeader=request.getHeader();

getRermoteAddr() 获取客户的IP地址。
String strIP=request.getRemoteAddr();

getRemoteHost() 获取客户机的名称。
String clientName=request.getRemoteHost();

getServerName() 获取服务器名称。 
String serverName=request.getServerName();

getServerPort() 获取服务器的端口号。 
int serverPort=request.getServerPort();

getParameterNames() 获取客户端提交的所有参数的名字。 




2、response对象 javax.servlet.http.HttpServletResponse
response 代表的是对客户端的响应，主要是将JSP容器处理过的对象传回到客户端。
response对象也具有作用域，它只在JSP页面内有效。



3、session对象 javax.servlet.http.HttpSession
Session对象是一个JSP内置对象，它在第一个JSP页面被装载时自动创建，完成会话期管理。从一个客户打开浏览器并连接到服务器开始，到客户关闭浏览器离开这个服务器结束，被称为一个会话。当一个客户访问一个服务器时，可能会在这个服务器的几个页面之间切换，服务器应当通过某种办法知道这是一个客户，就需要Session对象。

当一个客户首次访问服务器上的一个JSP页面时，JSP引擎产生一个Session对象，同时分配一个String类型的ID号，
JSP引擎同时将这换个ID号发送到客户端，存放在Cookie中，
这样Session对象，直到客户关闭浏览器后，服务器端该客户的Session对象才取消，并且和客户的会话对应关系消失。
当客户重新打开浏览器再连接到该服务器时，服务器为该客户再创建一个新的Session对象。

session 对象是由服务器自动创建的与用户请求相关的对象。
服务器为每个用户都生成一个session对象，用于保存该用户的信息，跟踪用户的操作状态。



4、application对象javax.servlet.ServletContext
application 对象可将信息保存在服务器中，直到服务器关闭，否则application对象中保存的信息会在整个应用中都有效。
与session对象相比，application对象生命周期更长，类似于系统的“全局变量”。

服务器启动后就产生了这个Application对象，当客户再所访问的网站的各个页面之间浏览时，这个Application对象都是同一个，直到服务器关闭。
但是与Session对象不同的时，所有客户的Application对象都时同一个，即所有客户共享这个内置的Application对象。




5、out 对象javax.servlet.jsp.jspWriter
out 对象用于在Web浏览器内输出信息，并且管理应用服务器上的输出缓冲区。
在使用 out 对象输出数据时，可以对数据缓冲区进行操作，及时清除缓冲区中的残余数据，为其他的输出让出缓冲空间。
待数据输出完毕后，要及时关闭输出流。



6、pageContext 对象javax.servlet.jsp.PageContext
pageContext 对象的作用是取得任何范围的参数，通过它可以获取 JSP页面的out、request、reponse、session、application 等对象。



7、config 对象javax.servlet.ServletConfig
config 对象的主要作用是取得服务器的配置信息。通过 pageConext对象的 getServletConfig() 方法可以获取一个config对象。当一个Servlet 初始化时，容器把某些信息通过 config对象传递给这个 Servlet。开发者可以在web.xml 文件中为应用程序环境中的Servlet程序和JSP页面提供初始化参数。



8 page 对象
page 对象就是表示当前整个jsp页面，每一个jsp页面都是一个独立的page对象。



9、exception 对象java.lang.Throwable
exception 对象的作用是显示异常信息，只有在包含 isErrorPage="true" 的页面中才可以被使用，在一般的JSP页面中使用该对象将无法编译JSP文件

##JSP网页中的：EL表达式：
	EL（Expression Language） 是为了使JSP写起来更加简单。
	表达式语言的灵感来自于 ECMAScript 和 XPath 表达式语言，
	它提供了在 JSP 中简化表达式的方法，让Jsp的代码更加简化。

	语法格式：
		
		${......}


【直接操作】
直接保存在page中：	<% pageContext.setAttribute("user", "aaa"); %>	
直接提取：		${user}




【保存到指定容器中】
	<% pageContext.setAttribute("username", "zhangsan1", pageContext.SESSION_SCOPE); %>
	<% pageContext.setAttribute("username", "zhangsan2", pageContext.PAGE_SCOPE); %>
	<% pageContext.setAttribute("username", "zhangsan3", pageContext.APPLICATION_SCOPE); %>
	<% pageContext.setAttribute("username", "zhangsan4", pageContext.REQUEST_SCOPE); %>
	 
	//从对应容器中提取 
  	${requestScope.username} 
  	${sessionScope.username} 
  	${applicationScope.username} 
  	${pageScope.username} 





【具有索引的对象：数组，ArrayList，LinkedList】
	<%
		int[] arr = {1,2,3,4,5};
		pageContext.setAttribute("arr",arr);
	%>

	${arr[0]}
	${arr[1]}




【具有键值对集合对象：HashMap】
	<%
		Map map = new HashMap();
      	 	map.put("lesson1", "java");
      	 	map.put("lesson2", "sql");
      	 	map.put("lesson3", "linux");
      	 	map.put("aa.bb.cc", "linux");      	 
    		pageContext.setAttribute("map", map);
	%>

	${map.lesson1 }
	${map.lesson2 }
	${map.lesson3 }
	${map["aa.bb.cc"] }




【类对象】
      <%
      		Person p = new Person();
      		p.setAge(18);
      		p.setName("如花");
      		//将数据存入page容器中
      		pageContext.setAttribute("p", p);
       %>
      ${p} 
      ${p.age }  或  ${p["age"] }
      ${p.name } 或  ${p["name"] }
     
      可以使用点的地方，都可以使用中括号。
      


【运算操作】
	所有运算符都可以运算，也支持变量

	${10%3}

	${a-b}

	${x>=5&&y<=6}


==============================================
JSP中的JSTL标签库：

	从JSP 1.1规范开始JSP就支持使用自定义标签，
	使用自定义标签大大降低了JSP页面的复杂度，
	同时增强了代码的重用性，因此自定义标签在WEB应用中被广泛使用。
	许多WEB应用厂商都开发出了自己的一套标签库提供给用户使用，
	这导致出现了许多功能相同的标签，
	令网页制作者无所适从，不知道选择哪一家的好。
	为了解决这个问题，Apache Jakarta小组归纳汇总了那些网页设计人员经常遇到的问题，
	开发了一套用于解决这些常用问题的自定义标签库，
	这套标签库被SUN公司定义为标准标签库（The JavaServer Pages Standard Tag Library），
	简称JSTL。
	由于JSTL是在JSP 1.2规范中定义的，
	所以JSTL需要运行在支持JSP 1.2及其更高版本的WEB容器上，例如，Tomcat 5.5。



lib中加入jar包文件
导入标签库：<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
所有标签库中的元素，利用c表示，从里面调用



<c:if test="${false}">
aaaaa
</c:if>


<c:choose>
	<c:when test="${x==1}">aaa</c:when>
	<c:when test="${x==2}">bbb</c:when>
	<c:when test="${x==3}">ccc</c:when>
	<c:otherwise>没有这个项</c:otherwise>
</c:choose>


<c:forEach var="i" begin="1" end="5">
   Item <c:out value="${i}"/>
</c:forEach>

==============================================================================


【企业应用实际情况】

JSTL和EL的使用需要看企业具体情况,实际上servlet开发用的相对比较多, 
如果使用框架开发就几乎不用了, 
不过就算用servlet开发,一般也不会在jsp中写java的代码,
使用JS脚本+Ajax技术就可以实现比JSTL+EL更强大的功能，
而且可是完全，且正真的实现html与java代码分离。网页直接就是html。

jsp本身是可有可无的，它仅仅用于展示数据，只要没有业务逻辑就符合编码规范了，
标签库就更加是可选项，
因为仅仅为了使代码看上去和页面语言融为一体而使用另一种作用近乎相同的语言，
这样做代价太大，得不偿失。



















