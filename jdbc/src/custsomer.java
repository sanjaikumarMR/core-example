
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class custsomer extends payment{
    static Scanner scanner=new Scanner(System.in);
    static boolean flag=true;
    public static int custsomerPrice=0;
    public static int qun;
    public static String itemName;
    public custsomer(int qun, String itemName){
        this.qun=qun;
        this.itemName=itemName;
        }
    public static List<custsomer> orderlist = new ArrayList<>();
    @Override
    public String toString() {
        return "Customer [items=" + itemName + ", quantity=" + qun + "]";
    }
    

    public static  void m1(int qun1, String itemList1){
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String  url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);
            int qun=qun1;
            String itemList=itemList1;
           
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET qun = ? WHERE itemList = ?");
            preparedStatement.setInt(1, qun);
            preparedStatement.setString(2,itemList );               
            ResultSet resultSet = preparedStatement.executeQuery(); 
            connection.close();

                
            } catch (Exception e) {
            }
    }
    public static void a2() throws ClassNotFoundException, SQLException{
         Class.forName("com.mysql.cj.jdbc.Driver");
            String  url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);
           
        do{

            System.out.println("enter the itemName:");
            String itemList=scanner.nextLine();
            
            if (itemList.equalsIgnoreCase("exit")) {
                flag = false;
                payment.checkout();
                break;
                
            }
            //if (itemList.equalsIgnoreCase("back")) {
               // flag = false;
               // back.rollback();
                
            //}
            
            System.out.println("enter the quintity:");
            int qun=scanner.nextInt();
            scanner.nextLine();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT itemPrice,qun FROM item WHERE itemList = ?");
            preparedStatement.setString(1, itemList); 
            ResultSet resultSet = preparedStatement.executeQuery(); 
   
            if (resultSet.next()){
                int price = resultSet.getInt("itemPrice");
                 int qun1 = resultSet.getInt("qun");
            if(qun<=qun1){
                custsomerPrice+=price*qun;
                System.out.println("your total price is "+custsomerPrice);
                qun1=qun1-qun;
                custsomer order1=new custsomer(qun1, itemList);
                orderlist.add(order1);
                m1(qun1,itemList);
            }
            else{
                System.out.println("out of stock");
            }
        }
        
           
           
      

        }
        while (flag);

    }
    
}
