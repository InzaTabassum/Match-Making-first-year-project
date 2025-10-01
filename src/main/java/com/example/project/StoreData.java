package com.example.project;

import java.io.*;
import java.util.ArrayList;

public class StoreData implements InterfaceStoreData {
    private ArrayList<UserData> userData = new ArrayList<>();
    private ArrayList<UserData> matchedUserData = new ArrayList<>();

    public StoreData() {
        getUsersData();
    }


    @Override // save data on file
    public void saveUsersData() {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("UserData.txt"));
            os.writeObject(userData);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override // read data from file
    public void getUsersData() {
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("UserData.txt"));
            userData = (ArrayList<UserData>) is.readObject();
        } catch (Exception ce){
            System.out.println(ce);
        }
    }
//when a user enter his details on login screen they will saved in file
    public boolean registerNewUser(String username, String password, String email, String gender, String religion, String education, String maritalStatus) {
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        userData.add(new UserData(username, password, email,  gender, religion, education, maritalStatus));
        saveUsersData();
        userData.clear();
        return true;
    }
 // used to verify the password and email of user if they are correct or not which
 //they set while creating their profile.
    public boolean verifyUser(String username, String password) {
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).getUsername().equals(username) && userData.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
// used to get the data of those users  who succesfuly loged in
    public UserData getUserDetails(String username) {
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).getUsername().equals(username)) {
                return userData.get(i);
            }
        }
        return null;
    }
// try to match the user preference with other userdetails and find the matches
    public void findMatches(UserData currentUserData) {
        matchedUserData.clear();
        String preferredGender = currentUserData.getPreferredGender();
        for (int i = 0; i < userData.size(); i++) {
            if (userData.get(i).getGender().equalsIgnoreCase(preferredGender) && userData.get(i).getReligion().equalsIgnoreCase(currentUserData.getPrefReligion())
                    && userData.get(i).getEducation().equalsIgnoreCase(currentUserData.getPrefEducation()) && userData.get(i).getMaritalStatus().equalsIgnoreCase(currentUserData.getPrefMaritalStatus()))
            {
                matchedUserData.add(userData.get(i));
            }
        }
    }
// return the macthed users.
    public ArrayList<UserData> getMatchedUsers() {
        return matchedUserData;
    }
}
