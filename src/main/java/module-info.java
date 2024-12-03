module com.pls {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.prefs;
    requires jakarta.xml.bind;

    exports com.pls.address;
    opens com.pls to javafx.fxml;
    opens com.pls.address to jakarta.xml.bind, javafx.fxml;
}