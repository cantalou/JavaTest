package com.wy.test.other;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Project Name: test File Name: FileSiseTest.java ClassName: FileSiseTest
 *
 * Description: TODO.
 * 
 * @author LinZhiWei
 * @date 2015年4月24日 上午10:47:13
 * 
 *       Copyright (c) 2015年, 4399 Network CO.ltd. All Rights Reserved.
 */
public class FileSiseTest {

    private final static long ONE_K = 1024;
    private final static long ONE_M = 1024 * 1024;
    private final static DecimalFormat df = new DecimalFormat("#0.00");

    /**
     * @Description:获取文件夹大小
     * @Title: ForumsStringUtil.java
     * @date 2015年1月12日 下午3:14:12
     * @author LinXin
     * @param size
     * @return
     */
    public final static String getFileSize(long size) {
	if (size < ONE_K) {
	    return size + "B";
	} else if (size < ONE_M) {
	    return df.format(size * 1.0f / ONE_K) + "K";
	} else {
	    return df.format(size * 1.0f / ONE_M) + "M";
	}
    }

    /**
     * 获取文件夹总大小 B单位
     * 
     * @author youy
     * @since 2012-11-13
     * @param path
     * @return
     */
    public static long getFileAllSize(String path) {
	File file = new File(path);
	if (file.exists()) {
	    if (file.isDirectory()) {
		File[] children = file.listFiles();
		long size = 0;
		for (File f : children)
		    size += getFileAllSize(f.getPath());
		return size;
	    } else {
		long size = file.length();
		return size;
	    }
	} else {
	    return 0;
	}

    }

    public static String getMemorySizeString(long size) {
	float result = size;
	if (result < 1024) {
	    BigDecimal temp = new BigDecimal(result);
	    temp = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
	    return temp + "Bytes";
	} else {
	    result = result / 1024;
	    if (result < 1024) {
		BigDecimal temp = new BigDecimal(result);
		temp = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
		return temp + "KB";
	    } else {
		result = result / 1024;
		if (result < 1024) {
		    BigDecimal temp = new BigDecimal(result);
		    temp = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
		    return temp + "MB";
		} else {
		    result = result / 1024;
		    if (result < 1024) {
			BigDecimal temp = new BigDecimal(result);
			temp = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
			return temp + "GB";
		    } else {
			result = result / 1024;
			BigDecimal temp = new BigDecimal(result);
			temp = temp.setScale(2, BigDecimal.ROUND_HALF_UP);
			return temp + "TB";
		    }
		}
	    }
	}
    }

    public static void main(String[] args) {
	System.out.println(getFileSize(getFileAllSize("D:/wps/Kingsoft")));
	System.out.println(getMemorySizeString(getFileAllSize("D:/wps/Kingsoft")));
    }
}
