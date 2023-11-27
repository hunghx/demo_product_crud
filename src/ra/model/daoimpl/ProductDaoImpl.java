package ra.model.daoimpl;

import ra.model.dao.IProductDao;
import ra.model.entity.Product;
import ra.model.util.IOFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductDaoImpl implements IProductDao {
    private static List<Product> productList ;

    public ProductDaoImpl() {
        productList = IOFile.getListFromFile(IOFile.PRODUCT_PATH); // đọc từ file vào
//        productList = new ArrayList<>();
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(Long id) {
        for (Product p: productList) {
            if(Objects.equals(p.getProductId(), id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public void create(Product product) {
        productList.add(product);
        // thêm mới xong thì phải lưu vào file
        IOFile.writeToFile(IOFile.PRODUCT_PATH,productList);
    }

    @Override
    public void update(Product product) {
        productList.set(productList.indexOf(findById(product.getProductId())), product);
        // sửa xong thì phải lưu vào file
        IOFile.writeToFile(IOFile.PRODUCT_PATH,productList);
    }

    @Override
    public void deleteById(Long id) {
        productList.remove(findById(id));
        IOFile.writeToFile(IOFile.PRODUCT_PATH,productList);
    }
}
