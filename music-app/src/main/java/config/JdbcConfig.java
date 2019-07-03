package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * Jdbc配置
 * @author root
 *
 */

@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
	@Value("${jdbc.driverClass}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	
	
	
	@Bean(name="dataSource")
	public DataSource createDateSource(){
		DruidDataSource dateSource = new DruidDataSource();
		dateSource.setDriverClassName(driver);
		dateSource.setUrl(url);
		dateSource.setUsername(user);
		dateSource.setPassword(password);
		return dateSource;
	}
	
	@Bean(name="jdbcTemplate")
	public JdbcTemplate createJdbcTemplate(DataSource dataSource){
		return new JdbcTemplate(dataSource);
	}
	
}
