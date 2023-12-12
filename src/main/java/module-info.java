module com.example.ud05arraystring {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ud05arraystring to javafx.fxml;
    exports com.example.ud05arraystring;
}