package com.demo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.dan.Test;

/**
 * Servlet implementation class GetDanServlet
 */
@WebServlet("/getdan")
public class GetDanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//得到单例对象
		Test test1 = Test.getTest();
		Test test2 = Test.getTest();
		Test test3 = Test.getTest();
		Test test4 = Test.getTest();
		Test test5 = Test.getTest();
		Test test6 = Test.getTest();
		Test test7 = Test.getTest();
		Test test8 = Test.getTest();
		
		
		
	}

}
