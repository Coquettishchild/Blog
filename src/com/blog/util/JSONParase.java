package com.blog.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;


public class JSONParase {
	public static JSONObject paraseJson(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line=bf.readLine())!=null) {
			sb.append(line);
		}
		bf.close();
		System.out.println(sb.toString());
		JSONObject json = JSONObject.fromObject(sb.toString());
		return json;
	}
}
