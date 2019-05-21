package com.blog.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;


public class JSONParase {
	public static JSONObject paraseJson(HttpServletRequest request,HttpServletResponse response) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf8"));
		String line = null;
		StringBuilder sb = new StringBuilder();
		while((line=bf.readLine())!=null) {
			sb.append(line);
		}
		bf.close();
		JSONObject json = JSONObject.fromObject(sb.toString());
		return json;
	}
}
