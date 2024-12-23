package hust.soict.dsai.aims.screen.controller;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class CartScreenController {

    private final Cart cart;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;


    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private RadioButton radioBtnFilterId;

    @FXML
    private RadioButton radioBtnFilterTitle;

    @FXML
    private Label costLabel;

    @FXML
    private TextField tfFilter;

    @FXML
    private Button placeOrder;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediacategory;

    @FXML
    private TableView<Media> tblMedia;
    public CartScreenController(Cart cart) {
        super();
        this.cart = cart;
    }

    @FXML
    void placeOrderPressed(ActionEvent event) {
        // Gọi phương thức placeOrder từ lớp Cart và lấy thông báo
        String message = cart.placeOrder();  // Ensure this returns a String
        // Hiển thị thông báo trong hộp thoại thông tin
        Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
        alert.setTitle("Order Status");
        alert.setHeaderText(null);
        alert.showAndWait();

        // Cập nhật lại tổng chi phí và danh sách hiển thị
        updateCartView();
    }


    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        Alert alert;
        try {
            alert = new Alert(Alert.AlertType.NONE, media.playGUI());
            alert.setTitle("Playing");
            alert.setHeaderText(null);
            alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
            alert.showAndWait();
        } catch (PlayerException e) {
            alert = new Alert(Alert.AlertType.ERROR, e.getMessage());
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.showAndWait();
        }        
    }
    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media); // Xóa sản phẩm khỏi giỏ hàng
            updateCartView(); // Cập nhật lại giao diện
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "No media selected to remove.");
            alert.setTitle("Remove Media");
            alert.setHeaderText(null);
            alert.showAndWait();
        }
    }

    @FXML
    void initialize() {
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colMediacategory.setCellValueFactory(new PropertyValueFactory<>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<>("cost"));

        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        costLabel.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);	

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if (newValue != null) {
                    btnRemove.setVisible(true);
                    btnPlay.setVisible(newValue instanceof Playable);
                }
            }
        );

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> showFilteredMedia(newValue));
    }

    private void showFilteredMedia(String keyword) {
        FilteredList<Media> filteredList = new FilteredList<>(FXCollections.observableArrayList(cart.getItemsOrdered()), media -> {
            if (keyword == null || keyword.isEmpty()) {
                return true;
            } else if (radioBtnFilterId.isSelected()) {
                return String.valueOf(media.getId()).contains(keyword);
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(keyword.toLowerCase());
            }
            return false;
        });
        tblMedia.setItems(filteredList);
    }

    private void updateCartView() {
        tblMedia.setItems(FXCollections.observableArrayList(cart.getItemsOrdered()));
        costLabel.setText(cart.totalCost() + "$");

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);
    }
}
