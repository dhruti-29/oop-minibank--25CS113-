

import java.util.Scanner;
class prac_1_1{
    public static void main(String[] args) {
        enum Coin{ONE,TWO, FIVE, TEN}
        
        int PRICE = 15;
        int total = 0;
        
        System.out.println("Enter Coins .. ONE, TWO, FIVE, TEN ");
        
        Scanner sc= new Scanner(System.in);
        
       
        
       // System.out.println(input);
       
       Coin c;
       while(total < PRICE){
            String input = sc.next().toUpperCase();
          try{
           c=Coin.valueOf(input);
          }
          catch(Exception e)
          {
               System.out.println("Not a Valid coin ");
                continue;
          }
            System.out.println(c);
       
             int value=0;
            switch(c){
                 case ONE: value =1;
                break;
           
                case TWO: value =2;
                    break;
           
                case FIVE: value =5;
                 break;
           
                case TEN: value =10;
                break;
           
            }
            
            total = total + value;
       System.out.println("Total Paid = "+ total);
       }
       
        System.out.println("Paid = "+ total + " Balance = " + (total - PRICE));
       
       
        
    }
}
