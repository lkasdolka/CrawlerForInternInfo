package cn.edu.bupt.main;

import java.util.List;
import java.util.regex.Pattern;

import cn.edu.bupt.http.GetMethod;
import cn.edu.bupt.util.RegexTool;

public class MainTest {
	public static void main(String[] args) {
		final String BYR_URL = "http://bbs.byr.cn/board/ParttimeJob?_uid=guest";
		final String BYR_HOST = "bbs.byr.cn";
		final String BYR_REFERER = "http://bbs.byr.cn/";
		final String SHUIMU_URL = "http://www.newsmth.net/nForum/board/Intern";
		final String SHUIMU_HOST = "www.newsmth.net";
		final String SHUIMU_REFERER = "http://www.newsmth.net/nForum/";
		final String patternForByr = "<td class=\"title_9[^\"]*\">.*?<a href=\"/article/[^\"]*\">(.*?)</a>";
		final int BYR_GROUP_INDEX = 1;
		String byrRet = GetMethod.get(BYR_URL, BYR_HOST, BYR_REFERER);
		System.out.println(byrRet);
		List<String> retList = RegexTool.getRegex(patternForByr, byrRet,BYR_GROUP_INDEX);
		for(String s:retList){
			System.out.println(s);
		}
		
		
		
//		String shuimuRet = GetMethod.get(SHUIMU_URL, SHUIMU_HOST, SHUIMU_REFERER);
//		System.out.println(shuimuRet);
		
		
	}
}
