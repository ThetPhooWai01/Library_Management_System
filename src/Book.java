import constant.EnumPool;

public class Book {
    private int id;
    private String title;
    private String author;
    private Category category;

    private boolean isBorrow;

    public Book(int id, String title, String author, Category category, boolean isBorrow) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isBorrow = isBorrow;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public boolean isBorrow() {
        return isBorrow;
    }

    public void setBorrow(boolean borrow) {
        isBorrow = borrow;
    }
}
