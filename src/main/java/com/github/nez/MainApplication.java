package com.github.nez;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.FinancialObjects.SpecializedFinanicalObjectShort.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootApplication
public class MainApplication{

	public static void main(String args []) {
//		Integer[] array1 = new Integer[]{1,2,3};
//		Integer[] array2 = new Integer[]{4,5,6};
//		Stream<Integer[]>  myStream = Stream.of(array1,array2);
//		myStream.filter(x->{
//			ArrayList returnList = new ArrayList<>();
//			for (int i = 0; i<x.length; i++) {
//				if(i%2==0){
//					returnList.add(i);
//				}
//			}
//			 myStream.collect(Collectors.toList());
//		}).map();


		SpringApplication.run(MainApplication.class,args);
	}
}//End of Class