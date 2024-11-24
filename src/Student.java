public class Student {
    private String name;
    private String userId;
    private String major;
    private Book bor_books[]=new Book[10];
    private int cur_num_kind=0;

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private int find_book(String name){
        for(int i=0;i<cur_num_kind;i++){
            if(bor_books[i].getTitle().equals(name))return i;
        }
        return -1;
    }

    private int find_book(Book book){
        return find_book(book.getTitle());
    }

    public Student(String userId, String name,String major) {
        this.userId = userId;
        this.name = name;
        this.major=major;
    }

    boolean borrowBook(Library library,String name){
        Book book=library.getBook(name);
        if(book==null||library.getBook(name).getCur_num()==0||cur_num_kind>=10){
            System.out.format("借书失败!!!   《%s》\n",name);
            return false;
        }
        int ret =find_book(book);
        if (ret>=0) {
            bor_books[ret].setCur_num(bor_books[ret].getCur_num()+1);
        }else{
            bor_books[cur_num_kind++]=new Book(book,1);
        }
        book.decreaseBook(1);
        Log.log(this,book,true);
        library.changeBook();
        return true;
    }

    boolean returnBook(Library library,String name){
        int ret =find_book(name);
        if(ret>=0){
            library.add_book(bor_books[ret]);
            bor_books[ret].decreaseBook(1);
            Log.log(this,bor_books[ret],false);
            if(bor_books[ret].getCur_num()==0){
                bor_books[ret]=null;
                cur_num_kind--;
            }
        }else{
            System.out.format("还书失败!!!   《%s》\n",name);
            return false;
        }
        library.changeBook();
        return true;
    }
    void print_books(){
        System.out.println("\n——————————————————————————————————————————————————————————————————————————————————————");
        System.out.format("| %-20s %-15s %-15s %-10s %-10s%n", "书名", "作者", "位置", "数量", "书号");

        // 遍历books集合并打印每个Book对象的信息
        for (Book book : bor_books) {
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
