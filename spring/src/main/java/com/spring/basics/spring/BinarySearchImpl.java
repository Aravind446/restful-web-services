package com.spring.basics.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class BinarySearchImpl {
	
	@Autowired
	private SortAlgorithm sortAlgorithm;
	
	

	


	public int binarySearch(int[] number,int numberToSearchFor) {
		
		
		int[] sortedNumbers = sortAlgorithm.sort(number);
		System.out.println(sortAlgorithm);
		
		return 3;  //return the result
	
//Implementing sorting Logic
	//search the array
	
}
}