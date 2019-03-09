package com.basedata.vo;

import com.basedata.utils.DateUtils;

import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class EntityToMapUtils {
	/**
	 * 实体转map
	 * 
	 * @param obj
	 * @return
	 */
	public static Map<String, String> parseMap(Object obj) {
		Map<String, String> reMap = new HashMap<String, String>();
		try {
			if (obj == null)
				return null;
			Field[] fields = obj.getClass().getDeclaredFields();
			for (int i = 0; i < fields.length; i++) {
				try {
					Field f = obj.getClass().getDeclaredField(fields[i].getName());
					f.setAccessible(true);
					Object o = f.get(obj);
					Class c = f.getType();
					if (c == Date.class) {
						reMap.put(fields[i].getName(), o != null ? DateUtils.formatDate((Date) o) : "");
					} else {
						reMap.put(fields[i].getName(), o != null ? o.toString() : "");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return reMap;
	}

}
