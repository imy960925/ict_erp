package com.ict.erp;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class Test {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "홍길동");
		map.put("age", 27);

		Person p = new Person();
		BeanUtils.populate(p, map);

		System.out.println(p);

	}
}
