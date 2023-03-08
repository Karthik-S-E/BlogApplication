package com.example.blogapp.exception;

public class ResourceNotFoundException extends RuntimeException{

    String resourceName;
    String fieldName;
    long filedValue;
    public ResourceNotFoundException(String resourceName, String fieldName, long filedValue)
    {
        super(String.format("%s"));
         this.resourceName=resourceName ;
        this.fieldName=fieldName;
        this.filedValue=filedValue;

    }
}
