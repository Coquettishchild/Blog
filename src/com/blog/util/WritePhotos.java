package com.blog.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.fileupload.FileItem;

public class WritePhotos {
	public static boolean wirtephotos(FileItem item,String name,String url) {
		InputStream in;
		try {
			File file = new File(url);
			if(!file.exists()) {
				file.mkdir();
			}
			in = item.getInputStream();
			BufferedInputStream ins = new BufferedInputStream(in);
			OutputStream out = new FileOutputStream(url+"\\"+name);
			BufferedOutputStream outs = new BufferedOutputStream(out);
			int i;
			byte[] b =new byte[1024];
			while((i=ins.read(b,0,b.length))!=-1) {
				outs.write(b);
				outs.flush();
			}
			outs.close();
			out.close();
			ins.close();
			in.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}
}
