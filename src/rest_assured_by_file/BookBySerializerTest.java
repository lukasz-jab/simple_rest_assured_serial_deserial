package rest_assured_by_file;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import rest_assured_by_file.data.Book;
import rest_assured_by_file.data.Util;

import java.io.File;

public class BookBySerializerTest {
    private static final String FILE_NAME = "book";
    private final Book LOTR_BOOK = new Book("Lord of The Rings", "J.R.R. Tolkien");

    @Test
    @Order(1)
    public void shouldBeAbleToSerializeBook() {
        File serializedBook = Util.serializeObject(LOTR_BOOK, FILE_NAME);
    }

    @Test
    @Order(2)
    public void shouldBeAbleToDeSerializeBook() {
        Book deserializedBook = Util.deserializeObject(FILE_NAME);
        System.out.println("###################################");
        System.out.println(deserializedBook.getTitle());
        System.out.println(deserializedBook.getAuthor());
        System.out.println("###################################");
    }

    @AfterAll
    public static void deleteFile() {
        File file = new File(FILE_NAME);
        if (!file.delete()) {
            throw new RuntimeException("Was unable to delete file!");
        }
    }
}
