package ro.nicolaemariusghergu.easylearn.books.service;

import ro.nicolaemariusghergu.easylearn.books.dto.BookDTO;

import java.util.List;

public interface BookService {

    void saveBooks(List<BookDTO> books);

    List<BookDTO> getBooksFromRemote();
}
