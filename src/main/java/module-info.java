module com.example.thisisatest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens com.example.thisisatest to javafx.fxml;
    exports com.example.thisisatest;
}