package com.qzq.leetcode.my;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.qzq.leetcode.annotation.Column;
import com.qzq.leetcode.annotation.Table;
import com.qzq.leetcode.sql.myTest;


public class generatorSql {

	public static void main(String[] args) {
		int cord=50;
		Random random=new Random();
		Class<?> clazz = myTest.class;
		Table t = clazz.getAnnotation(Table.class);
		String table = t.value();
		System.out.println();
		Field[] fieds = myTest.class.getDeclaredFields();
		Map<String,String> map = new HashMap(); 
		for(Field fied : fieds) {
			Column a = fied.getAnnotation(Column.class);
			if(a!=null) {
				map.put(a.value(), a.type());
			}
		}
		String insertCol="";
		for(String key:map.keySet()) {
			insertCol = insertCol+key+",";
		}
		insertCol = insertCol.substring(0, insertCol.length()-1);
		String values="";
		for(int i=0;i<cord;i++) {
			String str ="(";
			for(String value:map.values()) {
				if(value.equals("Integer")) {
					str =str+ String.valueOf(random.nextInt(100))+",";
				}
			}
			str=str.substring(0, str.length()-1);
			str+="),";
			values+=str;
		}
		values=values.substring(0, values.length()-1);
		String insert = "insert into "+table+"("+insertCol+") VALUES"+values+";";
		

		System.out.println(insert);
		
		
		
	}
}
