package com.kensoftph.tableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader loader = new FXMLLoader(getClass().getResource("table-view.fxml"));
        //Scene scene = new Scene(loader.load());
        //stage.setTitle("JavaFX TableView");
        //stage.setScene(scene);


        // these lines of code here will be creating the tableview without using an FXML file
        TableView<Person> tableView = new TableView<>(Person.getInitialList());
        tableView.getColumns().addAll(Person.getFistNameCol(), Person.getLastNameCol(), Person.getOriginCol());
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        StackPane layout = new StackPane(tableView);

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setTitle("TableView in JavaFX");
        // end

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}