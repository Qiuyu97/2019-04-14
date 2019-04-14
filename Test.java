package com.demo.dan;


//设计模式：单例，Servlet就是单例的
//	只允许整个应用程中，当前类对象，只有一个

public class Test {

	//第一步：创建一个 私有的 静态的 当前类对象属性
	//	私有的：外界不能直接获取操作
	//	静态的：可以保证内存上只有一个
	private static Test test; //默认值：null
	
	
	//第二步：对外关闭构造函数（构造函数私有化）
	//	私有化构造函数，可以禁止外界使用  new
	private Test() {		
	}
	
	
	//第三步：提供一个 公开的 静态的 返回当前类对象的方法
	//	当前类不能new，需要的时候，统一问当前方法获取
	public static Test getTest() {
		
		//第四步：返回当前类对象
		if(Test.test==null) {
			Test.test = new Test();//自己new自己，创一个实例
			//System.out.println("第一次：new的");
		}
		//else {
		//	System.out.println("原来的...");
		//}
		
		return Test.test;
	}
	
	
	
	
}
