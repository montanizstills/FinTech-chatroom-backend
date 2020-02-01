package com.github.nez;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.nez.FinancialObjects.SpecializedFinanicalObjectShort.Quote;

import java.lang.reflect.Method;

public class DataRetriever {

    public String decipherMessage(String message) {
        String response="";
        String[] messageArray = message.split(" ");
        for (String word : messageArray) {
            if (word.matches("\\$[a-zA-Z]+\\.[a-zA-Z]+")){
                String[] requestArray = word.split("[$|.]");
                String companyName = requestArray[1];
                String serviceName = requestArray[2];

                Quote quote = new Quote();
                quote.populateJsonObject(companyName,"quote");

                try {
                    ObjectMapper objectMapper = new ObjectMapper();
                    quote = (Quote) objectMapper.readValue(quote.getJsonObject().toString(),quote.getObjectClass());
                }
                catch (Exception e) {
                    System.out.println("Something is off in the ObjectMapping.");
                }

                try {
                    Method method = quote.getClass().getMethod(serviceName);
                    word=method.invoke(quote, null).toString();
                    response += " "+word;
                }
                catch (Exception e) {
                    System.out.println("Something is off getting the method. Returning word: "+word);
                    response += " "+word;
                }
            }
            else {
                response += " "+word;
            }
        }
        return response;
    }

    public String getIndividualFinancialObjectDataUsingReadTree(String financialObjectDataRequested, String jsonInput) {
        String result = "Read tree result null data fail-safe.";
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(jsonInput);
            result = jsonNode.path(financialObjectDataRequested).asText();
        }
        catch (Exception e) {
            throw new Error(e);
        }
        return result;
    }
}