package config;
import java.nio.charset.StandardCharsets;

import javax.servlet.FilterRegistration;
/**
 * servlet容器启动的时候，会找到此类并调用onStartup方法
 * 
 * （1）。 tomcat （web容器再启动的时候会自己找到webApplicationInitialzer接口的实现类
 * 		并且调用onstartup方法
 * （2）。 为了构建Spring容器
 * （3）。 把servletContext交给Spring容器来管理
 * （4）。 再ServletContext中添加一个servlet，整个是SpirngMVC的核心servlet
 * 		它也是MVC设计模式中的C。控制器
 * 		以后我们就不写servlet了，写SpringMVC的Controller，写好Controller
 * 		SpringMVC框架就会用自己的那个核心控制器（servlet）进行转发相应的请求
 * 		（路由）
 */
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer{

	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//1.构造Spring容器
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		//2.Spring容器加载配置
		ctx.register(AppConfig.class);
		//3.Spring容器接管ServletContext应用上下温对象
		ctx.setServletContext(servletContext);
		//4.添加Servlet（至少一个servlet，SpringMVC框架实现的入口Servlet）
		ServletRegistration.Dynamic servlet =
				servletContext.addServlet("dispatcher", new DispatcherServlet(ctx));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		//5.添加过滤器
		FilterRegistration.Dynamic encodingFilter =
				servletContext.addFilter("encodingFilter", CharacterEncodingFilter.class);
		encodingFilter.setInitParameter("encoding", String.valueOf(StandardCharsets.UTF_8));
		encodingFilter.setInitParameter("forceEncoding", "true");
		encodingFilter.addMappingForUrlPatterns(null, false, "/*");
	}

}
