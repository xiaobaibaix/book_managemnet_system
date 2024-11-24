public class Book {
    private String title;
    private String author;
    private String isbn;
    private int cur_num;
    private String pos;

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

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

    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCur_num() {
        return cur_num;
    }

    public void setCur_num(int cur_num) {
        this.cur_num = cur_num;
    }

    public Book(String title, String author, String isbn, int cur_num,String pos) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.cur_num = cur_num;
        this.pos=pos;
    }

    public Book(Book book,int num) {
        this.title = book.title;
        this.author = book.author;
        this.isbn = book.isbn;
        this.cur_num = num;
        this.pos=book.pos;
    }

    void decreaseBook(int num){
        this.cur_num-=num;
    }
}
