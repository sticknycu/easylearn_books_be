package ro.nicolaemariusghergu.easylearn.books.schedules;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ro.nicolaemariusghergu.easylearn.books.service.AuthorService;
import ro.nicolaemariusghergu.easylearn.books.service.BookService;
import ro.nicolaemariusghergu.easylearn.books.service.CategoryService;
import ro.nicolaemariusghergu.easylearn.books.service.StatusService;

@Slf4j
@Component
@RequiredArgsConstructor
@EnableScheduling
@Profile(value = "uploadData")
public class UpdateInformationalDataScheduler {

    private final AuthorService authorService;
    private final BookService bookService;
    private final CategoryService categoryService;
    private final StatusService statusService;

    @Scheduled(fixedRate = 1000 * 60 * 60) // 1 hour
    public void run() {
        var categories = categoryService.getCategoriesFromRemote();
        var books = bookService.getBooksFromRemote();
        var authors = authorService.getAuthorsFromRemote();
        var statuses = statusService.getStatusFromRemote();

        categoryService.saveCategories(categories);
        authorService.saveAuthors(authors);
        statusService.saveStatuses(statuses);
        bookService.saveBooks(books);
    }
}
