package cn.edu.bupt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test2 {
	public static void main(String[] args) {
		// httpclient
//		final String TARGET_URL = "http://bbs.byr.cn/Gymnasium";
		final String TARGET_URL_PARTTIMEJOB = "http://bbs.byr.cn/board/Gymnasium?_uid=guest";
		final String TARGET_URL_PARTTIMEJOB2 = "http://bbs.byr.cn/board/ParttimeJob?_uid=lkasdolka2";
		final String SHUIMU_INTER = "http://www.newsmth.net/nForum/board/Career_Plaza";
		final String SHUIMU_INTER2 = "http://www.newsmth.net/nForum/board/Intern";
		final String SHUIMU_INTER3 = "http://www.newsmth.net/nForum/board/Career_Plaza";
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(TARGET_URL_PARTTIMEJOB2);
		httpGet.setHeader("Accept", "*/*");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
//		httpGet.setHeader("Cookie", "Hm_lvt_38b0e830a659ea9a05888b924f641842=1428296888,1428296890,1428297897,1428297900; login-user=lkasdolka2; nforum[UTMPUSERID]=lkasdolka2; nforum[PASSWORD]=sexUrYY9sye5LofuOSGzmw%3D%3D; left-index=0001000000; nforum-left=100; nforum[UTMPKEY]=57743802; nforum[UTMPNUM]=3644; Hm_lpvt_38b0e830a659ea9a05888b924f641842=1428299303; nforum[BMODE]=2; nforum[XWJOKE]=hoho");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0");
		httpGet.setHeader("DNT", "1");
		// bbs ˮľ  and byr differs
		httpGet.setHeader("Host", "bbs.byr.cn");
		httpGet.setHeader("Referer", "http://bbs.byr.cn");
		httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
		
		CloseableHttpResponse response =null; 
		String res = null;
		try {
			response = httpClient.execute(httpGet);
			System.out.println("StatusLine:"+response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if(entity != null){
				byte[] bytes = EntityUtils.toByteArray(entity);
				res = new String(bytes);
				System.out.println(res);
			}
//			res = entity.toString();
//			System.out.println(res);
			System.out.println("");
			
			
//			Pattern pattern = Pattern.compile("\"\\d*abc\\d*");
//			Matcher matcher = pattern.matcher("\"123456abc123");
//			while(matcher.find()){
//				System.out.println(matcher.group());
//			}
			
//			System.out.println("1\\n");
			
//			Pattern pattern = Pattern.compile("<td class=\\\"title_9[^\\\"]*\\\">.*?<a href=\\\"/article/[^\\\"]*\\\">(.*?)</a>");
			Pattern pattern = Pattern.compile("<td class=\"title_9[^\"]*\">.*?<a href=\"/article/[^\"]*\">(.*?)</a>");
			Matcher matcher = pattern.matcher(res);
			int i = 1;
			while(matcher.find()){
				System.out.println("matches for " + i +" times!");
				System.out.println(i++ + ". "+matcher.group(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
