package com.o2o.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.apache.commons.lang.StringUtils;

public class O2OStringUtils {
	
	public static String maskMobile(String mobile){
		if(StringUtils.isEmpty(mobile)) return "";
		String[] ms = mobile.split(",");
		for(int i=0; i<ms.length; i++){
			String m = ms[i];
			if(m.length()<8){
				continue;
			}
			ms[i] = m.substring(0, 3) + "****" + m.substring(7);
		}
		return StringUtils.join(ms,",");
	}
	
	public static String maskEmail(String email){
		if(StringUtils.isEmpty(email)) return "";
		String[] ms = email.split(",");
		for(int i=0; i<ms.length; i++){
			String m = ms[i];
			StringBuilder sb = new StringBuilder(m);
			Boolean rp = false;
			for(int j=0; j<sb.length(); j++){
				String c = sb.substring(j, j+1);
				if(c.equals("@")){
					rp = true;
					continue;
				} 
				if(rp==true&&c.equals(".")){
					rp = false;
				}
				if(rp==true){
					sb.setCharAt(j, "*".charAt(0));
				}
			}
			ms[i] = sb.toString();
		}
		
		return StringUtils.join(ms,",");
	}
	
	public static String formatSpecification(String specification){
		if(StringUtils.isEmpty(specification)) return specification;
		StringBuilder sb = new StringBuilder();
		String[] specs = specification.split(";");
		for(String spec : specs){
			String[] spvs = spec.split(":");
			if(spvs.length!=4) continue;
			sb.append(spvs[3]+ " ");
		}
		return sb.toString().trim();
	}
	
	//阈值
    private static double threshold = 0.2 ;    
    /**
     * 计算相似度,不计空格
     * @param t1
     * @param t2
     * @return 返回百分比
     */
    public static double getSimilarity(Vector<String> t1, Vector<String> t2) throws Exception {
        int size = 0 , size2 = 0 ;
        if ( t1 != null && ( size = t1.size() ) > 0 && t2 != null && ( size2 = t2.size() ) > 0 ) {
             
            Map<String, double[]> T = new HashMap<String, double[]>();
             
            //t1和t2的并集T
            String index = null ;
            for ( int i = 0 ; i < size ; i++ ) {
                index = t1.get(i) ;
                if( index != null){
                    double[] c = T.get(index);
                    c = new double[2];
                    c[0] = 1; //t1的语义分数Ci
                    c[1] = threshold;//t2的语义分数Ci
                    T.put( index, c );
                }
            }
      
            for ( int i = 0; i < size2 ; i++ ) {
                index = t2.get(i) ;
                if( index != null ){
                    double[] c = T.get( index );
                    if( c != null && c.length == 2 ){
                        c[1] = 1; //t2中也存在，t2的语义分数=1
                    }else {
                        c = new double[2];
                        c[0] = threshold; //t1的语义分数Ci
                        c[1] = 1; //t2的语义分数Ci
                        T.put( index , c );
                    }
                }
            }
                 
            //开始计算，百分比
            Iterator<String> it = T.keySet().iterator();
            double s1 = 0 , s2 = 0, Ssum = 0;  //S1、S2
            while( it.hasNext() ){
                double[] c = T.get( it.next() );
                Ssum += c[0]*c[1];
                s1 += c[0]*c[0];
                s2 += c[1]*c[1];
            }
            //百分比
            return Ssum / Math.sqrt( s1*s2 );
        } else {
            throw new Exception("传入参数有问题！");
        }
    }
    
    public static double getSimilarity(String str1, String str2) throws Exception{
    	if(StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)) return 1.0;
    	if(StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) return 0.0;
    	Vector<String> t1 = new Vector<String>(0);
    	Vector<String> t2 = new Vector<String>(0);
    	
    	for(int i=0; i<str1.length(); i++){
    		t1.add(str1.substring(i, i+1));
    	}
    	for(int i=0; i<str2.length(); i++){
    		t2.add(str2.substring(i, i+1));
    	}
    	
    	return getSimilarity(t1, t2);
    }
    
	// 过滤特殊字符
	public static String stringFilter(String str) throws PatternSyntaxException {
		// 清除掉所有特殊字符
		String regEx = "[`~!@#$%^&*()+=|{}':;',\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？-]";
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(str);
		return m.replaceAll("").trim();
	}
	
	/**
	 * 生成随机字符串
	 * @param length
	 *            表示生成字符串的长度
	 * @return
	 */
	public static String getRandomString(int length) {
		String base = "abcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}
		return sb.toString();
	}
    
	/**
	 * 将字节数组转换为十六进制字符串
	 * 
	 * @param byteArray
	 * @return
	 */
	public static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}
	/**
	 * 将字节转换为十六进制字符串
	 * 
	 * @param mByte
	 * @return
	 */
	public static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}
	
	/**
	 * 根据Unicode编码完美的判断中文汉字和符号
	 * @param c
	 * @return
	 */
	public static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_B
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION) {
            return true;
        }
        return false;
    }
	
	public static String substring(String str, int startIndex, int endIndex){
		if(StringUtils.isEmpty(str)) return str;
		if(str.length() < endIndex){
			endIndex = str.length();
		}
		return str.substring(startIndex, endIndex);
	}
	
	/**
	 * 需要小数点后2位
	 * @param num
	 * @return
	 */
	public static String subString(Double num){
		if(num.isNaN() || num == null){
			return null;
		}else{
			String str = num.toString();
			
			if(str.contains(".")){
				int dian = str.indexOf(".");
				int len = str.length();
				String rest = str.substring(dian+1, len);
				//小数点后有一位
				  switch(rest.length()){
				     case 1 :
					     str += "0";
					     break;
				  
				     case 2 :
						  str = str;
						  break;
					 
				     default:
				    	 String thr = str.substring(dian+3, dian+4);
				    	 if(Integer.parseInt(thr) > 4){
				    		 String two = str.substring(dian+2, dian+3);
				    		 int TNum = Integer.parseInt(two)+1;
				    		 str = str.substring(0, dian+2)+String.valueOf(TNum);
				    	 }else{
				    		 str = str.substring(0, dian+3);
				    	 }
				    	 break;
				  }
				  return str ;
			}else
				str += ".00";
			return str;
		}
	}
	
	public static boolean isContainsChinese(String str) {
		String regEx = "[\u4e00-\u9fa5]";
		Pattern pat = Pattern.compile(regEx);
		Matcher matcher = pat.matcher(str);
		boolean flg = false;
		if (matcher.find()) {
			flg = true;
		}
		return flg;
	}
	
	public static String assembleGoodsName(String name, String specifications){
		if(StringUtils.isEmpty(specifications)) return name;
		return name + " " + formatSpecification(specifications);
	}
}
