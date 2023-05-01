package com.kensoftph.tableview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

public class TableViewController implements Initializable {

    @FXML
    private TableColumn<Person, String> firstName;

    @FXML
    private TableColumn<Person, String> lastName;

    @FXML
    private TableColumn<Person, String> origin;

    @FXML
    private TableView<Person> table;

    @FXML
    private TextField txtFName;

    @FXML
    private TextField txtLName;

    @FXML
    private TextField txtOrigin;

    ObservableList<Person> initialData(){
        Person p1 = new Person("Sample","Last Sample Name"," US");
        Person p2 = new Person("Test","Last Name"," PH");
        return FXCollections.observableArrayList(p1, p2);
    }

    @FXML
    private void btnInsert(ActionEvent event){

        if(!txtFName.getText().isEmpty() || !txtLName.getText().isEmpty() || !txtOrigin.getText().isEmpty()){
            Person newData = new Person(txtFName.getText(), txtLName.getText(), txtOrigin.getText());
            table.getItems().add(newData);
            txtFName.clear();
            txtLName.clear();
            txtOrigin.clear();
        }else{
            System.out.println("Fields should not be empty.");
        }
    }

    @FXML
    private void deleteData(ActionEvent event){
        TableView.TableViewSelectionModel<Person> selectionModel = table.getSelectionModel();
        if(selectionModel.isEmpty()){
            System.out.println("You need select a data before deleting.");
        }

        ObservableList<Integer> list = selectionModel.getSelectedIndices();
        Integer[] selectedIndices = new Integer[list.size()];
        selectedIndices = list.toArray(selectedIndices);

        Arrays.sort(selectedIndices);

        for(int i = selectedIndices.length - 1; i >= 0; i--){
            selectionModel.clearSelection(selectedIndices[i].intValue());
            table.getItems().remove(selectedIndices[i].intValue());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstName.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<Person, String>("lastName"));
        origin.setCellValueFactory(new PropertyValueFactory<Person, String>("origin"));

        table.setItems(initialData());

        editData();
    }

    private void editData(){
        firstName.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        firstName.setOnEditCommit(event ->{
            Person person = event.getTableView().getItems().get(event.getTablePosition().getRow());
            person.setFirstName(event.getNewValue());
            System.out.println(person.getLastName() + "'s Name was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });

        lastName.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        lastName.setOnEditCommit(event ->{
            Person person = event.getTableView().getItems().get(event.getTablePosition().getRow());
            person.setLastName(event.getNewValue());
            System.out.println(person.getFirstName() + "'s Last Name was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });

        origin.setCellFactory(TextFieldTableCell.<Person>forTableColumn());
        origin.setOnEditCommit(event ->{
            Person person = event.getTableView().getItems().get(event.getTablePosition().getRow());
            person.setOrigin(event.getNewValue());
            System.out.println("Origin was updated to "+ event.getNewValue() +" at row "+ (event.getTablePosition().getRow() + 1));
        });
    }
}
