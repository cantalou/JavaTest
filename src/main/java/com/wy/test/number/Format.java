package com.wy.test.number;

/**
 * Project Name: test File Name: Format.java ClassName: Format
 *
 * Description: TODO.
 * 
 * @author LinZhiWei
 * @date 2015年5月7日 下午8:21:41
 * 
 *       Copyright (c) 2015年, 4399 Network CO.ltd. All Rights Reserved.
 */
public class Format {

    /**
     * 
     * @author LinZhiWei
     * @date 2015年5月7日 下午8:21:41
     * @param args
     */
    public static void main(String[] args) {
	double count = 12200;
	System.out.println(String.format("%.1f", count / 10000.0).replace(".0", "") + "万");

	count = 12800;
	System.out.println(String.format("%.1f", count / 10000.0).replace(".0", "") + "万");

	count = 119900;
	System.out.println(String.format("%.1f", count / 10000.0).replace(".0", "") + "万");


    }

}
