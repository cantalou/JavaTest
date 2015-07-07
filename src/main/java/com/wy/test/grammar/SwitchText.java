package com.wy.test.grammar;

public class SwitchText {

    public static void main(String[] args) {

	int j = 1;
	switch (1) {
	case 1:

	    System.out.println("j == 1");
	    if (j == 1) {
		break;
	    }

	    System.out.println("j == 2");
	    if (j == 2) {
		break;
	    }
	    System.out.println("break");
	    break;

	default:
	    break;
	}

    }
}
