package com.pls.address;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


import com.pls.address.MainApp;
import com.pls.address.Book;

public class BookOverviewController {
    @FXML
    private TableView<Book> bookTable;
    @FXML
    private TableColumn<Book, String> titleColumn;
    @FXML
    private TableColumn<Book, String> genreColumn;

    @FXML
    private Label titleLabel;
    @FXML
    private Label hardcoverLabel;
    @FXML
    private Label publisherLabel;
    @FXML
    private Label yearLabel;
    @FXML
    private Label genreLabel;

    // Ссылка на главное приложение.
    private MainApp mainApp;

    /**
     * Конструктор.
     * Конструктор вызывается раньше метода initialize().
     */
    public BookOverviewController() {
    }


    private void showBookDetails(Book book) {
        if (book != null) {
            titleLabel.setText(book.getTitle());
            hardcoverLabel.setText(book.getHardcover());
            publisherLabel.setText(book.getPublisher());
            yearLabel.setText(Integer.toString(book.getYear()));
            genreLabel.setText(book.getGenre());

            // TODO: Нам нужен способ для перевода дня рождения в тип String!
        } else {
            titleLabel.setText("");
            hardcoverLabel.setText("");
            publisherLabel.setText("");
            yearLabel.setText("");
            genreLabel.setText("");
        }
    }
    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(cellData -> {
            System.out.println("Title: " + cellData.getValue().getTitle());
            return cellData.getValue().titleProperty();
        });
        genreColumn.setCellValueFactory(cellData -> {
            System.out.println("Genre: " + cellData.getValue().getGenre());
            return cellData.getValue().genreProperty();
        });

        showBookDetails(null);

        bookTable.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showBookDetails(newValue));
    }

    @FXML
    private void handleDeleteBook() {
        int selectedIndex = bookTable.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            bookTable.getItems().remove(selectedIndex);
        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleEditBook() {
        Book selectedBook = bookTable.getSelectionModel().getSelectedItem();
        if (selectedBook != null) {
            boolean okClicked = mainApp.showBookEditDialog(selectedBook);
            if (okClicked) {
                showBookDetails(selectedBook);
            }

        } else {
            // Ничего не выбрано.
            Alert alert = new Alert(AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No book Selected");
            alert.setContentText("book select a book in the table.");

            alert.showAndWait();
        }
    }

    @FXML
    private void handleNewBook() {
        Book tempBook = new Book();
        boolean okClicked = mainApp.showBookEditDialog(tempBook);
        if (okClicked) {
            mainApp.getBookData().add(tempBook);
        }
    }



    /**
     * Вызывается главным приложением, которое даёт на себя ссылку.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;

        // Добавление в таблицу данных из наблюдаемого списка
        bookTable.setItems(mainApp.getBookData());
    }
}