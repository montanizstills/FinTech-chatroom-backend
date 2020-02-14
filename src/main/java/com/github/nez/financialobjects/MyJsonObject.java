package com.github.nez.financialobjects;

import com.github.nez.JSONRetriever;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class MyJsonObject {

    private String json;
    private JSONObject jsonObject;
    private List<JSONObject> jsonArrayObjectList;

    public MyJsonObject(String company, String service){
        this.json = new JSONRetriever().retrieveJSON(company, service);
//        this.jsonObject = json.startsWith("[") ? createJsonObject() : createJsonObjectList();

        if(json.startsWith("[")){
            createJsonObjectList();
            putArrayIntoSingleObject();

        }
        else{
            this.jsonObject=createJsonObject();
        }
    }

    public String[] trimAndSplit(Object dirtyJsonObject){
        String dirtyJsonString = dirtyJsonObject.toString();
        int lastDesiredElement = dirtyJsonString.length()-1;
        dirtyJsonString = dirtyJsonString.substring(1,lastDesiredElement);
        String [] cleanValueArray = dirtyJsonString.split(",");
        return cleanValueArray;
    }

    public JSONObject removeArraysFromMapValue(JSONObject jsonObjectInput){
        JSONObject finishedJsonObject = new JSONObject();
        Map map = jsonObjectInput.toMap();
        map.forEach((k,v)->{
            if(v==null){v="no data found";}
            if(v instanceof List){
                ((List) v).forEach((i)-> {
                    String[] brokenUpValueArray = trimAndSplit(i);
                    for (String element : brokenUpValueArray) {
                        element = element.trim();
                        String [] newKeyValuePair = element.split("=");
                        finishedJsonObject.put(newKeyValuePair[0],newKeyValuePair[1]);
                    }
                });
            }
            else{
                finishedJsonObject.put(k.toString(),v.toString());
            }
        });
        return finishedJsonObject;
    }

    public JSONObject createJsonObject(){
        Function<String,JSONObject> function;
        function = (hypObject) -> removeArraysFromMapValue(new JSONObject(hypObject));
        return function.apply(this.json);
    }

    public void createJsonArray(){
        Consumer<String> consumer;
        consumer = (hypObj) -> {
            JSONArray jsonArray = new JSONArray(hypObj);
            jsonArray.forEach(jsObject->jsonArrayObjectList.add((JSONObject) jsObject));
        };
        consumer.accept(this.json);
    }

    public void putArrayIntoSingleObject(){
        jsonObject=new JSONObject();
//        jsonArrayObjectList = new ArrayList();
//        createJsonArray();
        JSONObject[] array = jsonArrayObjectList.toArray(new JSONObject[0]);
        Map<String,Object> mapToBeReturned = array[0].toMap();
        jsonArrayObjectList.forEach(element->{
            Map<String,Object> emap = element.toMap();
            emap.forEach((key,value)->{
                mapToBeReturned.merge(key,value,(k,v)-> value.equals(v.toString()) ?
                        jsonObject.put(key, value.toString()) : jsonObject.put(key, v.toString() + "," + value.toString())
                );
            });
        });
    }


    public void createJsonObjectList (){
        jsonArrayObjectList = new ArrayList();
        createJsonArray();
    }

//    public List getJsonArrayObjectList(){
//        return this.jsonArrayObjectList;
//    }

    public JSONObject getJsonObject(){
        return this.jsonObject;
    }

//    public String getJson(){
//        return this.json;
//    }

}

