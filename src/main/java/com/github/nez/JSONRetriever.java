package com.github.nez;

// Used to create JSON on-demand.

public class JSONRetriever {
    public String retrieveJSON(String company, String service){
        String JSON="JSON returned null";
        JSON = new IEXConnection(company,service).convertConnectionStreamResponseToString();
        return JSON;
    }
}

