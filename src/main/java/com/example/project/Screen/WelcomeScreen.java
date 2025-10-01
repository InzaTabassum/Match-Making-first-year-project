package com.example.project.Screen;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public class WelcomeScreen extends Application {
    @Override
    public void start(Stage stage) {
        Text welLabel = new Text("Match Making");
        welLabel.setFont(new Font("Arial", 24.0F));
        welLabel.setStyle("-fx-font-weight: bold; -fx-fill: white;");

        Button logIn = new Button("Log in");
        Button signIn = new Button("Sign Up");

        Text New = new Text("New to Match Making?");
        New.setStyle("-fx-font-weight: bold; -fx-fill: white;");
        Text NotNew = new Text("Already have an account?");
        NotNew.setStyle("-fx-font-weight: bold; -fx-fill: white;");

        logIn.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px;");
        signIn.setStyle("-fx-font-size: 16px; -fx-pref-width: 250px;");

        signIn.setOnAction(e -> {
            SignUpScreen signUpForm = new SignUpScreen();
            signUpForm.start(stage);
        });

        logIn.setOnAction(e -> {
            LoginScreen loginForm = new LoginScreen();
            loginForm.start(stage);
        });

        VBox topContainer = new VBox();
        topContainer.setAlignment(Pos.TOP_CENTER);
        topContainer.setPadding(new Insets(20, 0, 40, 0));
        topContainer.getChildren().add(welLabel);

        Region spacer = new Region();
        VBox.setVgrow(spacer, Priority.ALWAYS);

        VBox vb = new VBox(20);
        vb.setAlignment(Pos.BOTTOM_CENTER);
        vb.setPadding(new Insets(40));
        vb.setPrefWidth(360);
        vb.getChildren().addAll(topContainer, spacer, New, signIn, NotNew, logIn);

        Image backgroundImage = new Image("background.jpg");
        BackgroundImage bgImage = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(100, 100, false, false, false, true)
        );
        vb.setBackground(new Background(bgImage));

        Scene scene = new Scene(vb, 360.0F, 600.0F);
        stage.setScene(scene);
        stage.setTitle("WelcomeScreen - Match Making");
        stage.show();
    }
}
