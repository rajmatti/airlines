package com.coforge.training.airline.random;

import java.util.Random;

public class RandomNoGenerator {

	public long getRamdomNumber()
	{
		Random rand=new Random();
		int res=rand.nextInt(1000000000);
		return res;
	}
	
}
