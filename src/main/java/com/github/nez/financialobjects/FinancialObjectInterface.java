package com.github.nez.financialobjects;

public interface FinancialObjectInterface  {
    void populateJsonObject(String company, String quote);
    Class<? extends FinancialObject> getObjectClass();
}
