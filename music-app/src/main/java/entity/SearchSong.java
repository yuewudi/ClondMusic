package entity;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.ClientPNames;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.cookie.Cookie;
import org.apache.http.cookie.CookieOrigin;
import org.apache.http.cookie.CookieSpec;
import org.apache.http.cookie.CookieSpecFactory;
import org.apache.http.cookie.CookieSpecProvider;
import org.apache.http.cookie.MalformedCookieException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.cookie.BestMatchSpecFactory;
import org.apache.http.impl.cookie.BrowserCompatSpec;
import org.apache.http.impl.cookie.BrowserCompatSpecFactory;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class SearchSong {
	public static final String URL = "http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.catalogSug&query=";

	public static String Search(String url){
		
		HttpPost httpPost  = new HttpPost(url);
		DefaultHttpClient httpClient = new DefaultHttpClient();
		String result="";
		StringBuffer results = null;
		try {
			
			
			RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();  
			CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();  

				
				HttpConnectionParams.setSoTimeout(httpPost.getParams(), 60000);

				HttpConnectionParams.setConnectionTimeout(httpPost.getParams(), 60000);

			

				httpClient.getParams().setParameter(

				ClientPNames.COOKIE_POLICY, "easy");

				HttpResponse httpResponse = httpClient.execute(httpPost);
				HttpEntity entity=httpResponse.getEntity();
				result= EntityUtils.toString(entity);

				}	catch (ClientProtocolException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						result = e.getMessage().toString();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						result = e.getMessage().toString();
					}
		
		
		System.out.println(result.toString());
		return result.toString();
	}

}
