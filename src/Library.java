import java.util.HashMap;
import java.util.Map;

public class Library {
    private String name;

    private HashMap<String,Book> books;

    Library(String name){
        this.name=name;
        this.books= new HashMap<String, Book>();
        File.loadBooks("./lib/book_info.txt",this.books);
    }

    void changeBook(){
        File.writeBooks("./lib/book_info.txt",books);
    }

    Book getBook(String title){
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                return entry.getValue();
            }
        }
        return null;
    }

    boolean add_book(String title,String author,String isbn){
        if(!find_book_isbn(isbn)){
            books.put(isbn,new Book(title,author,isbn,1,"//"));
        }else{
            books.get(isbn).setCur_num(books.get(isbn).getCur_num()+1);
        }
        return true;
    }
    boolean add_book(Book book){
        if(!find_book_isbn(book.getIsbn())){
            System.out.println("图书馆还书失败!!!");
            return false;
        }else{
            books.get(book.getIsbn()).setCur_num(books.get(book.getIsbn()).getCur_num()+1);
        }
        return true;
    }
    boolean find_book_isbn(String isbn){
        return books.containsKey(isbn);
    }

    boolean find_book_title(String title)
    {
        // 这里需要遍历books来查找匹配标题的书籍
        for (Map.Entry<String, Book> entry : books.entrySet()) {
            if (entry.getValue().getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    void print_books(){
        System.out.println("\n——————————————————————————————————————————————————————————————————————————————————————");
        System.out.format("| %-20s %-15s %-15s %-10s %-10s%n", "书名", "作者", "位置", "数量", "书号");

        // 遍历books集合并打印每个Book对象的信息
        for (Book book : books.values()) {
            if(book==null)break;
            System.out.format("| %-20s %-15s %-15s %-10d %-10s%n",
                    book.getTitle() == null ? "" : book.getTitle(),
                    book.getAuthor() == null ? "" : book.getAuthor(),
                    book.getPos() == null ? "" : book.getPos(),
                    book.getCur_num(),
                    book.getIsbn() == null ? "" : book.getIsbn());
        }
        System.out.println("——————————————————————————————————————————————————————————————————————————————————————");

    }

}
