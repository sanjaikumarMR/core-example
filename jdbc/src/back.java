import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class back  {
   
    
    public static void rollback(){
        for (custsomer orderlist : custsomer.orderlist) {
            System.out.println("your oder are"+ orderlist);}

        
        System.out.println("do you want to chage the order");
        System.out.println("1.change the order or quntity");
        System.out.println("2.delete the order");
        System.out.println("3.cancel the order");
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter your choise");
        int r1 =scanner.nextInt();
        switch (r1) {
            case 1 -> change();
            case 2 -> delete();
            case 3 ->  cancel();
            default -> System.out.println("Unknown command.");
        }  
        

       
    }
    public static void change(){
        try {
            
           
            System.out.println("enter what to change");
            System.out.println("1.item");
            System.err.println("2.quntatiy");
            Scanner scanner=new Scanner(System.in);
            int r1 =scanner.nextInt();
            if (r1==1) {
                System.out.println("enter the itemName");
                String itemName = scanner.next();
                System.out.println("enter number of quntiy to change:");
                int qun3=scanner.nextInt();
                Class.forName("com.mysql.cj.jdbc.Driver");
                String  url = "jdbc:mysql://localhost:3306/userdetails";
                String user = "root";
                String password = "sanjai";
                Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT itemPrice,qun FROM item WHERE itemList = ?");
                preparedStatement.setString(1, itemName); 
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()){
                    int price = resultSet.getInt("itemPrice");
                     int qun1 = resultSet.getInt("qun");
                }
                else{
                    System.out.println("out of stock");
                }
            } 
                

        } catch (Exception e) {
        }

    }
    public static void delete(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String  url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
        }

    }
    public static void cancel(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String  url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);

        } catch (Exception e) {
        }

    }
    
}
