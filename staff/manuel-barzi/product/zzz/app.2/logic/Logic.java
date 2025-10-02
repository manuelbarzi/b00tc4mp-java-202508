package logic;

import data.Data;
import data.User;

import error.*;

public class Logic {

    private static Logic instance;

    private String username;

    private Logic() {
    }

    public void registerUser(String name, String username, String password) throws DuplicityException {
        Data data = Data.get();

        User user = data.findUserByUsername(username);

        if (user != null) {
            throw new DuplicityException("user already exists");
        }

        user = new User(name, username, password);

        data.addUser(user);
    }

    public void loginUser(String username, String password) throws NotFoundException, CredentialsException {
        Data data = Data.get();

        User user = data.findUserByUsername(username);

        if (user == null) {
            throw new NotFoundException("user not found");
        }

        if (!user.getPassword().equals(password)) {
            throw new CredentialsException("wrong password");
        }

        this.username = username;
    }

    public String getUserName() throws NotFoundException {
        Data data = Data.get();

        User user = data.findUserByUsername(this.username);

        if (user == null) {
            throw new NotFoundException("user not found");
        }

        return user.getName();
    }

    public static Logic get() {
        return instance == null ? instance = new Logic() : instance;
    }

    // public static void main(String[] args) {
    // Logic logic = Logic.get();
    // Data data = Data.get();

    // // registerUser test
    // try {
    // logic.registerUser("John Doe", "johndoe", "password123");

    // logic.registerUser("John Doe", "johndoe", "password123");
    // } catch (DuplicityException e) {
    // e.printStackTrace();
    // }

    // User user = data.findUserByUsername("johndoe");
    // if (user != null) {
    // System.out.println("User found: " + user.getName());
    // } else {
    // System.out.println("User not found.");
    // }
    // }
}
