package com.github.nez;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.financialobjects.FinancialObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class DataRetriever<T extends FinancialObject> {

    public String decipherMessage(String message) {
        String response="";
        String[] messageArray = message.split(" ");
        for (String word : messageArray) {
            if (word.matches("\\$[a-zA-Z]+\\.[a-zA-Z]+")){
                String[] requestArray = word.split("[$|.]");
                String companyName = requestArray[1];
                String serviceName = requestArray[3];
                String financialObjectType = requestArray[2];

//                Quote quote = new Quote();
//                quote.populateJsonObject(companyName,financialObjectType);

                try {
                    Class clazz = Class.forName(financialObjectType);
//                  clazz obj = clazz.newInstance()
                    Constructor<T> constructor = clazz.getDeclaredConstructor();
                    T specializedFinancialObject = constructor.newInstance();
                    specializedFinancialObject.populateJsonObject(companyName,serviceName);

                    ObjectMapper objectMapper = new ObjectMapper();

                    System.out.println("The json Object is "+specializedFinancialObject.getJsonObject());

                    specializedFinancialObject = (T) objectMapper.readValue(specializedFinancialObject.getJsonObject().toString(),specializedFinancialObject.getObjectClass());

                    System.out.println(serviceName);
                    Method method = specializedFinancialObject.getClass().getMethod(serviceName);
                    word=method.invoke(specializedFinancialObject, null).toString();
                    response += " "+word;
                }
                catch (Exception e) {
                    System.out.println("Something is wrong creating the object or invoking the method. Returning word: "+word);
                    response += " "+word;
                }
            }
            else {
                response += " "+word;
            }
        }
        return response;
    }

}