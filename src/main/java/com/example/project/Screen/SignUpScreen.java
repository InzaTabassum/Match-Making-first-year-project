package com.example.project.Screen;

import com.example.project.StoreData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class SignUpScreen extends Application {
    private StoreData st = new StoreData();
    public static String username = "";

    @Override
    public void start(Stage stage) {
        Text signUpLabel = new Text("Create Your Account");
        signUpLabel.setFont(new Font("Arial", 26));
        signUpLabel.setStyle("-fx-font-weight: bold;");

        Text pr = new Text("Gender:");
        pr.setFont(new Font("Arial", 16));

        RadioButton rb1 = new RadioButton("Male");
        RadioButton rb2 = new RadioButton("Female");
        ToggleGroup tg = new ToggleGroup();
        rb1.setToggleGroup(tg);
        rb2.setToggleGroup(tg);

        HBox radioBox = new HBox(10);
        radioBox.setAlignment(Pos.CENTER_LEFT);
        radioBox.getChildren().addAll(rb1, rb2);

        Text emailLabel = new Text("Email:");
        emailLabel.setFont(new Font("Arial", 16));
        TextField emailField = new TextField();
        emailField.setPromptText("Enter your email");
        emailField.setStyle("-fx-font-size: 14px; -fx-pref-width: 250px; -fx-background-radius: 8px;");

        Text usernameLabel = new Text("Username:");
        usernameLabel.setFont(new Font("Arial", 16));
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");
        usernameField.setStyle("-fx-font-size: 14px; -fx-pref-width: 250px; -fx-background-radius: 8px;");

        Text pass = new Text("Password:");
        pass.setFont(new Font("Arial", 16));
        PasswordField password = new PasswordField();
        password.setPromptText("Enter your password");
        password.setStyle("-fx-font-size: 14px; -fx-pref-width: 250px; -fx-background-radius: 8px;");

        Text cpass = new Text("Confirm Password:");
        cpass.setFont(new Font("Arial", 16));
        PasswordField cpassword = new PasswordField();
        cpassword.setPromptText("Re-Enter your password");
        cpassword.setStyle("-fx-font-size: 14px; -fx-pref-width: 250px; -fx-background-radius: 8px;");

        Text Religion = new Text("Religion");
        Religion.setFont(new Font("Arial", 16));
        ComboBox<String> cbo = new ComboBox<>();
        cbo.getItems().addAll("Choose","Muslim","Christian","Hindu","Other");
        cbo.setValue("Choose");

        Text Status = new Text("Education:");
        Status.setFont(new Font("Arial", 16));
        ComboBox<String> cbo2 = new ComboBox<>();
        cbo2.getItems().addAll("Choose","Graduation","Middle","Primary","Other");
        cbo2.setValue("Choose");

        Text Marriage = new Text("Marital Status:");
        Marriage.setFont(new Font("Arial", 16));
        ComboBox<String> cbo3 = new ComboBox<>();
        cbo3.getItems().addAll("Choose","Single","Married","Widow","Other");
        cbo3.setValue("Choose");

        Button submitButton = new Button("Submit");
        submitButton.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 15px;");

        submitButton.setOnAction(e -> {
            String username = usernameField.getText();
            String passwordText = password.getText();
            String confirmPassword = cpassword.getText();
            String email = emailField.getText();
            String gender = tg.getSelectedToggle() == null ? "" : ((RadioButton) tg.getSelectedToggle()).getText();
            String religion = cbo.getValue();
            String education = cbo2.getValue();
            String maritalStatus = cbo3.getValue();

            if (email.isEmpty() || username.isEmpty() || passwordText.isEmpty() || confirmPassword.isEmpty() ||
                    gender.isEmpty() || religion.equals("Choose") || education.equals("Choose") || maritalStatus.equals("Choose")) {
                ErrorMessage("Enter All the details!");
            } else if (!email.contains("@")) {
                ErrorMessage("Invalid email address!");
            } else if (!passwordText.equals(confirmPassword)) {
                ErrorMessage("Password and Confirm Password do not match!");
            } else {
                st.registerNewUser(username, passwordText, email, gender, religion, education, maritalStatus);
                UserPreferenceScreen us = new UserPreferenceScreen();
                us.start(stage);
                SignUpScreen.username = username;// to save preference
            }
        });
        Button moveBack = new Button("Back");
        moveBack.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: red; -fx-text-fill: white;");

        moveBack.setOnAction(e -> {
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            welcomeScreen.start(stage);
        });


        GridPane gp = new GridPane();
        gp.setPadding(new Insets(40));
        gp.setVgap(15);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);

        gp.add(signUpLabel, 0, 0, 2, 1);
        gp.add(emailLabel, 0, 1);
        gp.add(emailField, 1, 1);
        gp.add(usernameLabel, 0, 2);
        gp.add(usernameField, 1, 2);
        gp.add(pass, 0, 3);
        gp.add(password, 1, 3);
        gp.add(cpass, 0, 4);
        gp.add(cpassword, 1, 4);
        gp.add(pr, 0, 5);
        gp.add(radioBox, 0, 6, 2, 1);
        gp.add(Religion, 0, 7);
        gp.add(cbo, 1, 7);
        gp.add(Status, 0, 8);
        gp.add(cbo2, 1, 8);
        gp.add(Marriage, 0, 9);
        gp.add(cbo3, 1, 9);
        gp.add(submitButton, 0, 10, 2, 1);
        gp.add(moveBack, 0, 11, 2, 1);

        gp.setStyle("-fx-background-color: linear-gradient(to bottom, #ecf0f1, #d6eaf8);");

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


}
