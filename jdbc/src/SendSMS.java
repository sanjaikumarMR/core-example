import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class SendSMS {
    // Find your Account SID and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "your_account_sid";
    public static final String AUTH_TOKEN = "your_auth_token";

    public static void meg() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

        Message message = Message.creator(
                new PhoneNumber("user_phone_number"),  // To number
                new PhoneNumber("your_twilio_phone_number"),  // From number
                "Hello from Java!"  // SMS body
        ).create();

        System.out.println("Message sent successfully with SID: " + message.getSid());
    }
}
