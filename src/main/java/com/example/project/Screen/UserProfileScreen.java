package com.example.project.Screen;

import com.example.project.StoreData;
import com.example.project.UserData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

public class UserProfileScreen extends Application {
    private UserData userData;

    public UserProfileScreen(UserData userData) {
        this.userData = userData;
    }

    @Override
    public void start(Stage stage) {
        Text title = new Text("Hello "+ userData.getUsername());
        title.setFont(new Font("Arial", 26));
        title.setStyle("-fx-font-weight: bold;");

        Text matchTitle = new Text("Match Suggestions for you:");
        matchTitle.setFont(new Font("Arial", 18));
        matchTitle.setStyle("-fx-font-weight: bold;");
        StoreData store = new StoreData();
        store.findMatches(userData);
        ArrayList<UserData> matches = store.getMatchedUsers();

        VBox matchBox = new VBox(5);
        for (int i = 0; i < store.getMatchedUsers().size(); i++) {
            Text t = new Text("- " + matches.get(i).getUsername() + " (" + matches.get(i).getGender() + ", " + matches.get(i).getReligion() +", "+ matches.get(i).getEducation()+", "+matches.get(i).getMaritalStatus()+ ")");
            Button viewButton = new Button("View detail");
            UserData currentUserData = matches.get(i);
            viewButton.setOnAction(e -> {
                MatchDetailScreen ms = new MatchDetailScreen(currentUserData, userData);
                ms.start(stage);
            });
            t.setFont(new Font("Arial", 14));
            matchBox.getChildren().addAll(t,viewButton);
        }


        Button backButton = new Button("Logout");
        backButton.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: red; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.start(stage);
        });

        VBox container = new VBox(12);
        container.setPadding(new Insets(40));
        container.setAlignment(Pos.TOP_CENTER);
        container.getChildren().addAll(title, matchTitle, matchBox, backButton);
        container.setStyle("-fx-background-color: linear-gradient(to bottom, #ecf0f1, #d6eaf8);");

        Scene scene = new Scene(container, 360.0, 600.0);
        stage.setScene(scene);
        stage.setTitle("UserData Details");
        stage.show();
    }
}
