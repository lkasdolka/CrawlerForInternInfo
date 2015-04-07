package cn.edu.bupt.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTool {
	public static List<List<String>> getRegex(String regex, String target,int[] params){
		List<List<String>> ret = new ArrayList<>();
		List<String> sub_url = new ArrayList<>();
		List<String> titles = new ArrayList<String>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		while(matcher.find()){
			sub_url.add(matcher.group(params[0]));
			titles.add(matcher.group(params[1]));
		}
		ret.add(sub_url);
		ret.add(titles);
		return ret;
		
		
	}
	
	public static boolean canMatch(String regex, String target ){
		Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
//		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		if(matcher.find()){
			return true;
		}
		return false;
	}
}
