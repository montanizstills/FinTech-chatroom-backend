package com.github.nez;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class IEXConnection {
    private String service;
    private String ticker;
    private InputStream response;
    private String jsonOutput;
    private String uncleanURL;
    private URL cleanURL;
    private URLConnection connection;

    public IEXConnection(String ticker, String service){
        this.ticker = ticker;
        this.service=service;
        uncleanURL = "https://cloud.iexapis.com/v1/stock/"+this.ticker+"/"+this.service+"?token=pk_ced18a0ae56844deae7c352886fce8fa";
        connect();
    }


    public void createURL(String uncleanURL){
        try {
            cleanURL = new URL(uncleanURL);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void establishConnection(){
        try {
            connection = cleanURL.openConnection();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void catchResponse(){
        try {
            response = connection.getInputStream();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void connect(){
        createURL(uncleanURL);
        establishConnection();
        catchResponse();
    }

    public String convertConnectionStreamResponseToString(){
        BufferedReader br = new BufferedReader(new InputStreamReader(response));
        StringBuffer sb = new StringBuffer();
        try{
            while((jsonOutput = br.readLine())!=null){sb.append(jsonOutput);}
        } catch(Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public String getJsonOutput() {
        return jsonOutput;
    }

}
