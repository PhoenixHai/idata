package org.idata.velovity;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.tools.config.DefaultKey;

@DefaultKey("numeric")
public class NumericTool {
    /** 
     * 将浮点数小数，固定保留两位小数 
     */  
	public static String hideKeyWord(String str){
		if(StringUtils.isBlank(str))return "";
		else{
			return str.substring(0,9) + "****" + str.substring(13, str.length());
		}
	}
    public static String toFixedCurren(Double d) {  
        if (d == null) {  
            return "";  
        }  
        String valStr = String.format("%1$.2f", d);  
        return valStr;  
    }  
    /** 
     * 将整数数小数，固定保留两位小数 
     */  
    public static String toFixedCurren(Integer d) {  
        if (d == null) {  
            return "";  
        }  
        String valStr = String.format("%d", d);  
        return valStr;  
    }  
	public static String toFixedCurrency(Double d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,.2f", d);
		return valStr;
	}
	
	public static String toFixedCurrency(Integer d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,d.00", d);
		return valStr;
	}
	public static String toCurrency(Integer d) {
        if (d == null) {
            return "";
        }
        String valStr = String.format("%.d.00", d);
        return valStr;
    }
	public static String toCurrency(Double d) {
        if (d == null) {
            return "";
        }
        String valStr = String.format("%.2f", d);
        return valStr;
    }
	public static String toFixedNumber(Double d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,.0f", d);
		return valStr;
	}
	
	public static String toFixedNumber(Integer d) {
		if (d == null) {
			return "";
		}
		String valStr = String.format("%,d", d);
		return valStr;
	}

	public static void main(String[] args) {
//		System.out.println(NumericTool.toFixedNumber(1000005.623D));
//		System.out.println(NumericTool.toFixedNumber(1000005));
//		System.out.println(NumericTool.toFixedCurrency(1000005.623D));
//		System.out.println(NumericTool.toFixedCurrency(1000005));
		System.out.println(hideKeyWord("123456789abcdefg"));
	}
}