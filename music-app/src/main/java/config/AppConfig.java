package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 应用配置
 * @author root
 *
 */
@Configuration
@ComponentScan({"dao","service","controller","task"})
@Import({JdbcConfig.class,WebConfig.class})
public class AppConfig {
	
}
