package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;
import hust.soict.dsai.aims.screen.controller.AddCDScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStoreScreen extends JFrame {

    private final Store store;

    public static void main(String[] args) {
        Store store = new Store();
        new AddCompactDiscToStoreScreen(store);
    }

    public AddCompactDiscToStoreScreen(Store store) {
        super();
        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        this.setTitle("Add Compact Disc");
        this.setSize(1024, 768);
        this.setVisible(true);

        Platform.runLater(() -> {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/view/addCD.fxml"));
                loader.setController(new AddCDScreenController(store));
                Parent root = loader.load();
                fxPanel.setScene(new Scene(root));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
