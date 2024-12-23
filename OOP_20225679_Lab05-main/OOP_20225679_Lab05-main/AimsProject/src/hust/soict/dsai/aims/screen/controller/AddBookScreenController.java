package hust.soict.dsai.aims.screen.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddBookScreenController {

    private Store store;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfAuthors;

    private boolean allFieldsFilled = false;

    public AddBookScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        float cost = 0.0f;

        try {
            cost = Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse cost!");
            alert.setTitle("Wrong type");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // Lấy danh sách tác giả từ ô nhập liệu
        String authorsInput = tfAuthors.getText();
        List<String> authors = new ArrayList<>();
        if (!authorsInput.isEmpty()) {
            String[] authorsArray = authorsInput.split(","); // Giả định các tên tác giả được phân tách bằng dấu phẩy
            for (String author : authorsArray) {
                authors.add(author.trim());
            }
        }

        // Sinh id tự động (ví dụ: dựa trên số lượng trong store)
        int id = store.getItemsInStore().size() + 1;

        // Tạo đối tượng Book
        Book book = new Book(id, title, category, cost, authors);

        // Thêm Book vào Store
        store.addMedia(book);

        // Xóa nội dung các ô nhập liệu
        tfTitle.clear();
        tfCategory.clear();
        tfCost.clear();
        tfAuthors.clear();

        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book has been added to the store!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        if (!tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfCost.getText().isEmpty()) {
            allFieldsFilled = true;
        } else {
            allFieldsFilled = false;
        }
        btnSave.setDisable(!allFieldsFilled);
    }
}
