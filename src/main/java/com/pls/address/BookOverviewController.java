package com.pls.address;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    /**
     * Инициализация класса-контроллера. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
        // Инициализация таблицы адресатов с двумя столбцами.
        titleColumn.setCellValueFactory(cellData -> {
            System.out.println("Title: " + cellData.getValue().getTitle());
            return cellData.getValue().titleProperty();
        });
        genreColumn.setCellValueFactory(cellData -> {
            System.out.println("Genre: " + cellData.getValue().getGenre());
            return cellData.getValue().genreProperty();
        });
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