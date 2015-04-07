package cn.edu.bupt.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTool {
	public static List<String> getRegex(String regex, String target,int groupIndex){
		List<String> ans = new ArrayList<>();
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(target);
		while(matcher.find()){
			ans.add(matcher.group(groupIndex));
		}
		return ans;
		
		
	}
}
