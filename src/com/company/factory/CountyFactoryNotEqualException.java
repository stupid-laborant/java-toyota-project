package com.company.factory;

public class CountyFactoryNotEqualException extends Exception{
    public CountyFactoryNotEqualException(Country factoryCountry, Country assemblyLineCountry) {
        super("Factory country: " + factoryCountry + " doesn't match with assembly line country: " + assemblyLineCountry);
    }
}
