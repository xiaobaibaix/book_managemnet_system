public class Book {
    private String title;
    private String author;
    private String isbn;
    private int cur_num;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCur_num() {
        return cur_num;
    }

    public void setCur_num(int cur_num) {
        this.cur_num = cur_num;
    }

    public Book(String title, String author, String isbn, int cur_num) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.cur_num = cur_num;
    }
}
