
import java.util.Random;
import java.util.Scanner;




public class payment {
    static Scanner scanner=new Scanner(System.in);
    
  
    public static  void checkout(){
        int i=0;
        while ( i<=1) { 
        
        
        System.out.println("Checkout initiated");
        System.out.println("the tolat amount will be:"+ custsomer.custsomerPrice);
        System.out.println("Please select payment method");
        System.out.println("1. Cash or card");
        System.out.println("2. Online");
        Scanner scanner=new Scanner(System.in);
        int paymentMethod=scanner.nextInt();
        if(paymentMethod==1){
            System.out.println("Please enter the amount");
            int amount=scanner.nextInt();
            if(amount>=custsomer.custsomerPrice){
                System.out.println("Payment successful");
                System.out.println("Your change is "+(amount-custsomer.custsomerPrice));
                custsomer.custsomerPrice=custsomer.custsomerPrice-custsomer.custsomerPrice;
               
                break;
                }else{
                    System.out.println("insuffent amount");
                    i++;
                    }
                    }else if(paymentMethod==2){
                        System.out.println("Please enter your phone number details");
                        long phone=scanner.nextLong();
                        Random random = new Random();
                        int f1 = random.nextInt(100);
                        System.out.println(f1);
                       
                        System.out.println("enter the otp");
                        int f2 =scanner.nextInt();
                        if (f1==f2) {
                            System.out.println("Payment successful");
                            break;
                        } else {
                            
                        System.out.println("Payment unsuccessful");
                        i++;
                        }

                       
                    }




    }}
   

   
}

    
    
