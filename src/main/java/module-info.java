module fr.nikolai.calculatrice {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.nikolai.calculatrice to javafx.fxml;
    exports fr.nikolai.calculatrice;
}