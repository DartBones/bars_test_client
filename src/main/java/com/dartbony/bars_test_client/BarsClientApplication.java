package com.dartbony.bars_test_client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BarsClientApplication extends Application {
    private static final int SCENE_WIDTH = 800;
    private static final int SCENE_HEIGHT = 400;
    private static final String APP_TITLE = "Bars test client";
    private static final String DOCUMENT_VIEW_PATH = "hello-view.fxml";

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BarsClientApplication.class.getResource(DOCUMENT_VIEW_PATH));
        Scene scene = new Scene(fxmlLoader.load(), SCENE_WIDTH, SCENE_HEIGHT);
        stage.setTitle(APP_TITLE);
        stage.setScene(scene);
        stage.show();
    }
}