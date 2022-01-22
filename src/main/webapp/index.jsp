<html>
<body>
<h2>Hello World!</h2>
</body>
</html>
<?xml version="1.0" encoding="UTF-8"?>
<web-app version="3.0" 
		xmlns:javaee="http://java.sun.com/xml/ns/javaee" 
		xmlns:xml="http://www.w3.org/XML/1998/namespace" 
		xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" 
		xsi:schemaLocation="http://java.sun.com/xml/ns/javaee 
		http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd ">
		
		<servlet>
			<servlet-name>uploadFileDispatcher</servlet-name>
			<servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
			<init-param>
			<param-name>contextConfigLocation</param-name>
			<param-value>/WEB-INF/uploadFile-Dispatcher.xml</param-value>
			</init-param>
			<load-on-startup>1</load-on-startup>
		</servlet>
		
		<servlet-mapping>
			<servlet-name>uploadFileDispatcher</servlet-name>
			<url-pattern>/</url-pattern>
		</servlet-mapping>
		
		<servlet-mapping>
			<servlet-name>default</servlet-name>
			<url-pattern>*.gif</url-pattern>
			<url-pattern>*.png</url-pattern>
			<url-pattern>*.jpg</url-pattern>
			<url-pattern>*.jpeg</url-pattern>
			
		</servlet-mapping>
</web-app>
