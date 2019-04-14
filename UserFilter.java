package com.demo.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, servletNames = { "*" })//*号表示所有位置的
public class UserFilter implements Filter {

    /**
     * Default constructor. 
     */
    public UserFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 拦截器执行方式：
	 * 1、Servlet，和jsp默认都已经继承HttpServlet，因此，他们都知道请求响应对象的格式
	 * 	 但是Filter是还么有进入网站，因此，它得到的是，原始的请求相应对象
	 *   doFilter(ServletRequest, ServletResponse, FilterChain)
	 *   doGet(HttpServletRequest request, HttpServletResponse response)
	 * 2、这些原始对象，在使用的时候，需要转换成对应的具体对象
	 * 3、拦截器拦截后，不会往后执行，除非遇到代码：chain.doFilter(request, response);
	 *    它才会继续执行，继续执行的可能是另一个拦截器，如果没有了，就直接进入请求路径
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//转换对象
		HttpServletRequest hsr = (HttpServletRequest)request;
		HttpServletResponse hsrs = (HttpServletResponse)response;
		
		//获取id
		String id = hsr.getParameter("id");
		if(id==null) {
			//地址栏没有传，拦截到了，给出提示，终止
			hsrs.getWriter().println("[filter-1]:没有传参，非法访问！");
		}
		else {
			//有的，可以继续了
			hsrs.getWriter().println("[filter-1]:OK");
			//chain：流程连模式
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// 当拦截器初始化的时候，执行代码
	}

}
