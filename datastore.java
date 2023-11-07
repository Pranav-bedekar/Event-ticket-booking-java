import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class datastore {

    public static void signup(String username, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("user_data.txt", true))) {
            writer.write(username + "," + password + "\n");
            System.out.println("User data stored in user_data.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
