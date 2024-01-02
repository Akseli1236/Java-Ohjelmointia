module nan.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires json.simple;

    opens nan.mavenproject1 to javafx.fxml;
    exports nan.mavenproject1;
}
