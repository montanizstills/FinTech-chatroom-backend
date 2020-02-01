package com.github.nez;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.FinancialObjects.SpecializedFinanicalObjectShort.Quote;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Method;


@SpringBootApplication
public class MainApplication{

//	public String decipherMessage(String message) {
//		String response="";
//		String[] messageArray = message.split(" ");
//		for (String word : messageArray) {
//			if (word.matches("\\$[a-zA-Z]+\\.[a-zA-Z]+")){
//				String[] requestArray = word.split("[$|.]");
//				String companyName = requestArray[1];
//				String serviceName = requestArray[2];
//
//				Quote quote = new Quote();
//				quote.populateJsonObject(companyName,"quote");
//
//				try {
//					ObjectMapper objectMapper = new ObjectMapper();
//					quote = (Quote) objectMapper.readValue(quote.getJsonObject().toString(),quote.getObjectClass());
//				}
//				catch (Exception e) {
//					System.out.println("Something is off in the ObjectMapping.");
//				}
//
//				try {
//					Method method = quote.getClass().getMethod(serviceName);
//					response += " "+method.invoke(quote, null).toString();
//				}
//				catch (Exception e) {
//					System.out.println("Something is off getting the method. Returning word");
//					response += " "+word;
//				}
//			}
//			else {
//				response += " "+word;
//			}
//		}
//		return response;
//	}

	public static void main(String args []) {
		SpringApplication.run(MainApplication.class,args);

//		String message = "Welcome back Richard, $ubs.getCompanyName has changed by $ubs.getChange %.";
//		System.out.println( new MainApplication().decipherMessage(message));
	}
}//End of Class