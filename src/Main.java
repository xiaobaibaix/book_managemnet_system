
public class Main {
    public static void main(String[] args) {
        Student stu=new Student("22070601012","华子","电子信息科学与技术");
        Library lib=new Library("图书馆");

        lib.print_books();
        stu.print_books();

        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"西游记");
        stu.borrowBook(lib,"红楼梦");
        stu.borrowBook(lib,"西游记");

        stu.returnBook(lib,"西游记");

        lib.print_books();
        stu.print_books();

        stu.returnBook(lib,"红楼梦");
        stu.returnBook(lib,"西游记");
        stu.returnBook(lib,"西游记");
        stu.returnBook(lib,"西游记");

        lib.print_books();
        stu.print_books();
    }

}