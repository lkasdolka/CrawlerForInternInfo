package cn.edu.bupt.main;

import java.awt.print.Pageable;
import java.util.List;
import java.util.regex.Pattern;

import cn.edu.bupt.http.GetMethod;
import cn.edu.bupt.util.RegexTool;

public class MainTest {
	public static void main(String[] args) {
//		final String DESIRED_KEYS_PATTERN = "安卓|android|java";
		
		final String DESIRED_KEYS_PATTERN = "android|安卓|java|百度|腾讯|阿里|360|小米|微软|新浪|网易|有道|搜狐|搜狗";
		final int SEARCH_PAGE_NUMBER = 20;
//		http://bbs.byr.cn/board/ParttimeJob?p=2&_uid=guest
		final String BYR_URL = "http://bbs.byr.cn/board/ParttimeJob";
		final String BYR_HOST = "bbs.byr.cn";
		final String BYR_REFERER = "http://bbs.byr.cn/";
		final String SHUIMU_URL = "http://www.newsmth.net/nForum/board/Intern";
		final String SHUIMU_HOST = "www.newsmth.net";
		final String SHUIMU_REFERER = "http://www.newsmth.net/nForum/";
		final String patternForByr = "<td class=\"title_9[^\"]*\">.*?<a href=\"(/article/[^\"]*)\">(.*?)</a>";
		final String patternForShuimu = "<td class=\"title_9[^\"]*\">.*?<a href=\"(/nForum/article/Intern/.*?)\">(.*?)</a>";
		final int[] GROUP_INDEX = new int[]{1,2};
		int itemNumber = 1;
		
		//test byr
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
		for(int pageIndex = 1; pageIndex <= SEARCH_PAGE_NUMBER; pageIndex++){
			String curPageUrl = SHUIMU_URL+"?p="+pageIndex;
			String htmlString = GetMethod.get(curPageUrl, SHUIMU_HOST, SHUIMU_REFERER);
			
			List<List<String>> retList = RegexTool.getRegex(patternForShuimu, htmlString , GROUP_INDEX);
			List<String> sub_url = retList.get(0);
			List<String> titles = retList.get(1);
			for(int i = 0; i < titles.size(); i++ ){
				//filter with some key words
//				System.out.println(itemNumber++  + ". "+titles.get(i)+", http://"+BYR_HOST+sub_url.get(i));
				if(RegexTool.canMatch(DESIRED_KEYS_PATTERN, titles.get(i))){
//					System.out.println(   "              is matched.");
					System.out.println(itemNumber++ + ". "+titles.get(i)+", http://"+ SHUIMU_HOST+sub_url.get(i));
				}
				
			}
		}
		
		
		
//		String shuimuRet = GetMethod.get(SHUIMU_URL, SHUIMU_HOST, SHUIMU_REFERER);
//		System.out.println(shuimuRet);
		
		
	}
}
