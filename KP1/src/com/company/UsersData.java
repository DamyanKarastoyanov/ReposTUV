package com.company;

import java.util.HashMap;
import java.util.Map;

public class UsersData {

    protected Map<User,Boolean> usersList = new HashMap<>();

    public UsersData() {
        User admin = new User("admin","123");
        usersList.put(admin, true);
    }

    public void addUser(String username, String password){
        if( username == "admin"){
            System.out.println("The username is forbidden and used only by the administrators.");
        }
        User addedUser = new User(username,password);
        usersList.put(addedUser, false);
        System.out.println("The user: '" + addedUser.getUsername() + "' was successfully added.");

    }
    public void removeUser(String username){
        boolean found_flag = false;
        for( Map.Entry<User, Boolean> user : usersList.entrySet() ){
            if( user.getKey().getUsername() == username) {
                usersList.remove(user);
                System.out.println("The user: '" + username + "' was successfully deleted from the system.");
            }
        }
        if( !(found_flag)) {
            System.out.println("The user: '" + username + "' was not found in the system.");
        }
    }
    public Map.Entry<User, Boolean> loginUser(String username, String password){
        for( Map.Entry<User, Boolean> user : usersList.entrySet() ){
            String[] userData = displayEntry(user).split(" / ");
            String dataUsername = userData[0];
            String dataPassword = userData[1];
            boolean dataAccess = Boolean.parseBoolean(userData[2]);

            if( username.equals(dataUsername) && password.equals(dataPassword)){
                return user;
            }
        }
        System.out.println("Your username and/or password were invalid.");
        return null;
    }

    public static String displayEntry(Map.Entry<User, Boolean> user){
        String username = user.getKey().getUsername();
        String password = user.getKey().getPassword();
        boolean admin_access = user.getValue();
        return username + " / " + password + " / " + admin_access;
    }
}