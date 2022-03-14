package com.spring.basics.spring;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class BubbleSortAlgorithm implements SortAlgorithm{
	
	public int[] sort(int[] number) {
		
		return number;
	}

}
