package ra.run;

import ra.model.entity.Product;
import ra.model.service.IProductService;
import ra.model.serviceimpl.ProductServiceImpl;
import ra.model.util.InputMethods;

import java.util.List;

public class ProductManagement {
    private static final IProductService productService = new ProductServiceImpl();
    public static void main(String[] args) {
        while(true){
            System.out.println("======================Product Management======================");
            System.out.println("1. Hiển thị toàn bộ danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm");
            System.out.println("3. Cập nhật thông tin sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Tìm kiếm theo tên");
            System.out.println("0. Thoát");
            System.out.println("------Nhập lựa chọn của bạn --------");
            byte choice = InputMethods.getByte();
            switch (choice){
                case 1:
                    // chức năng hiển thị
                    displayListProduct(productService.findAllSortByPrice());
                    break;
                case 2:
                    // thêm mới
                    createNewProduct();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập không hợp lệ , thử lại !!!");
            }
        }
    }
    // chức năng hiển thị
    public static void displayListProduct(List<Product> list){
        if (list.isEmpty()){
            System.err.println("Danh sách không có phần tử nào tìm thấy");
        }else {
            list.forEach(System.out::println);
        }
    }
    // chức năng them mới
    public static void createNewProduct(){
        // bắt người dùng nhập số lượng muốn thêm
        System.out.println("Hãy nhập số lượng sản phẩm muốn thêm");
        int count = InputMethods.getInteger();
        if(count<=0){
            System.err.println("vui lòng nhập số > 0");
            return;
        }
        for (int i = 1; i <= count; i++) {
            System.out.println("Thêm sản phẩm thứ "+i);
            Long newId = productService.getNewId();
            System.out.println("Mã sản phẩm : "+newId);
            // nhập  các thông tin cho sản phẩm ;
            System.out.println("Nhập tên cho sp");
            String newName = InputMethods.getString();
            System.out.println("Nhập mô tả");
            String newDescription = InputMethods.getString();
            System.out.println("Nhập giá bán ");
            double priceSale = InputMethods.getDouble();
            System.out.println("Nhập số lượng cần thêm");
            int stockNew = InputMethods.getInteger();
            System.out.println("Nhập trạng thái");
            boolean productStatus = InputMethods.getBoolean();

            // tạo ra đối tượng cần thêm mới
            Product newProduct = new Product(newId,newName,newDescription,priceSale,stockNew,productStatus);
            // tiến hành gọi service để thêm mơi
            productService.create(newProduct);
        }
        System.out.println("Thêm mới "+count+" sản phẩm thành công");
    }
}