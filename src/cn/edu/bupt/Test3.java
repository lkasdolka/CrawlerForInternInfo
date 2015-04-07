package cn.edu.bupt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test3 {
	public static void main(String[] args) {
		final String DESIRED_KEYS_PATTERN = "android|java|�ѹ�";
		String[] arrStrings = new String[]{
			"��ʵϰ��IT��άϵͳ��ǰ��ʵʩ���з�����ʦ",
			" [[ʵϰ]]����IT��",
			"��ǫ��ѯ����Office����������Ŀ��Ҫ�󾡿���ְ",
			"[[����]][[����]][[��ְ]][[ʵϰ]]��360�����濪������ʦ",
			"ANDROID dev recruit",
			"[[����]][[����]][[��ְ]][[ʵϰ]]��360�����濪������ʦ",
			"EMC DD�����ղ��Կ���ʵϰ��",
			"[[ʵϰ]]VMware CPD ����Ƹʵϰ��������Ӧ������ת��",
			"���ѹ���ְ����������Ч��������ʦ�㡿ҳ������������Ա",
			"�ٶȷ���",
			"DUANG,~~,��Ѷ��Ϸzhaopin",
			"~~~~JaVa~~~",
			"��׿�з�����ʦ"
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
