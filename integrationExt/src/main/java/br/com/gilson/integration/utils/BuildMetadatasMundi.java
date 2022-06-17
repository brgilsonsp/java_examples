package br.com.gilson.integration.utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class BuildMetadatasMundi {

	public static LinkedHashMap<String, String> buidMetadadasPatternMundi(Map<String, String> map) {
		
		LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();

		if(map != null && map.size() > 0) {
			map.forEach((k, v) -> linkedHashMap.put(k, v));
		}

		return linkedHashMap;
	}

}
