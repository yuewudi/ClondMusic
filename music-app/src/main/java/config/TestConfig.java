package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 用于单元测试配置
 * @author root
 *
 */
@Configuration
@ComponentScan({"dao","service","controller"})
@Import({JdbcConfig.class})
public class TestConfig {
	
}
