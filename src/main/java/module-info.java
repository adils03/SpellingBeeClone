module erciyes.edu.tr.kelimeoyunu {
    requires javafx.controls;
    requires javafx.fxml;


    opens erciyes.edu.tr.kelimeoyunu to javafx.fxml;
    exports erciyes.edu.tr.kelimeoyunu;
}