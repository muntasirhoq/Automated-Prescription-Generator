package com.sd;

/**
 * Created by Muntasir on 4/30/2017.
 */
public class A {
    public static void main(String[] args) {
        String symptoms="fever,cough";
        String[] s=symptoms.split(",");

        for(String str:s)
        {
            System.out.println(str);
        }
    }
}
