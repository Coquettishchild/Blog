package com.blog.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;


import com.blog.entity.Response;

import net.sf.json.JSONObject;

public class SendJson {
	public static void sendJson(HttpServletResponse reponse,Response re) throws IOException {
		reponse.setCharacterEncoding("utf8");
		JSONObject json = new JSONObject();
		json.accumulate("data", re);
		reponse.getWriter().print(json.toString());
	}
}
