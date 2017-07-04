package com.paric.asset.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class HQLUtil {

	public static String connectString(Map<String, Object> stuMap, String prefix) {
		String s = "";
		Iterator<Entry<String, Object>> it = stuMap.entrySet().iterator();
		while (it.hasNext()) {  
			Map.Entry<String,Object> e = (Map.Entry<String,Object>) it.next();  
			System.out.println("Key: " + e.getKey() + "--Value: " + e.getValue());
			s += " " + prefix + "." + e.getKey() + "='" + e.getValue() + "' ,";
		}
		s = s.substring(0,s.length() - 1);
		return s;
	}

}
