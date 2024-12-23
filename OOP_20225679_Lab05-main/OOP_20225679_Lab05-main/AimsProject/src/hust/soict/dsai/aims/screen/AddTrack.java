package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.screen.controller.AddTrackScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddTrack extends JFrame {

    private final CompactDisc compactDisc;

    public AddTrack(CompactDisc compactDisc) {
        super();
        if (compactDisc == null) {
            throw new IllegalArgumentException("CompactDisc cannot be null");
        }
        this.compactDisc = compactDisc;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Tracks");
        this.setSize(640, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/view/addTracks.fxml"));
                loader.setController(new AddTrackScreenController(this.compactDisc));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, 
                    "Error loading the Add Tracks screen: " + e.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CompactDisc sampleCD = new CompactDisc(1, "Sample CD", "Music", 19.99f);
            new AddTrack(sampleCD);
        });
    }
}
