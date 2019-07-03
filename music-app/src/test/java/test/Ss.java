package test;


import entity.SearchSong;
import util.HttpClientResult;
import util.HttpClientUtil;
public class Ss {
	public static void main(String[] args) throws Exception {
		/*String search = SearchSong.Search("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.search.catalogSug&query=海阔天空");
		System.out.println(search);*/
		
		HttpClientResult doGet = HttpClientUtil.doGet("https://v1.itooi.cn/netease/search?keyword=出山&type=song&pageSize=20&page=0");
		System.out.println(doGet);
	}
}


