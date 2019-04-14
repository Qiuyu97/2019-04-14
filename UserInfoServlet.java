package com.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserInfoServlet
 */
@WebServlet("/userinfo")
public class UserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//按照路径中的一个id，获取指定id的用户信息
		
		//如果路径中没有id，这里不允许操作
		
		String id = request.getParameter("id");
		
		response.getWriter().println("您要看的用户编号是：" + id);
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
