package model;

import java.util.Random;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 1000;
		while(n-- > 0) {
			Random rd = new Random();
			double x = rd.nextFloat();
			System.out.println(x*100);
		}
		
	}

}
