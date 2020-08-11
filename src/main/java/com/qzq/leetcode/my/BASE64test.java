package com.qzq.leetcode.my;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

public class BASE64test {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Michael Qi\\Desktop\\新建文件夹\\t.ibd");
		BufferedInputStream input = new BufferedInputStream(new FileInputStream(file));
		byte[] bytes= new byte[input.available()]; 
		input.read(bytes);
		String str =byte2String(bytes);
		System.out.println(str);

	}
	
	public static int byteToInt(byte b){
		int x = b & 0xff;
		return x;
	}
	
	public static String byte2String(byte[] data) {
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[data.length * 2];

        for (int j = 0; j < data.length; j++) {
            int v = data[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }

        String result = new String(hexChars);
        result = result.replace(" ", "");
        return result;
    }
}
