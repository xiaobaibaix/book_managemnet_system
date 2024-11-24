import java.util.HashMap;
//西游记-ISN90001-吴承恩-5-12号书架3层
//红楼梦-ISN43211-曹雪芹-3-10号书架5层
//水浒传-ISN43200-施耐庵-4-12号书架1层
//三国演义-ISN43451-罗贯中-3-10号书架2层
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