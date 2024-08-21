import java.util.List;

public interface IBookService {
    void borrowBook(User user, Book book, int days, List<Book> bookList);
    void SearchBook();
    void ReturnBook();
}
