public class Student {
    private String name;
    private String userId;
    private Book bor_books[]=new Book[10];
    private int cur_num_book=0;//种类

    private int find_book(String name){
        for(int i=0;i<cur_num_book;i++){
            if(bor_books[i].getTitle().equals(name))return i;
        }
        return -1;
    }

    public Student(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    boolean borrowBook(Library library,String name){
        int ret=library.find_book(name);
        if(ret<0){
            System.out.println("借书失败"+"图书馆没有此书:"+name);
            return false;
        }

        Book book=library.getBooks()[ret];
        if(book.getCur_num()<=0){
            System.out.println("借书失败"+"书已借完:"+name);
            return false;
        }

        book.setCur_num(book.getCur_num()-1);
        ret=find_book(name);
        if(ret<0)
            bor_books[cur_num_book++]=new Book(book.getTitle(),book.getAuthor(),book.getIsbn(),1);
        else
            bor_books[ret].setCur_num(bor_books[ret].getCur_num() + 1);
        return true;
    }

    boolean returnBook(Library library,String name){
        int self_ret=find_book(name);
        if(self_ret<0){
            System.out.println("还书失败，"+this.name+"没有此书:"+name);
            return false;
        }

        int lib_ret=library.find_book(name);
        if(lib_ret<0){
            System.out.println("还书失败，"+"图书馆没有此书"+name);
            return false;
        }

        Book lib_book=library.getBooks()[lib_ret];
        lib_book.setCur_num(lib_book.getCur_num()+1);

        bor_books[self_ret].setCur_num(bor_books[self_ret].getCur_num()-1);

        if(bor_books[self_ret].getCur_num()<=0){
            bor_books[self_ret]=null;
            for(int i=0;i<cur_num_book;i++){
                if(null==bor_books[i]){
                    for(int j=i;j<cur_num_book-i;j++) {
                        if (j + 1 >= cur_num_book)
                            bor_books[j + 1] = null;
                        bor_books[j]=bor_books[j+1];
                    }
                }
            }
            cur_num_book--;
        }
        return true;
    }

    void print_books(){
        for(int i=0;i<cur_num_book;i++){
            System.out.println(bor_books[i].getTitle()+" "+bor_books[i].getAuthor()+" "+bor_books[i].getIsbn()+" "+bor_books[i].getCur_num());
        }
    }
}
