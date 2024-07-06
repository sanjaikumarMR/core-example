import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.Scanner;

public class userDetails extends analysis {
   /* public static    String username;
    public   int id;
    public    int phone;
    
    

   

    

    
    
    public userDetails(String username, int id,int phone) {
        this.username = username;
        this.id = id;
        this.phone = phone;
        
    }
    

  

  

    
    public   String getUsername() {
        return username;
    }

    public  int getId() {
        return id;
    }

    public   String getPassword() {
        return password;
    }*/
  
    static Scanner scanner = new Scanner(System.in);

    public static void check() {
        System.out.println("ID:");
        int inputIdLogin = scanner.nextInt();
        scanner.nextLine(); 
       

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);

          
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT userName FROM user WHERE id= ?");
            preparedStatement.setInt(1, inputIdLogin);  

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                String username = resultSet.getString("userName");
                System.out.println("Username: " + username);
                
                
                    System.out.println("hi , welcome  "  + username);
                 
                    analysis.item();
                } else {
                    System.out.println("Input is not present in the database.");
                }
            

                connection.close();
                resultSet.close();
                preparedStatement.close();
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
  
    public static void reg(int f12){
        try {
            System.out.println("Username:");
            String inputUsernameRegister = scanner.nextLine();

           

            System.out.println("Phone:");
            int phone = scanner.nextInt();
        
            System.out.println("your id  "+f12);

            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);
           
            
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user (id, userName, userNumber) VALUES (?, ?, ?)");

            
            preparedStatement.setInt(1, f12);
            preparedStatement.setString(2, inputUsernameRegister);
            preparedStatement.setInt(3, phone);

        
            int rowsInserted = preparedStatement.executeUpdate();
            System.out.println("regsistration is sucessfull  your id is :"+  f12);
            System.out.println("");
            connection.close();
          



            
        } catch (Exception e) {
        }
    }
  

    public static void register(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/userdetails";
                String user = "root";
                String password = "sanjai";
    
                Connection connection = DriverManager.getConnection(url, user, password);
                 Random random = new Random();
                int f12 = random.nextInt(10000);
                
               PreparedStatement preparedStatement = connection.prepareStatement("SELECT userName FROM user WHERE id= ?");
               preparedStatement.setInt(1, f12);  

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    connection.close();
                }else{
                   
                    reg(f12);
                   
                   }
                  
                    
                } catch (Exception e) {
                }
                
                
                          
    }

   
     
}