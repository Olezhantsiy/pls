module com.pls {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.pls to javafx.fxml;
    exports com.pls;
}