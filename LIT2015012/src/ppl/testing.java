/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppl;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @see testing solves Q1(to form couples) using the method fnc1() and Q2(to print k most happy and compatible couples) using the method fnc2()
 * 
 *
 * 
 * 
 */
class instantiate{
    int a;
    char b;
    void initialize(){
      a=10;   
    }
    
    int ret(int c){
    
        return c;
    }
    /**@param 
     * <br />This function "sorts" sorts the gift(gift type given as parameter) object's 
     * 
     * array according to the mentioned attribute<br />
    */
    public void sorts(essential_gift[] ess,String price,int no){
        int i,j,k;  essential_gift t;
        for(i=0;i<12;i++){
            for(j=i+1;j<12;j++){
                if(ess[i].price>ess[j].price){
                    t=ess[i];
                    ess[i]=ess[j];
                    ess[j]=t;
                }
                    
            }
        }
    }
    public void sorts(utility_gift[] ess,String price,int no){
        int i,j,k,t;
        for(i=0;i<12;i++){
            for(j=i+1;j<12;j++){
                if(ess[i].price>ess[j].price){
                    t=ess[i].price;
                    ess[i].price=ess[j].price;
                    ess[j].price=t;
                }
                    
            }
        }
    }
     public void sorts(luxury_gift[] ess,String price,int no){
        int i,j,k,t;
        for(i=0;i<12;i++){
            for(j=i+1;j<12;j++){
                if(ess[i].price>ess[j].price){
                    t=ess[i].price;
                    ess[i].price=ess[j].price;
                    ess[j].price=t;
                }
                    
            }
        }
    }
     
     /** @param print_k_happy
      * This function prints the k most happy
         couples here k=5.Takes the couple[] array, the integer k and a string determining 
         attribute according to which couples should be sorted
     */
      public void print_k_happy(couple [] c,String happy,int k){
        int i,j; long t;
        for(i=0;i<12;i++){
            for(j=i+1;j<12;j++){
                if(c[i].happy<c[j].happy){
                    t=c[i].happy;
                    c[i].happy=c[j].happy;
                    c[j].happy=t;
                }
            }
        }
        System.out.println("The k(5)-most happy couples are(boy girl) :");
        for(i=0;i<k;i++){
            System.out.println(c[i].b_obj.name + " "+ c[i].g_obj.name);
           // System.out.println(c[i].total_cost_of_gifts);
        }
    }
    
      /**@param print_k_comp : This function prints the k most 
          compatible couples , takes couple object's array the integer k and a string determining 
         attribute according to which couples should be sorted
      */
      
      public void print_k_comp(couple [] c,String compati,int k){
        int i,j,t;
        for(i=0;i<12;i++){
            for(j=i+1;j<12;j++){
                if(c[i].compati<c[j].compati){
                    t=c[i].compati;
                    c[i].compati=c[j].compati;
                    c[j].compati=t;
                }
            }
        }
        System.out.println("The k(5)-most compatible couples are(boy girl) :");
        for(i=0;i<k;i++){
            System.out.println(c[i].b_obj.name + " "+ c[i].g_obj.name);
        }
    }
      
      
      
    /**@param generateString this function returns a randomly generated string
       @param length is the length of string to be generated
       *@param characters is set of characters to be used
       * @param rng is the objrct of random class
       * <br />
    */
    public static String generateString(Random rng, String characters, int length){
        char[] text = new char[length];
        for (int i = 0; i < length; i++)
        {
            text[i] = characters.charAt(rng.nextInt(characters.length()));
        }
         return new String(text);
    }
}
public class testing {
   /**
     * @return fnc1 returns couple's object array 
     * @see testing 
    * fnc1 makes 12 couples
    * fnc2 prints the gifting details and k most happy and compatible couples
    * 
    * @throws IOException in case of an error in i/p o/p operations
    */
    public  couple[] fnc1()throws IOException
    {   
            instantiate obj=new instantiate();
            couple[] c = new couple[12];
            girl[] g=new girl[12];
            boy[] b=new boy[48];
            int i;
            String s="abcdefghijklmnopqrstuvwxyz";
       
       for ( i=0; i<g.length; i++) {         //instantiating boys,girls and couple objects
           g[i]=new girl();
           c[i]=new couple();
       }
        for (  i=0; i<b.length; i++) {
           b[i]=new boy();
       }
      int h; 
      h=obj.ret(0);
      
        FileWriter out = null;
        
        /* generating attributes randomly for girls and writing the generated data in 
           a csv file
        */
        
        out = new FileWriter("output.csv");
       
        Random rand_Generator = new Random();
      for (int idx = 1; idx <= 12; ++idx){
            int att = rand_Generator.nextInt(10)+3;
            int intell=rand_Generator.nextInt(10);
            int cost=rand_Generator.nextInt(1000);
            Random r=new Random();
                String f=obj.generateString(r,s,r.nextInt(5)+5);
                    out.write(f+",");
                    out.write(String.valueOf(att)+",");
                    out.write(String.valueOf(intell)+",");
                    out.write(String.valueOf(cost)+"\n");   
     }   
        out.close();
        String line;
        i=0;
        
        /*assigning the girls their respective attributes by reading 
          the data from csv file
        */
        
        BufferedReader br=new BufferedReader(new FileReader("output.csv"));
            while((line=br.readLine())!=null){
      
                 String [] arr=line.split(",");
                        g[i].name=arr[0];
                        g[i].attractiveness=Integer.parseInt(arr[1]);
                        g[i].intelligence_level=Integer.parseInt(arr[2]);
                        g[i].maint_cost=Integer.parseInt(arr[3]);
                        g[i].commit=false;
                i++;
         
            }
     
     /* generating attributes randomly for boys and writing the generated data in 
           another csv file
     */
     
      out = new FileWriter("outputboy.csv");
   for (int idx = 1; idx <= 48; ++idx){
            int att_b = rand_Generator.nextInt(3);
            int intell_b=rand_Generator.nextInt(10);
                int low=1001;
                int high=3000;
        int budget=rand_Generator.nextInt(high-low)+low;
        int min_attr=rand_Generator.nextInt(3);
             Random r=new Random();
             String f=obj.generateString(r,s,r.nextInt(10)+3);
        out.write(f+",");
        out.write(String.valueOf(att_b)+",");
        out.write(String.valueOf(intell_b)+",");
        out.write(String.valueOf(budget)+",");
        out.write(String.valueOf(min_attr)+"\n");
      }
      out.close(); 
      i=0;
      
      /*assigning the boys their respective attributes by reading 
        the data from another csv file
      */
      
      BufferedReader bro=new BufferedReader(new FileReader("outputboy.csv"));
      while((line=bro.readLine())!=null){
          String [] arr=line.split(",");
          b[i].name=arr[0];
          b[i].attractiveness=Integer.parseInt(arr[1]);
          b[i].intelligence_level=Integer.parseInt(arr[2]);
          b[i].budget=Integer.parseInt(arr[3]);
          b[i].min_attraction=Integer.parseInt(arr[4]);
          b[i].commit=false;
          i++;
         
      }
       int criter ;
       
      // Assigning criteria for selection of boys randomly to girls
     
      for(i=0;i<12;i++){
                criter= rand_Generator.nextInt(3);
                    if(criter==0)
                        g[i].criteria="intelligence_level";
                    else if(criter==1)
                        g[i].criteria="attractiveness";
                    else
                        g[i].criteria="richness";
      }
      int j,k,ind = 0;
      boy ob;
      
    //Assigning boyfriends to girls according to their criteria
    
    System.out.println("The 12-couples formed are : (boy and girl)");
    
      for(i=0;i<12;i++){
          if(g[i].criteria=="intelligence_level" && g[i].commit== false)
          {   
              int max=-1;
              for(j=0;j<48;j++)
              {     if(b[j].intelligence_level> max && b[j].commit==false)
                  {       if(b[j].budget > g[i].maint_cost && g[i].attractiveness> b[j].min_attraction)
                        {  max=b[j].attractiveness;
                           ind=j;  }
                           else
                               continue;
              }
              } 
              b[ind].commit=true;
              g[i].commit=true;
              g[i].bf_index=ind;
              c[i].g_obj=g[i]; c[i].b_obj=b[ind];
            
             System.out.println(b[ind].name+  " " + g[i].name);
              
          }
          if(g[i].criteria=="attractiveness" && g[i].commit== false)
          {   
              int m=-1;
              for(j=0;j<48;j++)
              {     if(b[j].attractiveness > m && b[j].commit==false)
                  {      if(b[j].budget > g[i].maint_cost && g[i].attractiveness> b[j].min_attraction)
                        {m=b[j].attractiveness;
                           ind=j;  }
                           else
                      continue;
                  }
              }
              b[ind].commit=true;
              g[i].commit=true;
              g[i].bf_index=ind;
              c[i].g_obj=g[i]; c[i].b_obj=b[ind];
              
            
               
              System.out.println(b[ind].name   +" "+ g[i].name);
              
           }
          if("richness".equals(g[i].criteria) && g[i].commit== false)
          {   //ob=b[0];
              int m=0;
              for(j=0;j<48;j++)
              {     if(b[j].budget> m  && b[j].commit==false)
                  {     if(b[j].budget >g[i].maint_cost && g[i].attractiveness> b[j].min_attraction)
                        {  m=b[j].budget;
                           ind=j;  }
                           else {
                  }
                  }
              }
              b[ind].commit=true;
              g[i].bf_index=ind;
              g[i].commit=true;
              c[i].g_obj=g[i]; c[i].b_obj=b[ind];
            
              System.out.println(b[ind].name+" "+ g[i].name);
              
          }
    }
        return c;  
    }
    /**
     * @param c Array of objects of couple class  
    
    */
    public void fnc2(couple[] c)throws IOException{
        
    essential_gift[] ess = new essential_gift[70];
    utility_gift[] util =new utility_gift[70];
    luxury_gift[] lux= new luxury_gift[70];
   FileWriter out3=null;
    out3 = new FileWriter("gifts.csv");
   int i,j;
    instantiate obj=new instantiate();
    Random rand_Generator= new Random();

// instantiating the gifts objects
    
  for(j=0;j<70;j++){
        ess[j]= new essential_gift();
        util[j]=new utility_gift();
        lux[j]=new luxury_gift();
    }
  
  /*Generating values and prices for the 3 types of gifts
     and storing in a csv file
  */ 
    for(j=0;j<70;j++){
        int pr_ess = rand_Generator.nextInt(100)+10;
        int val_ess= rand_Generator.nextInt(10);
        out3.write(String.valueOf(pr_ess)+",");
        out3.write(String.valueOf(val_ess)+"\n");
        ess[j].price=pr_ess;
        ess[j].value=val_ess;
    }
    for(j=0;j<70;j++){
        int pr_ut = rand_Generator.nextInt(500)+100;
        int val_ut= rand_Generator.nextInt(20)+11;
        out3.write(String.valueOf(pr_ut)+",");
        out3.write(String.valueOf(val_ut)+"\n");
        util[j].price=pr_ut;
        util[j].value=val_ut;
    }
    for(j=0;j<70;j++){
        int pr_lux = rand_Generator.nextInt(1000)+100;
        int val_lux= rand_Generator.nextInt(20)+11;
        out3.write(String.valueOf(pr_lux)+",");
        out3.write(String.valueOf(val_lux)+"\n");
        lux[j].price=pr_lux;
        lux[j].value=val_lux;
    }
    out3.close();
    obj.sorts(ess,"price", 12);
    obj.sorts(util,"price", 12);
    obj.sorts(lux,"price", 12);
    /* Assigning types to girlfriends and 
        boyfriends
    */
    for(i=0;i<12;i++){
        int t= rand_Generator.nextInt(3);
        if(t==0)
            c[i].b_obj.type ="miser";
        if(t==1)
             c[i].b_obj.type ="generous";
        if(t==2)
             c[i].b_obj.type= "geeks";
    }
    
    for(i=0;i<12;i++){
        int t= rand_Generator.nextInt(3);
        if(t==0)
            c[i].g_obj.type ="choosy";
        if(t==1)
             c[i].g_obj.type ="normal";
        if(t==2)
             c[i].g_obj.type= "desperate";
    }
    
    test2 object=new test2();
    int[] cost_of_gifts=new int[12];
    long[] happ=new long [12];
    int[] comp=new int[12];
    cost_of_gifts=object.gift_basket(c, 12, ess, util, lux);
    happ=object.happiness(c, 12, cost_of_gifts);
    comp=object.compatibility(c, 12);   String line;
    System.out.println("The gifting details are(total cost of gifts):");
    //BufferedReader in=new BufferedReader(new FileReader("gifting_log.txt"));
    for(i=0;i<12;i++){
        System.out.println(c[i].b_obj.name +" "+ c[i].g_obj.name+ "  " +c[i].total_cost_of_gifts);
    }      
    /*while((line=in.readLine())!=null){
      
                 System.out.println(line);
         
            }
      in.close(); */      
    obj.print_k_happy(c,"happy", 5);
    obj.print_k_comp(c, "compati", 5);
   
    
}
}    

