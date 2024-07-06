import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class driver {

    static Scanner scanner = new Scanner(System.in);
    static analysis a1=new analysis();
   static boolean flag=true;
    public static void main(String[] args) {
 

    do{
        String url = "jdbc:mysql://localhost:3306/userdetails";
        String user = "root";
        String password = "sanjai";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Database connected successfully!");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to connect to the database");
            e.printStackTrace();
        }
    System.out.println("Hi, welcome to the mutisplex");
    System.out.println("What do you want to do?");
    System.out.println("1. regular customer");
    System.out.println("2. Register for new customer");
    System.out.println("3. Exit");

    System.out.print("Enter your choice: ");
    int choice=scanner.nextInt();
    

        
            switch (choice) {
                case 1 -> {
                    System.out.println("Ok, you want to login.");
                    
                    
                    a1.processcommad(choice);
                }
                case 2 -> {
                    System.out.println("Ok, you want to register.");
                    a1.processcommad(choice);
                }
                case 3 -> System.out.println("Exiting the program...");
                default -> System.out.println("Invalid choice. Please try again.");
            }
    
    }while(flag);


        
        
        
    

   
    




    }

    public static analysis getA1() {
        return a1;
    }
}


