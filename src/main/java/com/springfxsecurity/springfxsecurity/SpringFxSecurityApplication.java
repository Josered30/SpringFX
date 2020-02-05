package com.springfxsecurity.springfxsecurity;

import com.springfxsecurity.springfxsecurity.configuration.StageManager;
import com.springfxsecurity.springfxsecurity.emuns.FxmlView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringFxSecurityApplication extends Application {

    protected ConfigurableApplicationContext springContext;
    protected StageManager stageManager;

    public static void main(String[] args){
        Application.launch(args);
    }


    @Override
    public void init() throws Exception {
        springContext = springBootApplicationContext();
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        stageManager = springContext.getBean(StageManager.class,primaryStage);
        displayInitialScene();

    }

    @Override
    public void stop() throws Exception {
        springContext.stop();
    }


    private void displayInitialScene(){
        stageManager.switchScene(FxmlView.LOGIN);
    }

    private ConfigurableApplicationContext springBootApplicationContext(){
        SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringFxSecurityApplication.class);
        String[] args = getParameters().getRaw().stream().toArray(String[]::new);
        return builder.run(args);
    }

}
