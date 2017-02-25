/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;
import java.util.*;
import java.io.IOException;
/**
 * @see LIT2015012 This function includes main class 
 */
public class LIT2015012 {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException in case of an error
     */
    public static void main(String args[]) throws IOException{
        testing obj1 =new testing();
       couple[] c=new couple[12];
       int i;
       for(i=0;i<12;i++)
           c[i]=new couple();
       c=obj1.fnc1(); //function for Q1
       obj1.fnc2(c); //Also prints k most happy and compatible couples(solution to Q2)
    }
}
