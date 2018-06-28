
package foreigncurrency;

import java.text.NumberFormat;
import java.util.Scanner;

/**
 *
 * @author jasmineherd
 */
public class ForeignCurrency {

    static Scanner sc = new Scanner(System.in);
    static double rEUR,rGBP,rJPY,rCAD,rRUB;
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Foreign Currency Calculator.");
        
        getRates();
        doValuation();
        System.out.println("Thanks for using the currency calculator");
        
    }

    public static void getRates() {
        System.out.println("Enter currency rates per US $");
        rEUR = getOneRate("EUR");
        rGBP = getOneRate("GBP");
        rJPY = getOneRate("JPY");
        rCAD = getOneRate("CAD");
        rRUB = getOneRate("RUB");
    }
    
    public static double getOneRate(String currency){
        double rate = 0;
        
        do{
            try{
            System.out.print(currency + ": ");
            rate = sc.nextDouble();
            if(rate <= 0){
                System.out.println("Rate must be > zero");
                        
                }       
               }catch(Exception e){
                    System.out.println("Illegal rate: non-numeric");
                    sc.nextLine();
                    rate = -1;
                }
                                
        }while(rate<=0);
        
        return rate;
    }

    public static void doValuation(){
            
        int choice,qty; //quantity
        double cval=0, totval = 0; //currency value
        NumberFormat curr =NumberFormat.getCurrencyInstance();
                //ARRAYS!!!
        int[] units = new int[5];// remember new = constructor call.remember oop
        for(int i =0; i <5; i ++){
            units[i]=0;
        }
        double ctot[] = {0,0,0,0,0};
        String[] cabv = {"EUR","GBP","JPY", "CAD","RUB"};

    
        choice = getChoice();//priming read
        while(choice !=0  ){
            cval =0;
            switch(choice){
                case 1:
                    qty = getQty("How many Euros ");
                    cval = qty * rEUR;
                    System.out.println(qty + " Euros has a value of " + 
                            curr.format(cval));
                    units[0] +=qty;
                    ctot[0] += cval;
                    break;//DONT FORGET TO BREAK!
                case 2:
                    qty = getQty("How many Pounds Sterling? ");
                    cval = qty * rGBP;
                    System.out.println(qty + " Pounds has a value of " + 
                            curr.format(cval));
                    units[1] += qty;
                    ctot[1] += cval;
                    break;
                case 3:
                    qty = getQty ("How many Yen? ");
                    cval = qty * rJPY;
                    System.out.println(qty + " Yen has a value of " + 
                            curr.format(cval));
                    units[2] += qty;
                    ctot[2] += cval;
                    break;
                case 4:
                    qty = getQty("How many Canadian Dollars? ");
                    cval = qty * rCAD;
                    System.out.println(qty + " Canadian Dollar has a value of " + 
                            curr.format(cval));
                    units[3] += qty;
                    ctot[3] += qty;
                     break;
                case 5:
                    qty = getQty("How many Rubles? ");
                    cval = qty * rRUB;
                    System.out.println(qty + " Ruble has a value of " + 
                            curr.format(cval));      
                    units[choice -1]+= qty;
                    ctot[choice -1]+= cval;
                    break;
                                          
                case 9:
                    getRates();
                    break;
                    
                default:
                    System.out.println("Unknown operation.");
                    break;
            }//switch
   
            
           totval += cval;
           choice = getChoice();
                    
  
            }//while
        for(int i= 0; i<5;i++){
        System.out.println(cabv[i] + ": "+
                " units costing: " +
                curr.format(ctot[i]));
    }
        
        System.out.println("Total value purchases = " +
                curr.format(totval));
        }//doValuation
        
    public static int getChoice(){
            int c = -1;
            
            do{
                try{
                    System.out.print("Currency?(1=EUR,2=GBP,3=JPY,4=CAD,5=RUB,9=New Rates 0=Quit)");
                    c = sc.nextInt();
                    if(c<0 || (c>5 && c != 9)){
                        System.out.print("Unknown currency.");
                    }
                    
               }catch(Exception e){
                   System.out.println("Illegal input: 0-5 or 9 only");
                   sc.nextLine();
                   c = -1; 
                          
               }
                
            }while(c < 0 || (c > 5 && c != 9));
            return c;        
        }
    
    //NEED FULL LOOP WITH VALIDATION AND TRY CATCH
    public static int getQty(String ctype){
        int q = -1;
        do{
            try{
                System.out.print(ctype);
                q = sc.nextInt();
                if(q < 0 ){
                    System.out.println("quantity must be non-negative. ");
                }
            }catch(Exception e ){
                System.out.println("Illegal quanity: must be non-negative ");
                sc.nextLine();
                q = -1;
                       
            }
        }while(q<0);
        return q;
    }
 

                   
        
       
    }
        
        
    
    
    
    
    
    
    
    
    
    
    
        
    
    
 
    
    
    
    
    
    
    
    
    
    

