package com.labawang.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class Tools {
	
	/***
	 * 加密
	 * @param str
	 * @return
	 */
	 public static String getSha1(String str){  
	        if(str == null || str.length() == 0){  
	            return null;  
	        }  
	        char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};  
	          
	        try {  
	            MessageDigest mdTemp = MessageDigest.getInstance("SHA1");  
	            mdTemp.update(str.getBytes("UTF-8"));  
	              
	            byte[] md = mdTemp.digest();  
	            int j = md.length;  
	            char buf[] = new char[j*2];  
	            int k = 0;  
	            for(int i =0;i<j;i++){  
	                byte byteO = md[i];  
	                buf[k++] = hexDigits[byteO >>> 4 & 0xf];  
	                buf[k++] = hexDigits[byteO & 0xf];  
	            }  
	            return new String(buf);  
	        } catch (NoSuchAlgorithmException e) {  
	            return null;  
	        } catch (UnsupportedEncodingException e) {  
	            return null;  
	        }  
	    }  
	 public static void main(String[] args) {
		System.out.println(getSha1("tang"));
	}
	 
	 /***
	     * 获取客户端ip地址(可以穿透代理)
	     * @param request
	     * @return
	     */
	    public static String getClientIpAddress(HttpServletRequest request) {
	    	String ip = request.getHeader("x-forwarded-for");
	       if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("Proxy-Client-IP");
	       }
	       if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	           ip = request.getHeader("WL-Proxy-Client-IP");
	        }
	        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
	            ip = request.getRemoteAddr();
	        }
	        if (ip.equals("0:0:0:0:0:0:0:1")) {
	             ip = "本地";
	         }
	         return ip;
	    }
	    
	    /****
	     * 搜索内容的条件
	     * 
	     */
	 public static Map<Integer, String> getSearch(Map<Integer, String> map,int remarks){
		 map.put(1, "电话");
		 map.put(2, "行业");
		 map.put(3, "客户名字");
		 if(remarks==0){
			 map.put(4, "用户名");
		 }
		 return map;
	 }
	    
}
