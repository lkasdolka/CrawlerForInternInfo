package cn.edu.bupt.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class GetMethod {
	// uses httpcomponents-client 4.4.1
	// url:https://hc.apache.org/downloads.cgi
	public static String get(String url,String hostName,String refererName){
		CloseableHttpClient httpClient = HttpClients.createDefault();
		org.apache.http.client.methods.HttpGet httpGet = new HttpGet(url);
		httpGet.setHeader("Accept", "*/*");
		httpGet.setHeader("Accept-Encoding", "gzip, deflate");
//		httpGet.setHeader("Cookie", "Hm_lvt_38b0e830a659ea9a05888b924f641842=1428296888,1428296890,1428297897,1428297900; login-user=lkasdolka2; nforum[UTMPUSERID]=lkasdolka2; nforum[PASSWORD]=sexUrYY9sye5LofuOSGzmw%3D%3D; left-index=0001000000; nforum-left=100; nforum[UTMPKEY]=57743802; nforum[UTMPNUM]=3644; Hm_lpvt_38b0e830a659ea9a05888b924f641842=1428299303; nforum[BMODE]=2; nforum[XWJOKE]=hoho");
		httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
		httpGet.setHeader("Connection", "keep-alive");
		httpGet.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:36.0) Gecko/20100101 Firefox/36.0");
		httpGet.setHeader("DNT", "1");
		// bbs ˮľ  and byr differs
		httpGet.setHeader("Host", hostName);
		httpGet.setHeader("Referer", refererName);
		httpGet.setHeader("X-Requested-With", "XMLHttpRequest");
		
		CloseableHttpResponse response = null;
		String ret = null;
		try {
			response = httpClient.execute(httpGet);
//			System.out.println("Status Code:"+ response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if(entity != null){
				byte[] bytes = EntityUtils.toByteArray(entity);
				ret = new String(bytes);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			try {
				response.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return ret;
	}
	
	
}
