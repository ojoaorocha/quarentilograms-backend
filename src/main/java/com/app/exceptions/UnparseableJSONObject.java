package com.app.exceptions;

public class UnparseableJSONObject extends Exception{
    public UnparseableJSONObject() {
        super("JSON structure could not be properly parsed.");
    }
}
