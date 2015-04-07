package cn.edu.bupt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		final String BBS_URL = "http://bbs.byr.cn/#!board/ParttimeJob";
//		final String BBS_URL = "http://bbs.byr.cn";
		final String USER_CREDENTIAL = "lkasdolka2:capsule02";
		try {
			URL url = new URL(BBS_URL);
			URLConnection urlConnection = url.openConnection();
			HttpURLConnection connection = null;
			if(urlConnection instanceof HttpURLConnection){
				connection = (HttpURLConnection)urlConnection;
			}else{
				System.err.println("Please enter a http url.");
				return ;
			}
			
			connection.setRequestMethod("GET");
			connection.setRequestProperty("Authorization", USER_CREDENTIAL);
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0");
			connection.setRequestProperty("Connection", "keep-alive");
			connection.setRequestProperty("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
//			connection.setRequestProperty("Accept-Encoding", "gzip, deflate");
			connection.setRequestProperty("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			
			
			BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String res = "";
			String cur = null;
			while((cur = in.readLine()) != null){
				res += cur;
			}
			
//			String decodedRes = new String 
			
			System.out.println(res);
			// byr bbs
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
