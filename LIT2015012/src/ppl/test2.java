package ppl;
import java.util.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @see test2 class creating gift basket and calculating compatibility and happiness for a couple
 */
public class test2 {
    /** A method for exchanging 
       of gifts between the couples according to the 
       type of boy 
     * @param c array of objects of couple class
     * @param no number of couples
     * @param e  array of objects of essential_gift class
     * @param u  array of objects of utility_gift class
     * @param lux array of objects of luxury_gift class
     * @return  array containing total cost of gifts for each couple
     * @throws java.io.IOException in case of an error while reading/writing file
    */
    public int[] gift_basket(couple[] c,int no,essential_gift[] e,utility_gift[] u,luxury_gift[] lux) throws IOException{
        int i,j; 
       
        int[] cost_of_gifts = new int[12];
      //  Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      
        for(i=0;i<70;i++){
            e[i].assigned=false;
            u[i].assigned=false;
            lux[i].assigned=false;
        }
        Random r = new Random();
        FileWriter out =null;
        out= new FileWriter("gifting_log.txt");
        for(i=0;i<no;i++){
            
            out.write("Couple "+String.valueOf(i+1)+"  ");
            out.write(c[i].b_obj.name+" "+ c[i].g_obj.name+"\n");
        //    out.write(String.valueOf(timestamp));
            if("miser".equals(c[i].b_obj.type))
            {
                int cost_g= c[i].g_obj.maint_cost;
                int budget= c[i].b_obj.budget;
                int cost=0;int ess = 0;
                while(cost_g>=cost && budget>=e[0].price ){
                   
                   //int util = r.nextInt(70);
                   if(e[ess].assigned==false){
                        budget -= (e[ess].price);
                        cost=(int) (cost+e[ess].price);
                         e[ess].assigned=true;
          //        out.write(String.valueOf(timestamp)+" ");       
                  out.write(String.valueOf(e[ess].price)+"  "+String.valueOf(e[ess].value)+"\n");
                  
                }
                   ess++;
             }
                cost_of_gifts[i]=cost;
                c[i].total_cost_of_gifts=cost;
                c[i].b_obj.budget=budget;        //remaining money with boy
            for(j=0;j<70;j++){
            e[j].assigned=false;
            u[j].assigned=false;
             }
        }
            
            
            if("generous".equals(c[i].b_obj.type))
            {
                int cost_g= c[i].g_obj.maint_cost;
                int budget= c[i].b_obj.budget;
                int cost=0;
                while(cost_g>=cost && budget>u[0].price){
                   
                   int util = r.nextInt(70);
                   int lu = r.nextInt(70);
                   if(budget>lux[0].price && lux[lu].assigned==false){
                        budget -= ( lux[lu].price);
                        cost=(int) (cost+lux[lu].price);
                        lux[lu].assigned=true;
           //      out.write(String.valueOf(timestamp)+" ");       
                 out.write(String.valueOf(lux[lu].price)+"  "+String.valueOf(lux[lu].value)+"\n");
                }
                   else if(u[util].assigned==false){
                        budget -= ( u[util].price);
                        cost=(int) (cost+u[util].price);
                        u[util].assigned=true;
              //   out.write(String.valueOf(timestamp)+" ");       
                 out.write(String.valueOf(u[util].price)+"  "+String.valueOf(u[util].value)+"\n");
                }
                   
             }
                while(budget>e[0].price){
                    int ess = r.nextInt(70);
                    if(u[ess].assigned == false){
                        budget-=(e[ess].price);
                        cost+=e[ess].price;
                        e[ess].assigned=true;
                       // out.write(String.valueOf(timestamp)+" ");
                        out.write(String.valueOf(e[ess].price)+"  "+String.valueOf(e[ess].value)+"\n");
                    }
                }
                cost_of_gifts[i]=cost;
                c[i].total_cost_of_gifts=cost;
                c[i].b_obj.budget=budget;        //remaining money with boy
            for(j=0;j<70;j++){
            e[j].assigned=false;
            u[j].assigned=false;
            lux[j].assigned=false;
             }
        }
            if("geeks".equals(c[i].b_obj.type)){
                int cost_g= c[i].g_obj.maint_cost;
                int budget= c[i].b_obj.budget;
                int cost=0,lu;
                while(cost_g>=cost){
                   int ess = r.nextInt(70);
                   int util = r.nextInt(70);
                   if(e[ess].assigned==false && u[util].assigned == false){
                        budget -= (e[ess].price+ u[util].price);
                        cost=(int) (cost+e[ess].price+u[util].price);
                         e[ess].assigned=true; u[util].assigned= true;
             //            out.write(String.valueOf(timestamp)+" ");
                         out.write(String.valueOf(e[ess].price)+"  "+String.valueOf(e[ess].value)+" \n"+String.valueOf(u[util].price)+" "+String.valueOf(u[util].value)+"\n");
                }
            }
                if(budget>=lux[0].price){
                   
                         lu=r.nextInt(70);
                    if(lux[lu].assigned==false){
                        lu=r.nextInt(70);
                    }
                        else{
                                budget -= (lux[lu].price);
                                cost+=(int) (lux[lu].price);
                                 lux[lu].assigned=true; 
                // out.write(String.valueOf(timestamp)+" ");                
                 out.write(String.valueOf(lux[lu].price)+"  "+String.valueOf(lux[lu].value +"\n"));              
                       }
                        
                }
                 cost_of_gifts[i]=cost;
                 c[i].total_cost_of_gifts=cost;
                c[i].b_obj.budget=budget;        //remaining money with boy
            for(j=0;j<70;j++){
            e[j].assigned=false;
            u[j].assigned=false;
            lux[j].assigned=false;
             }
            
        
    }
}        out.close();
        return cost_of_gifts;
    }
    
    
    /* A function to calculate happiness of 
       all the 12 couples
    */
    /**
     * 
     * @param c  array of objects of class couple
     * @param no  integer denoting no of couples
     * @param cost_of_gifts total cost of gift passed as an array
     * @return  returns array containing each couple's happiness
     */
 public long [] happiness(couple[] c,int no,int cost_of_gifts[])  {
     int i,j,k,happ_g = 0,happ_b = 0;
     long [] happy_couple =new long[12];
     for(i=0;i<12;i++){
         String g_h= c[i].g_obj.type;
         String b_h= c[i].b_obj.type;
         if("choosy".equals(g_h))
             happ_g= (int) Math.log(Math.abs(cost_of_gifts[i]-c[i].g_obj.maint_cost));
         if("normal".equals(g_h))
             happ_g=(int)2*cost_of_gifts[i];
         if("desperate".equals(g_h))
             happ_g=(int)Math.exp((cost_of_gifts[i]- c[i].g_obj.maint_cost));
         if("miser".equals(b_h))
             happ_b =c[i].b_obj.budget;
         if("geeks".equals(b_h))
             happ_b=c[i].g_obj.intelligence_level;
         if("generous".equals(b_h)) 
             happ_b= happ_g;
         
         happy_couple[i]=happ_g + happ_b;
         c[i].happy=happy_couple[i];
     }
     
  return happy_couple;   
 }
 
 /* A function to calculate compatibility 
    of all the couples
 */
 /**
  * 
  * @param c  array of objects of class couple
  * @param no  integer denoting no of couples
  * @return returns integer  array containing compatibility 
  */
public int[] compatibility(couple[] c,int no){
    int i;
    int[] comp = new int[12];
    for(i=0;i<12;i++){
    comp[i]=Math.abs(c[i].b_obj.intelligence_level-c[i].g_obj.intelligence_level)
            +Math.abs(c[i].b_obj.attractiveness-c[i].g_obj.attractiveness)
            +Math.abs(c[i].g_obj.maint_cost-c[i].b_obj.budget);
     c[i].compati=comp[i];
    }
    return comp ;
    }   
}
