public class Library {
    private String name;

    private Book []books=new Book[100];
    int cur_book_kind_num;


    public Book[] getBooks() {
        return books;
    }

    public Library(String name) {
        this.name = name;
    }

    boolean add_book(String title,String author,String isbn){
        if(cur_book_kind_num>=100)return false;
        int ret=find_book(title);

        if(ret<0){
            books[cur_book_kind_num++]=new Book(title,author,isbn,1);
        }else{
            books[ret].setCur_num(books[ret].getCur_num()+1);
        }
        return true;
    }

    int find_book(String name){
        for(int i=0;i<cur_book_kind_num;i++){
            if(books[i].getTitle().equals(name))return i;
        }
        return -1;
    }

    void print_books(){
        for(int i=0;i<cur_book_kind_num;i++){
            System.out.println(books[i].getTitle()+" "+books[i].getAuthor()+" "+books[i].getIsbn()+" "+books[i].getCur_num());
        }
    }
}
