package com.pls.address;

import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Класс-модель для адресата (Person).
 *
 * @author Marco Jakob
 */
public class Book {

    private final StringProperty title;
    private final StringProperty hardcover;
    private final StringProperty publisher;
    private final IntegerProperty year;
    private final StringProperty genre;

    /**
     * Конструктор по умолчанию.
     */
    public Book() {
        this(null, null);
    }

    /**
     * Конструктор с некоторыми начальными данными.
     *
     * @param title
     * @param genre
     */
    public Book(String title, String genre) {
        this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);

        // Какие-то фиктивные начальные данные для удобства тестирования.
        this.hardcover = new SimpleStringProperty("твёрдая обложка");
        this.year = new SimpleIntegerProperty(2020);
        this.publisher = new SimpleStringProperty("АСТ");
    }

    public String getTitle() {
        return title.get();
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public StringProperty titleProperty() {
        return title;
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String genre) {
        this.genre.set(genre);
    }

    public StringProperty genreProperty() {
        return genre;
    }

    public String getHardcover() {
        return hardcover.get();
    }

    public void setHardcover(String hardcover) {
        this.hardcover.set(hardcover);
    }

    public StringProperty hardcoverProperty() {
        return hardcover;
    }

    public int getYear() {
        return year.get();
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public IntegerProperty yearProperty() {
        return year;
    }

    public String getPublisher() {
        return publisher.get();
    }

    public void setPublisher(String publisher) {
        this.publisher.set(publisher);
    }

    public StringProperty publisherProperty() {
        return publisher;
    }
}