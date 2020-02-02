package com.github.nez;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.FinancialObjects.SpecializedFinanicalObjectShort.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;


@SpringBootApplication
public class MainApplication{



	public static void main(String args []) {
		SpringApplication.run(MainApplication.class,args);


//		String message = "Welcome back Richard, $ubs.getCompanyName has changed by $ubs.getChange %.";
//		System.out.println( new MainApplication().decipherMessage(message));
	}
}//End of Class