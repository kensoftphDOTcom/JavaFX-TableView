module com.kensoftph.tableview {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kensoftph.tableview to javafx.fxml;
    exports com.kensoftph.tableview;
}