package com.pls.address;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import com.pls.address.Book;

/**
 * Окно для изменения информации об адресате.
 *
 * @author Marco Jakob
 */
public class BookEditDialogController {

    @FXML
    private TextField titleField;
    @FXML
    private TextField hardcoverField;
    @FXML
    private TextField publisherField;
    @FXML
    private TextField yearField;
    @FXML
    private TextField genreField;

    private Stage dialogStage;
    private Book book;
    private boolean okClicked = false;

    /**
     * Инициализирует класс-контроллер. Этот метод вызывается автоматически
     * после того, как fxml-файл будет загружен.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Устанавливает сцену для этого окна.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Задаёт адресата, информацию о котором будем менять.
     *
     * @param book
     */
    public void setBook(Book book) {
        this.book = book;

        titleField.setText(book.getTitle());
        hardcoverField.setText(book.getHardcover());
        publisherField.setText(book.getPublisher());
        yearField.setText(Integer.toString(book.getYear()));
        genreField.setText(book.getGenre());
    }

    /**
     * Returns true, если пользователь кликнул OK, в другом случае false.
     *
     * @return
     */
    public boolean isOkClicked() {
        return okClicked;
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке OK.
     */
    @FXML
    private void handleOk() {
        if (isInputValid()) {
            book.setTitle(titleField.getText());
            book.setHardcover(hardcoverField.getText());
            book.setPublisher(publisherField.getText());
            book.setYear(Integer.parseInt(yearField.getText()));
            book.setGenre(genreField.getText());

            okClicked = true;
            dialogStage.close();
        }
    }

    /**
     * Вызывается, когда пользователь кликнул по кнопке Cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }

    /**
     * Проверяет пользовательский ввод в текстовых полях.
     *
     * @return true, если пользовательский ввод корректен
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (titleField.getText() == null || titleField.getText().length() == 0) {
            errorMessage += "No valid title!\n";
        }
        if (hardcoverField.getText() == null || hardcoverField.getText().length() == 0) {
            errorMessage += "No valid hardcover!\n";
        }
        if (publisherField.getText() == null || publisherField.getText().length() == 0) {
            errorMessage += "No valid publisher!\n";
        }

        if (yearField.getText() == null || yearField.getText().length() == 0) {
            errorMessage += "No valid year!\n";
        } else {
            // пытаемся преобразовать почтовый код в int.
            try {
                Integer.parseInt(yearField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "No valid year (must be an integer)!\n";
            }
        }

        if (genreField.getText() == null || genreField.getText().length() == 0) {
            errorMessage += "No valid genre!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Показываем сообщение об ошибке.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Invalid Fields");
            alert.setHeaderText("Please correct invalid fields");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}