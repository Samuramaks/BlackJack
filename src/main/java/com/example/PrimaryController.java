package com.example;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    void btnOnActivatedGame() throws IOException {
        App.setRoot("game");
    }

}
