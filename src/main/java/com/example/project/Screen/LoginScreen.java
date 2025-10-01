package com.example.project.Screen;

import com.example.project.StoreData;
import com.example.project.UserData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class LoginScreen extends Application {
    private StoreData st = new StoreData();
    @Override
    public void start(Stage stage) {
        Text loginLabel = new Text("Login");
        loginLabel.setFont(new Font("Arial", 26));
        loginLabel.setStyle("-fx-font-weight: bold;");

        Text usernameLabel = new Text("Username:");
        usernameLabel.setFont(new Font("Arial", 16));
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter Username");
        usernameField.setStyle("-fx-font-size: 14px; -fx-pref-width: 250px; -fx-background-radius: 8px;");


        Text pass = new Text("Password:");
        pass.setFont(new Font("Arial", 16));
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setStyle("-fx-font-size: 14px; -fx-pref-width: 250px; -fx-background-radius: 8px;");

        Button LoginButton = new Button("Login");
        LoginButton.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: blue; -fx-text-fill: white; -fx-background-radius: 15px;");

        LoginButton.setOnAction(e -> {
            String username = usernameField.getText();
            String password = passwordField.getText();
            boolean loginSuccess = st.verifyUser(username, password);
            if (loginSuccess) {
                UserData loggedInUserData = st.getUserDetails(username);
                UserProfileScreen profileScreen = new UserProfileScreen(loggedInUserData);
                profileScreen.start(stage);
            } else {
                ErrorMessage("Invalid username or password!");
            }
        });
        Button moveBack = new Button("Back");
        moveBack.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: red; -fx-text-fill: white;");

        moveBack.setOnAction(e -> {
            WelcomeScreen welcomeScreen = new WelcomeScreen();
            welcomeScreen.start(stage);
        });

        Image backgroundImage = new Image("Login.jpg");
        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, false, false, false, true)
        );

        GridPane gp = new GridPane();
        gp.setPadding(new Insets(40));
        gp.setVgap(15);
        gp.setHgap(10);
        gp.setAlignment(Pos.CENTER);
        gp.setBackground(new Background(bgImage));

        gp.add(loginLabel, 0, 0, 2, 1);
        gp.add(usernameLabel, 0, 1);
        gp.add(usernameField, 1, 1);
        gp.add(pass, 0, 2);
        gp.add(passwordField, 1, 2);
        gp.add(LoginButton, 0, 10, 2, 1);
        gp.add(moveBack, 0, 11, 2, 1);


        Scene loginScene = new Scene(gp, 360.0F, 600.0F);
        stage.setScene(loginScene);
        stage.setTitle("Login");
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

