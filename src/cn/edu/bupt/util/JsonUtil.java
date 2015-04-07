package cn.edu.bupt.util;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import cn.edu.bupt.entity.TargetUrl;

public class JsonUtil {
	static final String JSON_OBJECT_NAME_KEY = "name";
	static final String JSON_OBJECT_URL_KEY = "url";
	static final String JSON_OBJECT_HOST_KEY = "host";
	static final String JSON_OBJECT_REFERER_KEY = "referer";
	static final String JSON_OBJECT_PATTERN_KEY = "pattern";
	
	public static List<TargetUrl> parseJsonConfig() {
		final String CONF_FILE = System.getProperty("user.dir")	+ File.separator + "conf.json";
		List<TargetUrl> list = new ArrayList<TargetUrl>();
		System.out.println(CONF_FILE);
		
		// parse conf.json to get crawl targets
		JSONParser parser = new JSONParser();
		try {
			Object Info = parser.parse(new FileReader(CONF_FILE));

			JSONArray targetInfoArray = (JSONArray) Info;
			for (int i = 0; i < targetInfoArray.size(); i++) {
				JSONObject item = (JSONObject) targetInfoArray.get(i);
				String name = (String) item.get(JSON_OBJECT_NAME_KEY);
				String url = (String) item.get(JSON_OBJECT_URL_KEY);
				String host = (String) item.get(JSON_OBJECT_HOST_KEY);
				String referer = (String) item.get(JSON_OBJECT_REFERER_KEY);
				String pattern = (String) item.get(JSON_OBJECT_PATTERN_KEY);
				list.add(new TargetUrl(name, url, host, referer, pattern));

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
