module me.feuerente {
    requires javafx.controls;
    requires javafx.fxml;

    opens me.feuerente to javafx.fxml;
    exports me.feuerente;
}