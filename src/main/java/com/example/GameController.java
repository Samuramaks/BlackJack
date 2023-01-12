package com.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class GameController {

    Croupier cr = new Croupier();

    private String literal_croupier = "The croupier's move";
    private String literal_croupier_win = "Winning Croupier";
    private String literal_player = "Player move";
    private String literal_player_win = "Winning Player, Congratulations!!!";
    private String literal_again = "Would you like to try again?";

    private ObservableList<String> str;

    @FXML
    private ListView<String> listView = new ListView<>();

    @FXML
    private Button btnStart;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnAgain;

    @FXML
    private Button btnStop;

    // Start button
    @FXML
    void btnOnClickedStart(ActionEvent event) {
        EnableBtn();
        cr.Battle();
        Output();
        btnStart.setDisable(true);

    }

    // Button for adding cards
    @FXML
    void btnOnClickAdd(ActionEvent event) {
        if (cr.count_player > 21) {
            CheckWin();
        } else {
            if (cr.count_croipier < 17) {
                cr.Battle();
                Output();
            } else {
                cr.CardPlayer();
                Output();
            }
        }

    }

    // Button for skipping a move
    @FXML
    void btnOnClickStop(ActionEvent event) {
        if (cr.count_player > 21) {
            CheckWin();
        } else {
            if (cr.count_croipier < 17) {
                cr.Extraction();
                Output();
            } else if (cr.count_croipier >= 17) {
                CheckWin();
            }
        }

    }

    // Button to restart the game
    @FXML
    void btnOnClickAgain(ActionEvent event) {
        cr.count_croipier = 0;
        cr.count_player = 0;
        cr.Full();
        cr.Battle();
        Output();
        DisableBtnAgain();
        EnableBtn();
    }

    // Exit button
    @FXML
    void btnOnClickExit(ActionEvent event) {
        System.exit(0);
    }

    // Actions when loading a scene
    @FXML
    void initialize() {
        DisableBtn();
        DisableBtnAgain();
    }

    // Method for checking the winner
    void CheckWin() {
        if (cr.count_player > 21 && cr.count_croipier <= 21) {
            DisableBtn();
            EnableBtnAgain();
            OutputWinCroipier();
        } else if (cr.count_croipier > 21 && cr.count_player > 21) {
            DisableBtn();
            EnableBtnAgain();
            OutputTie();
        } else if (cr.count_player < 21) {
            if (cr.count_player > cr.count_croipier || cr.count_player == 21) {
                DisableBtn();
                EnableBtnAgain();
                OutputWinPlayer();
            } else if (cr.count_croipier >= 21) {
                DisableBtn();
                EnableBtnAgain();
                OutputWinPlayer();
            }
        }
    }

    // Method for displaying points and cards from the player and croupier
    void Output() {
        str = FXCollections.observableArrayList(literal_croupier,
                String.format("Croupier Cards: %s\nCroupier Points: %d",
                        cr.card[cr.indexCardCroupier].name, cr.count_croipier),
                literal_player,
                String.format("Your Cards: %s\nOur points: %d",
                        cr.card[cr.indexCardPlayer].name, cr.count_player));
        listView.setItems(str);
    }

    // A method to display a croupier's victory
    void OutputWinCroipier() {
        str = FXCollections.observableArrayList(literal_croupier_win, literal_again);
        listView.setItems(str);
    }

    // Method for outputting the draw
    void OutputTie() {
        str = FXCollections.observableArrayList("There are no winners! Tie");
        listView.setItems(str);
    }

    // A method to display a player's win
    void OutputWinPlayer() {
        str = FXCollections.observableArrayList(literal_player_win, literal_again);
        listView.setItems(str);
    }

    // Method for disabling the add card and skip move buttons
    void DisableBtn() {
        btnAdd.setDisable(true);
        btnStop.setDisable(true);
    }

    // Method for activating the add card and skip move buttons
    void EnableBtn() {
        btnAdd.setDisable(false);
        btnStop.setDisable(false);
    }

    // Method for disabling the start again button
    void DisableBtnAgain() {
        btnAgain.setDisable(true);
    }

    // The method of activating the start over button
    void EnableBtnAgain() {
        btnAgain.setDisable(false);
    }
}
