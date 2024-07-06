import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class analysis {

    
    public void processcommad(int s1) {
        switch (s1) {
            case 1 -> userDetails.check();
            case 2 -> userDetails.register();
            default -> System.out.println("Unknown command.");
        }    
    }
    public static void item() throws SQLException{
         try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/userdetails";
            String user = "root";
            String password = "sanjai";

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM userdetails.item");
            ResultSet resultSet = preparedStatement.executeQuery();
           

    
            while (resultSet.next()) {
                String itemList = resultSet.getString("itemList");
                int itemQuit = resultSet.getInt("qun");
                double itemPrice = resultSet.getDouble("itemPrice");
                System.out.println("Iteam: " + itemList + ", quntity avalable: " + itemQuit+ ", Price:INR " + itemPrice);
            }
            connection.close();
            custsomer.a2();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         
    }
}