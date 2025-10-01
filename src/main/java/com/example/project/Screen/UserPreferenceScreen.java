package com.example.project.Screen;

import com.example.project.StoreData;
import com.example.project.UserData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class UserPreferenceScreen extends Application {

    public void start(Stage stage){
        Text signUpLabel = new Text("Tell us your Preferences");
        signUpLabel.setFont(new Font("Arial", 26));
        signUpLabel.setStyle("-fx-font-weight: bold;");

        Text Religion = new Text("Partner Religion");
        Religion.setFont(new Font("Arial", 16));
        ComboBox<String> cbo = new ComboBox<>();
        cbo.getItems().addAll("Choose","Muslim","Christian","Hindu","Other");
        cbo.setValue("Choose");

        Text Status = new Text("Partner Education:");
        Status.setFont(new Font("Arial", 16));
        ComboBox<String> cbo2 = new ComboBox<>();
        cbo2.getItems().addAll("Choose","Graduation","Middle","Primary","Other");
        cbo2.setValue("Choose");

        Text Marriage = new Text("Partner Marital Status:");
        Marriage.setFont(new Font("Arial", 16));
        ComboBox<String> cbo3 = new ComboBox<>();
        cbo3.getItems().addAll("Choose","Single","Married","Widow","Other");
        cbo3.setValue("Choose");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 15px;");

        submitButton.setOnAction(e -> {
            String religion = cbo.getValue();
            String education = cbo2.getValue();
            String maritalStatus = cbo3.getValue();
            if (religion.equals("Choose") || education.equals("Choose") || maritalStatus.equals("Choose")) {
                ErrorMessage("Enter All the details!");
            } else {
                StoreData store = new StoreData();
                UserData currentUserData = store.getUserDetails(SignUpScreen.username); // setting the preferences
                if (currentUserData != null) {
                    currentUserData.setPrefReligion(religion);
                    currentUserData.setPrefEducation(education);
                    currentUserData.setPrefMaritalStatus(maritalStatus);
                    store.saveUsersData();
                    SuccessfulLogin("Preference saved");
                }
            }
        });

        Button moveBack = new Button("Back");
        moveBack.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: red; -fx-text-fill: white;");

        moveBack.setOnAction(e -> {
            SignUpScreen sign = new SignUpScreen();
            sign.start(stage);
        });


        GridPane gp = new GridPane();
        gp.setPadding(new Insets(40));
        gp.setVgap(15);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);
        gp.setStyle("-fx-background-color: linear-gradient(to bottom, #ecf0f1, #d6eaf8);");

        gp.add(signUpLabel, 0, 0, 2, 1);
        //gp.add(pr, 0, 1);
        //gp.add(radioBox, 0, 2, 2, 1);
        gp.add(Religion, 0, 1);
        gp.add(cbo, 1, 1);
        gp.add(Status, 0, 2);
        gp.add(cbo2, 1, 2);
        gp.add(Marriage, 0, 3);
        gp.add(cbo3, 1, 3);
        gp.add(submitButton, 0, 4, 2, 1);
        gp.add(moveBack, 0, 5, 2, 1);


        Scene signUpScene = new Scene(gp, 360, 600);
        stage.setScene(signUpScene);
        stage.setTitle("Sign Up Form");
        stage.show();

    }

    private void ErrorMessage(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    private void SuccessfulLogin(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

