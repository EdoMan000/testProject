module com.example.thisisatest {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.thisisatest to javafx.fxml;
    exports com.example.thisisatest;
}