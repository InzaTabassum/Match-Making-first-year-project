package com.example.project.Screen;

import com.example.project.UserData;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MatchDetailScreen extends Application {
    private UserData matchedUserData;
    private UserData loginUserData;

    public MatchDetailScreen(UserData matchedUserData, UserData loginUserData) {
        this.matchedUserData = matchedUserData;
        this.loginUserData = loginUserData;
    }

    @Override
    public void start(Stage stage) {
        Text title = new Text(matchedUserData.getUsername() + " Details");
        title.setFont(new Font("Arial", 26));
        title.setStyle("-fx-font-weight: bold;");

        Text emailLabel = new Text("Email: " + matchedUserData.getEmail());
        emailLabel.setFont(new Font("Arial", 15));

        Text gender = new Text("Gender: " + matchedUserData.getGender());
        gender.setFont(new Font("Arial", 15));

        Text education = new Text("Education: " + matchedUserData.getEducation());
        education.setFont(new Font("Arial", 15));

        Text marriage = new Text("Marital Status: " + matchedUserData.getMaritalStatus());
        marriage.setFont(new Font("Arial", 15));

        Text religion = new Text("Religion: " + matchedUserData.getReligion());
        religion.setFont(new Font("Arial", 15));

        Button backButton = new Button("Back");
        backButton.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px; -fx-background-color: red; -fx-text-fill: white;");
        backButton.setOnAction(e -> {
            UserProfileScreen up = new UserProfileScreen(loginUserData);
            up.start(stage);
        });

        VBox container = new VBox(12);
        container.setPadding(new Insets(40));
        container.setAlignment(Pos.TOP_CENTER);
        container.getChildren().addAll(title, emailLabel, gender, education, marriage, religion, backButton);
        container.setStyle("-fx-background-color: linear-gradient(to bottom, #ecf0f1, #d6eaf8);");

        Scene scene = new Scene(container, 360.0, 600.0);
        stage.setScene(scene);
        stage.setTitle("Match Details");
        stage.show();
    }
}
