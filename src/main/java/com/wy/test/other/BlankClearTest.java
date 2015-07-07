package com.wy.test.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

public class BlankClearTest {

    @Test
    public void cleatBlankTest() {

	ArrayList<String> loginUsersHistory = new ArrayList<String>();
	loginUsersHistory.add(" ");
	loginUsersHistory.add(" ");
	loginUsersHistory.add(" ");
	loginUsersHistory.add("1");
	loginUsersHistory.add("2");
	loginUsersHistory.add(" ");
	loginUsersHistory.add(" ");
	loginUsersHistory.add(" ");
	loginUsersHistory.add("3");
	loginUsersHistory.add("4");
	loginUsersHistory.add(" ");
	loginUsersHistory.add(" ");

	ArrayList<String> result = new ArrayList<String>();
	result.add("1");
	result.add("2");
	result.add("3");
	result.add("4");

	for (int i = loginUsersHistory.size() - 1; i >= 0; i--) {
	    String name = loginUsersHistory.get(i);
	    if (name == null || name.trim().length() == 0 || "null".equals(name)) {
		loginUsersHistory.remove(i);
	    }
	}
	Assert.assertEquals(result.size(), loginUsersHistory.size());
	Assert.assertTrue(result.containsAll(loginUsersHistory));

	Random r = new Random();
	result.clear();
	loginUsersHistory.clear();
	String[] blank = new String[] { "", "   ", "null" };
	for (int i = 1000; i > 0; i--) {
	    result.add(Integer.toString(i));
	    loginUsersHistory.add(Integer.toString(i));
	    for (int j = 0; j < r.nextInt(10); j++) {
		loginUsersHistory.add(blank[r.nextInt(3)]);
	    }
	}

	for (int i = loginUsersHistory.size() - 1; i >= 0; i--) {
	    String name = loginUsersHistory.get(i);
	    if (name == null || name.trim().length() == 0 || "null".equals(name)) {
		loginUsersHistory.remove(i);
	    }
	}
	Assert.assertEquals(1000, result.size());
	Assert.assertEquals(result.size(), loginUsersHistory.size());
	Assert.assertTrue(result.containsAll(loginUsersHistory));

    }
}
