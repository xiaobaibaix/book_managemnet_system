import java.text.SimpleDateFormat;
import java.util.Date;

public class Log {
    static void log(Student stu,Book book,boolean flag){
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String strDate = dateFormat.format(now);
        String info=stu.getName()+" "+stu.getUserId()+" "+stu.getMajor()+" "+(flag?"借书":"还书")+" 《"+book.getTitle()+"》 :"+book.getIsbn();
        info=strDate+" >"+info;
        File.writeInfoAppend("./lib/logs.txt",info);
        System.out.println("Log>>>   "+info);
    }
}
