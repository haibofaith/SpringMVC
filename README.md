# SpringMVC
SpringMVC学习笔记

1.MVC model(Service Dao) ,view(Jsp),controller(Servlet)</br>
2.Spring mvc框架：(类似Structs，核心是filter)
	通过实现mvc将数据、业务、视图分离：核心是servlet：
	Request请求(web.xml配置DispatchServlet：有且仅有一个servlet)
	-->DispatchServlet转发
	-->handlermapping转发(添加一个spring mvc的配置文件)
	——>controller（控制器：获取数据进行处理）	
	-->Model and View 
	-->ViewResolver
	-->View
3.springmvc框架搭建步骤：
	1）jar包：spring的jar包+
	2）配置web.xml（配置前端控制器DispatchServlet）
	<servlet>
  		<servlet-name>springmvc</servlet-name>
  		<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
  	</servlet>
  	<servlet-mapping>
  		<servlet-name>springmvc</servlet-name>
  		<!-- 任何*.do的 -->
  		<url-pattern>*.do</url-pattern>
  	</servlet-mapping>
	3）在web-inf下创建spring的配置文件(或者springmvc的配置文件)，[servletname]-servlet.xml。
	例如：当前举例中，文件名必须为springmvc-servlet.xml。
	4）在web.xml中配置handlermapping，通过beanname找到对应的controller（可以省略）
	<!-- 配置handlerMapping -->
	<bean class="org.springframework.web.servlet.mvc.support.ControllerBeanNameHandlerMapping"></bean>
	5）写一个view：创建jsp页面（hello.jsp）发出请求的页面
	6）创建controller(本例hellocontroller，继承AbstractController，重写handleRequestInternal)
		//获取数据
		String hello = request.getParameter("hello");
		System.out.println("-----"+hello);
		//返回到index页面和数据
		//1页面
		ModelAndView mav = new ModelAndView("index");
		//2数据
		mav.addObject("helloworld", "hello"+hello);
	7)配置视图解析器
	<!-- 配置视图解析器 -->
	<bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
		<!-- 前缀 :说明如果直接放在web-inf下，不需要加前缀-->
		<property name="prefix" value="/view/"></property>
		<!-- 后缀 ： -->
		<property name="suffix" value=".jsp"></property>
	</bean>
	8)配置controller
	<!-- 配置controller -->
	<bean name="/hello.do" class="Controller.HelloController"></bean>
	
4.遇到问题
1）跳转mapping路径请求不到index.jsp,修改如下：
		<!-- 前缀 :说明如果直接放在web-inf下，不需要加前缀-->
		<property name="prefix" value="WEB-INF/view/"></property>
2）中文乱码问题
		通过filter处理：发现打印日志时不再出现乱码，且jsp可打印出数据
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, 				ServletException {
		// TODO Auto-generated method stub
		// place your code here
		request.setCharacterEncoding("UTF-8");
		System.out.println("doFilter....");
		// pass the request along the filter chain
		chain.doFilter(request, response);
		}		
	
	
	
	
