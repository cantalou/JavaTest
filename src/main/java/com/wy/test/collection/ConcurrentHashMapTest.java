package com.wy.test.collection;


import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


/**
 * Project Name: test File Name: ConcurrentHashMapTest.java ClassName:
 * ConcurrentHashMapTest
 *
 * Description: TODO.
 * 
 * @author LinZhiWei
 * @date 2015年4月28日 上午11:19:23
 * 
 *       Copyright (c) 2015年,  Network CO.ltd. All Rights Reserved.
 */
public class ConcurrentHashMapTest {

    public void test() {
	ConcurrentMap<String, Object> test = new ConcurrentHashMap<String, Object>();
	for (int i = 0; i < 100; i++) {
	    test.put(Integer.toString(i), i);
	}

	for (Entry<String, Object> entry : test.entrySet()) {
	    test.remove(entry.getKey());
	}

    }

}
