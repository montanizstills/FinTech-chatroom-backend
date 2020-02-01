package com.github.nez.FinancialObjects;

public interface FinancialObjectInterface  {
    void populateJsonObject(String company, String quote);
    Class<? extends FinancialObject> getObjectClass();
}
