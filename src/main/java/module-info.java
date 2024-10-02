module org.example.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    // authorise the view folder to be used by javafx in the java code.
    opens org.example.javafx to javafx.fxml;
    opens org.example.javafx.View to javafx.fxml;
    exports org.example.javafx;
    exports org.example.javafx.View;
}