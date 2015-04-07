package cn.edu.bupt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
	public static void main(String[] args) {
		final String DESIRED_KEYS_PATTERN = "android|java|搜狗";
		String[] arrStrings = new String[]{
			"【实习】IT运维系统售前、实施、研发工程师",
			" [[实习]]宝马IT部",
			"久谦咨询北京Office－互联网项目－要求尽快入职",
			"[[社招]][[内推]][[兼职]][[实习]]【360】引擎开发工程师",
			"ANDROID dev recruit",
			"[[社招]][[内推]][[兼职]][[实习]]【360】引擎开发工程师",
			"EMC DD组招收测试开发实习生",
			"[[实习]]VMware CPD 组招聘实习生，优秀应届生可转正",
			"【搜狗兼职】【长期有效】【北邮师姐】页面质量评测人员",
			"百度翻译",
			"DUANG,~~,腾讯游戏zhaopin",
			"~~~~JaVa~~~",
			"安卓研发工程师"
		};
		
		Pattern pattern = Pattern.compile(DESIRED_KEYS_PATTERN,Pattern.CASE_INSENSITIVE);
		int index = 1;
		for(int i = 0 ; i < arrStrings.length; i++ ){
			Matcher matcher = pattern.matcher(arrStrings[i]);
			if(matcher.find()){
				System.out.println(index ++ + arrStrings[i]);
			}
		}
		
	}
}
