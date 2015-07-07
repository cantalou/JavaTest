package com.wy.test.charset;

import static org.junit.Assert.*;

import org.junit.Test;

public class CharSetLengthTest {

    @Test
    public void test() throws Exception {
	
	String str = "啊";
	assertEquals(3, str.getBytes("UTF-8").length);
	assertEquals(2, str.getBytes("GBK").length);

	str = "a";
	assertEquals(1, str.getBytes("UTF-8").length);
	assertEquals(1, str.getBytes("GBK").length);
    }

}
