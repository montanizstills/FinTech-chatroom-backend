package com.github.nez.FinancialObjects;

import org.json.JSONObject;

 abstract public class  FinancialObject  implements FinancialObjectInterface {

   private JSONObject jsonObject;

   public FinancialObject(){
   }

    @Override
    public void populateJsonObject(String company, String service) {
         this.jsonObject = new MyJsonObject(company,service).createJsonObject();
    }

    @Override
    public Class<? extends FinancialObject> getObjectClass() {
        return this.getClass();
    }

    public JSONObject getJsonObject() {
        return this.jsonObject;
    }

}
