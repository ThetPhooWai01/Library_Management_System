public class History {
    public String userName;

    private String bookTitle;
    private int days;

    public History(String userName, String bookTitle, int days) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.days = days;
    }

    public History() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }
}
