
import data.Data;
import data.User;

public class Logic {

    public static void main(String[] args) {
        // Example usage
        registerUser("John Doe", "johndoe", "password123");

        User user = Data.getInstance().findUserByUsername("johndoe");
        if (user != null) {
            System.out.println("User found: " + user.getName());
        } else {
            System.out.println("User not found.");
        }
    }

    public static void registerUser(String name, String username, String password) {
        Data data = Data.getInstance();

        User user = new User(name, username, password);

        if (data.addUser(user)) {
            System.out.println("User registered successfully.");
        } else {
            System.out.println("Registration failed. User array is full.");
        }
    }
}
