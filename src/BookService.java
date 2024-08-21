import java.util.List;

public class BookService implements IBookService {
    public FileService fileService =new FileService();
    List<History> histories;

    public BookService(){
        histories=fileService.FileReadService();
    }

    @Override
    public void borrowBook(User user, Book book, int days, List<Book> bookList) {
        History history=new History();
        history.setUserName(user.getName());
        history.setBookTitle(book.getTitle());
        history.setDays(days);
        histories.add(history);
        fileService.FileWriteService(histories);

    }

    @Override
    public void SearchBook() {

    }

    @Override
    public void ReturnBook() {

    }
}
