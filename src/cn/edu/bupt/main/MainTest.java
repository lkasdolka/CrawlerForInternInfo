package cn.edu.bupt.main;

import java.awt.print.Pageable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import javax.sound.midi.MidiDevice.Info;








import org.apache.http.client.methods.Configurable;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.omg.CORBA.PRIVATE_MEMBER;

import cn.edu.bupt.entity.TargetUrl;
import cn.edu.bupt.http.GetMethod;
import cn.edu.bupt.util.BloomFilter;
import cn.edu.bupt.util.DateUtil;
import cn.edu.bupt.util.JsonUtil;
import cn.edu.bupt.util.MailUtil;
import cn.edu.bupt.util.RegexTool;


public class MainTest {
	public static void main(String[] args) throws IOException {
		final String DESIRED_KEYS_PATTERN = "android|安卓|java|百度|腾讯|阿里|360|小米|微软|新浪|网易|有道|搜狐|搜狗";
		final int SEARCH_PAGE_NUMBER = 10;
		final int[] GROUP_INDEX = new int[]{1,2,3,4};
		final int EXPECTED_NUMBER_OF_ELEMENTS = 150;
		final double FALSE_POSITIVE_PROBABILITY = 0.1;
		
		final String from = "liukeang@163.com";
		final String sendTo = "459127552@qq.com";
		StringBuilder theme = new StringBuilder();
		StringBuilder emailContent = new StringBuilder();
		String emailTitle = theme.append(DateUtil.getDate()+ "的招聘信息").toString();
		int itemNumber = 1;
		
		
		List<TargetUrl> list = JsonUtil.parseJsonConfig();
		BloomFilter<String> bloomFilter = new BloomFilter<String>(FALSE_POSITIVE_PROBABILITY, EXPECTED_NUMBER_OF_ELEMENTS);
		for(int targetIndex = 0; targetIndex < list.size(); targetIndex++){
			TargetUrl candidate = list.get(0);
			for(int pageIndex = 1; pageIndex <= SEARCH_PAGE_NUMBER; pageIndex++){
				String curPageUrl = candidate.getUrl()+"?p="+pageIndex;
				String htmlString = GetMethod.get(curPageUrl, candidate.getHost(), candidate.getReferer());
				
				List<List<String>> retList = RegexTool.getRegex(candidate.getPattern(), htmlString , GROUP_INDEX);
				List<String> sub_url = retList.get(0);
				List<String> titles = retList.get(1);
				List<String> post_time = retList.get(2);
				List<String> author = retList.get(3);
				for(int titleIndex = 0; titleIndex < titles.size(); titleIndex++ ){
					//filter with some key words
					String title = titles.get(titleIndex);
					if(RegexTool.canMatch(DESIRED_KEYS_PATTERN, title) && !bloomFilter.contains(title)){
						bloomFilter.add(title);
						String postTime = post_time.get(titleIndex).replaceAll("&emsp;", "");
						System.out.println(itemNumber + ". "+titles.get(titleIndex)+", post time:"+postTime+", author:"+author.get(titleIndex)+", http://"+ candidate.getHost()+sub_url.get(titleIndex));
						emailContent.append(itemNumber + ". "+titles.get(titleIndex)+", post time:"+postTime+", author:"+author.get(titleIndex)+", http://"+ candidate.getHost()+sub_url.get(titleIndex)+"\n");
						itemNumber++;
					}
					
				}
			}
		}
		
		MailUtil.sendEmail(sendTo, from, emailTitle, emailContent.toString());
		
		
//		for(int pageIndex = 1; pageIndex <= SEARCH_PAGE_NUMBER; pageIndex++){
//			String curPageUrl = BYR_URL+"?p="+pageIndex;
//			String htmlString = GetMethod.get(curPageUrl, BYR_HOST, BYR_REFERER);
//			
//			List<List<String>> retList = RegexTool.getRegex(patternForByr, htmlString , GROUP_INDEX);
//			List<String> sub_url = retList.get(0);
//			List<String> titles = retList.get(1);
//			for(int i = 0; i < titles.size(); i++ ){
//				//filter with some key words
//				if(RegexTool.canMatch(DESIRED_KEYS_PATTERN, titles.get(i))){
//					System.out.println(itemNumber++ + ". "+titles.get(i)+", http://"+ BYR_HOST+sub_url.get(i));
//				}
//				
//			}
//		}
		
		
		// test for shuimu
//		for(int pageIndex = 1; pageIndex <= SEARCH_PAGE_NUMBER; pageIndex++){
//			String curPageUrl = SHUIMU_URL+"?p="+pageIndex;
//			String htmlString = GetMethod.get(curPageUrl, SHUIMU_HOST, SHUIMU_REFERER);
//			
//			List<List<String>> retList = RegexTool.getRegex(patternForShuimu, htmlString , GROUP_INDEX);
//			List<String> sub_url = retList.get(0);
//			List<String> titles = retList.get(1);
//			for(int i = 0; i < titles.size(); i++ ){
//				//filter with some key words
////				System.out.println(itemNumber++  + ". "+titles.get(i)+", http://"+BYR_HOST+sub_url.get(i));
//				if(RegexTool.canMatch(DESIRED_KEYS_PATTERN, titles.get(i))){
////					System.out.println(   "              is matched.");
//					System.out.println(itemNumber++ + ". "+titles.get(i)+", http://"+ SHUIMU_HOST+sub_url.get(i));
//				}
//				
//			}
//		}
		
		
		
		
		
	}
}
