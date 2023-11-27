package ra.model.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
    public static String PRODUCT_PATH = "C:\\Users\\hung1\\OneDrive\\Desktop\\ProductCrud\\src\\ra\\model\\data\\product.txt";

    public static <T> List<T> getListFromFile(String path) {
        File file = new File(path); // File là lớp đại diện cho 1 tệp , 1 thư mục trong máy tính
        if (!file.exists()) { //kiểm tra sự tồn tại
            return new ArrayList<>();
        }
        List<T> list = new ArrayList<>() ;
        try {
            FileInputStream fis = new FileInputStream(file); // cho phép đọc dữ liệu dạng nhị phân
            ObjectInputStream ois = new ObjectInputStream(fis); // hỗ trợ đọc file object
            list = (List<T>) ois.readObject();

            // đóng stream
            ois.close();
        } catch (FileNotFoundException e) {
            System.err.println("không tìm thấy file");
        } catch (IOException e) {
            System.err.println("Lỗi không đọc được file");
        } catch (ClassNotFoundException e) {
            System.err.println("không thể ép về class");
        }
        return list;
    }

    public static <T> void  writeToFile(String path, List<T> list){
        File file =  new File(path);
        try{
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos =  new ObjectOutputStream(fos);
            oos.writeObject(list); // ghi ra file
            // đóng stream
            oos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm tháy file");
        } catch (IOException e) {
            System.err.println("Lỗi ghi file");
        }
    }
}
