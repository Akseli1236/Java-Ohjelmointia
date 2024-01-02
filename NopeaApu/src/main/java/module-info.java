module nan.nopeaapu {
    requires javafx.controls;
    requires javafx.fxml;

    opens nan.nopeaapu to javafx.fxml;
    exports nan.nopeaapu;
}
