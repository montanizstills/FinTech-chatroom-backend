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
//        this.json="[{\"datetime\":1579481328000,\"headline\":\"Nike x Converse Black History Month 2020 collection: Your first look\",\"source\":\"Finder\",\"url\":\"https://cloud.iexapis.com/v1/news/article/24e05ea2-1eca-426b-9654-2f7b1df73f0e\",\"summary\":\"This is everything you need to know on the iconic collection for Black History Month 2020 - featuring the likes of Nike and Converse.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/24e05ea2-1eca-426b-9654-2f7b1df73f0e\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579365011000,\"headline\":\"Nike (NKE) Up 3.3% Since Last Earnings Report: Can It Continue?\",\"source\":\"Zacks Investment Research\",\"url\":\"https://cloud.iexapis.com/v1/news/article/c1d96b86-59ac-422a-837a-3e305758d1a9\",\"summary\":\"Nike (NKE) reported earnings 30 days ago. What's next for the stock? We take a look at earnings estimates for some clues.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/c1d96b86-59ac-422a-837a-3e305758d1a9\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579289377000,\"headline\":\"Tennessee Gov. Lee to sign anti-LGBTQ adoption bill despite Amazon, Nike opposition\",\"source\":\"CNBC\",\"url\":\"https://cloud.iexapis.com/v1/news/article/708d8243-e55e-4b7a-82b4-7e405e679c36\",\"summary\":\"Companies including Amazon, Nike, Warby Parker and Marriott express disappointment after Tennessee Gov. Lee's announcement he will sign an anti-LGBTQ adoption bill into law.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/708d8243-e55e-4b7a-82b4-7e405e679c36\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579275959000,\"headline\":\"Nike Stock Could Hit $120 in 2020\",\"source\":\"InvestorPlace\",\"url\":\"https://cloud.iexapis.com/v1/news/article/b3f6c45c-d1ca-47c8-886c-5a52696369d7\",\"summary\":\"A strong uptrend coupled with strong earnings and innovation mean Nike stock could hit a price of $120 by mid-year 2020.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/b3f6c45c-d1ca-47c8-886c-5a52696369d7\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579271788000,\"headline\":\"The shop selling trainers with 80% off including Adidas and Nike\",\"source\":\"Wales Online\",\"url\":\"https://cloud.iexapis.com/v1/news/article/a4a03a36-1ada-4275-80b1-922315692141\",\"summary\":\"There are even deals on the likes of Converse and Calvin Klein\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/a4a03a36-1ada-4275-80b1-922315692141\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579269815000,\"headline\":\"Nike shoppers can get an extra 20% off all sale items with this code\",\"source\":\"Mirror Online\",\"url\":\"https://cloud.iexapis.com/v1/news/article/3048ed8b-c82f-4b12-891a-021e9b8bc74b\",\"summary\":\"The Nike sale provides the perfect chance to stock up on trainers, gym wear and jackets at bargain prices - and now you can save even more with a new discount code\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/3048ed8b-c82f-4b12-891a-021e9b8bc74b\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579256344000,\"headline\":\"Les chaussures records de Nike bannies des compétitions?\",\"source\":\"Lavenir\",\"url\":\"https://cloud.iexapis.com/v1/news/article/28218146-5287-4389-8e01-bb0977ef92da\",\"summary\":\"Ces chaussures sont-elles une forme de dopage mécanique? C’est la question qui sera bientôt tranchée à propos d’une paire de Nike, qui a fait tomber plusieurs records.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/28218146-5287-4389-8e01-bb0977ef92da\",\"lang\":\"fr\",\"hasPaywall\":false},{\"datetime\":1579218882000,\"headline\":\"'Ludicrous' marathon shoes should be banned, Rob de Castella says\",\"source\":\"ABC\",\"url\":\"https://cloud.iexapis.com/v1/news/article/35fa0cf6-1647-4d42-aa3f-e3b9d5c0ced7\",\"summary\":\"Nike's Vaporfly shoe has helped athletes break records, but Australian marathon legend Rob de Castella has labelled them 'ludicrous' and against the 'spirit' of athletics.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/35fa0cf6-1647-4d42-aa3f-e3b9d5c0ced7\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579211186000,\"headline\":\"Nike x Off-White’s MCA: All the details here\",\"source\":\"Finder\",\"url\":\"https://cloud.iexapis.com/v1/news/article/2fc0d795-cd6d-4367-9c0c-667ce5e4c624\",\"summary\":\"This is your first official look at an alternative \\\"MCA\\\" sneaker from Nike and Off-White - one with a black sole.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/2fc0d795-cd6d-4367-9c0c-667ce5e4c624\",\"lang\":\"en\",\"hasPaywall\":false},{\"datetime\":1579205732000,\"headline\":\"Trouble for Tesla, Signet sparkles, rental units for the rich, pizza's slice of the delivery market & Nike's Vaporfly to be banned\",\"source\":\"CNBC\",\"url\":\"https://cloud.iexapis.com/v1/news/article/c8c8cbec-2f2c-496f-9478-5e2948807934\",\"summary\":\"Data is a real-time snapshot *Data is delayed at least 15 minutes. Global Business and Financial News, Stock Quotes, and Market Data and Analysis.\",\"related\":\"NKE\",\"image\":\"https://cloud.iexapis.com/v1/news/image/c8c8cbec-2f2c-496f-9478-5e2948807934\",\"lang\":\"en\",\"hasPaywall\":false}]";
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

    public JSONObject removeIfAnyInternalArrays(JSONObject jsonObjectInput){
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
        function = (hypObject) -> removeIfAnyInternalArrays(new JSONObject(hypObject));
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

    public List getJsonArrayObjectList(){
        return this.jsonArrayObjectList;
    }

    public JSONObject getJsonObject(){
        return this.jsonObject;
    }

    public String getJson(){
        return this.json;
    }

    public static void main(String[] args) {
        MyJsonObject myJsonObject = new MyJsonObject("a","b");
        myJsonObject.putArrayIntoSingleObject();
        System.out.println(myJsonObject.getJsonObject());
    }
}

