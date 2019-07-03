package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC访问工具类
 * @author root
 *
 */
public class JdbcUtil {
	//-- 属性1、驱动类 2、url 3、usename 4、password
	private static String driver= "";
	private static String url= "";
	private static String user= "";
	private static String password= "";
	
	
	//线程池对象(Map<当前线程的线程ID，Object>)
	private static ThreadLocal<Connection> conpool = new ThreadLocal<Connection>();
	
	
	static{
		try {
			//1、加载属性文件，并加载驱动类
			Properties ps = new Properties();
			//--2、配置路径
			InputStream in = JdbcUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
			//3、加载配置文件
			ps.load(in);
			//4、给属性赋值
			driver = ps.getProperty("jdbc.driver");
			url = ps.getProperty("jdbc.url");
			user = ps.getProperty("jdbc.user");
			password = ps.getProperty("jdbc.password");
			
			System.out.println(driver);
			
			//5、加载驱动
			Class.forName(driver);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	//获取数据库连接
	//返回 Connection对象
	public static Connection getConnection(){
		Connection con = null;
		if(conpool.get()==null){
			try {
				con =  DriverManager.getConnection(url,user,password);
				conpool.set(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return conpool.get();
		
	}
	//释放资源
	public static void close(ResultSet rs,Statement stat, Connection con) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(con!=null){
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		conpool.remove();
		
	}
	
	public static void close(Statement stat,Connection con){
		close(null,stat,con);
	}
	public static void close(Connection con){
		close(null,null,con);
	}
	
	
}
