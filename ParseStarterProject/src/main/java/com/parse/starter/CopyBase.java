package com.parse.starter;

/**
 * Created by salow on 11/22/2015.
 */
public class CopyBase {

    private static Base base;


    public CopyBase( Base base1) {
        this.base = base1;

    }

    public static Base getBase() {
        return base;
    }
}


