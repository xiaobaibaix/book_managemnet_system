import java.io.*;
import java.util.HashMap;

public class File {
    static boolean loadBooks(String filepath,HashMap<String,Book> books){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filepath));
            String line;

            while ((line = reader.readLine()) != null) {
                String []book_info=line.split("-");
                if(book_info.length<4)continue;
                books.put(book_info[1],new Book(book_info[0],book_info[2],book_info[1],Integer.parseInt(book_info[3]),book_info[4]));
            }
            //System.out.println(line);
            reader.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    static boolean writeBooks(String filepath,HashMap<String,Book> books){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath));

            for(Book book:books.values()){
                String book_info=book.getTitle()+"-"+
                        book.getIsbn()+"-"+
                        book.getAuthor()+"-"+
                        String.valueOf(book.getCur_num())+"-"+
                        book.getPos();
                writer.write(book_info);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    static boolean writeInfoAppend(String filepath,String info){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filepath,true));
            writer.newLine();
            writer.write(info);
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

}
