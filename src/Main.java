
public class Main {
    public static void main(String[] args) {

        Library library=new Library("贵州师范学院图书管");

        library.add_book("西游记","吴承恩","12345");
        library.add_book("西游记","吴承恩","12345");
        library.add_book("西游记","吴承恩","12345");
        library.add_book("水浒传","施耐庵","12346");
        library.add_book("红楼梦","曹雪芹","12346");
        library.add_book("红楼梦","曹雪芹","12346");
        library.add_book("三国演义","罗贯中","12347");
        library.add_book("红楼梦","罗贯中","12347");
        library.add_book("红楼梦","罗贯中","12347");
        library.add_book("三体","刘慈欣","12348");
        library.add_book("三体","刘慈欣","12348");
        System.out.println("library all books:");
        library.print_books();

        Student xiaohua=new Student("22070601012","xiaohua");
        //借书
        xiaohua.borrowBook(library,"水浒传");
        xiaohua.borrowBook(library,"西游记");

        System.out.println();
        System.out.println("Student all books:");
        xiaohua.print_books();

        xiaohua.borrowBook(library,"西游记");
        xiaohua.borrowBook(library,"西游记");
        xiaohua.borrowBook(library,"西游记");

        System.out.println();
        System.out.println("Student all books:");
        xiaohua.print_books();

        System.out.println();
        System.out.println("library all books:");
        library.print_books();

        //还书
        xiaohua.returnBook(library,"水浒传");
        xiaohua.returnBook(library,"水浒传");
        xiaohua.returnBook(library,"水浒传");

        System.out.println();
        System.out.println("Student all books:");
        xiaohua.print_books();

        System.out.println();
        System.out.println("library all books:");
        library.print_books();

        xiaohua.returnBook(library,"西游记");
        xiaohua.returnBook(library,"三体");

        System.out.println();
        System.out.println("Student all books:");
        xiaohua.print_books();

        System.out.println();
        System.out.println("library all books:");
        library.print_books();
    }

}