/*
Lina Breunlin
CIS 163AA
Program calculates the cost of a hotel stay based on the users loyalty status and length of stay
 */
package hotelstayprogram;
import java.util.Scanner;



public class HotelStayProgram {

    
    public static void main(String[] args) {
           

    //declare variables
    int lengthOfStay = 0;
    String loyaltyStatus;
    double discountRate = 0.0;
    double discountAmount= 0.0;
    double bill = 0.0;
    double finalBill = 0.0;
    final double NIGHTLY_RATE = 175.00;
    
    //get user input for loyalty status
    
    Scanner in = new Scanner (System.in);
    
    System.out.print ("Please enter your Loyalty Program Status (None, Gold, or Platinum):");
    
    loyaltyStatus=in.next();
    
    
     //Account for a wrong user input for loyalty status 
    
       if (!loyaltyStatus.equals("None") && !loyaltyStatus.equals("Gold") && !loyaltyStatus.equals("Platinum"))
    { 
        System.out.println("Error. Please enter a valid loyalty status.");
       return;
       
    }
   
   //get user input for number of nights  and check to make sure it is valid 
 
    System.out.print("Please enter the number of nights you are staying:");
    
   if (in.hasNextInt()) 
   {
       lengthOfStay = in.nextInt();
       if (lengthOfStay <= 0)
    {
       System.out.println("Error. You cannot stay less than one night. Please try again.");
       return;
    }
    
    
    //If less than two nights, there is no discount, so no need to ask for status
    
        if (lengthOfStay > 2) 
        {
        discountRate = 0.0;
        }
    
    //get discount rate when length of stay is between at least 2 but less than 5 nights
          
         if (lengthOfStay >=2 && lengthOfStay < 5)
            {
            if (loyaltyStatus.equals("Gold"))
          
            discountRate = 0.15;
      
            else if (loyaltyStatus.equals("Platinum"))
            
            discountRate = 0.25;
        
                else
            
                    discountRate = 0.0;
            }  
    
    // get discount rate when length of stay is 5 nights or more
    
          if (lengthOfStay >= 5) 
            {
     
            if (loyaltyStatus.equals("Gold"))
          
                discountRate = 0.25;
      
                    else if (loyaltyStatus.equals("Platinum"))
            
                        discountRate = 0.40;
        
                            else
            
                                discountRate = 0.0;
            }         
   }  
   
   else 
     {
       System.out.println ("Error. Please enter a valid number of nights.");
        return;
     }

    
    System.out.println("Your Loyalty Status is: " + loyaltyStatus);
    
    System.out.println("Your discount rate is: " + (discountRate*100)+ "%");
    
    bill = NIGHTLY_RATE * lengthOfStay;
    
    discountAmount = bill * discountRate;
    
    System.out.println("Your loyalty savings are: " + "$" + discountAmount);
    
    finalBill = bill - discountAmount;
    
     System.out.println("Your grand total is:" + "$" + finalBill);
     
     System.out.println("Thank you for staying at Lina's Hotel. We hope to see you again soon.");
    
      
    }
    }
   
