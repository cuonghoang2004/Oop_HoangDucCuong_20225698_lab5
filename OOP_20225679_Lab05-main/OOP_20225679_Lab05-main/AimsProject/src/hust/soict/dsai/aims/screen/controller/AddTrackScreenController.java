package hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTrackScreenController {
    private final CompactDisc CD;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSaveTrack;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddTrackScreenController(CompactDisc CD) {
        if (CD == null) {
            throw new IllegalArgumentException("CompactDisc cannot be null");
        }
        this.CD = CD;
    }

    @FXML
    void btnSaveTrackPressed(ActionEvent event) {
        try {
            String title = tfTitle.getText().trim();
            if (title.isEmpty()) {
                throw new IllegalArgumentException("Title cannot be empty!");
            }

            // Parse length as an integer
            int length = Integer.parseInt(tfLength.getText().trim());
            if (length <= 0) {
                throw new IllegalArgumentException("Length must be greater than zero!");
            }

            // Add track to the CD
            Track track = new Track(title, length);
            CD.addTrack(track);

            // Clear the input fields
            tfTitle.clear();
            tfLength.clear();
            btnSaveTrack.setDisable(true);

            // Show success alert
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Track Added");
            alert.setContentText("Track '" + title + "' has been added successfully!");
            alert.showAndWait();

        } catch (NumberFormatException e) {
            showErrorAlert("Invalid input for length. Please enter a valid integer.");
        } catch (IllegalArgumentException e) {
            showErrorAlert(e.getMessage());
        }
    }

    @FXML
    void initialize() {
        btnSaveTrack.setDisable(true);

        // Add listeners to the text fields to check if they are filled
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().trim().isEmpty() && !tfLength.getText().trim().isEmpty();
        btnSaveTrack.setDisable(!allFieldsFilled);
    }

    private void showErrorAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Failed to Add Track");
        alert.setContentText(message);
        alert.showAndWait();
    }
}
