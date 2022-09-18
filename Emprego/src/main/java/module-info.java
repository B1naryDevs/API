module com.example.emprego {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.emprego to javafx.fxml;
    exports com.example.emprego;
}