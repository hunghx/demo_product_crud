package ra.model.serviceimpl;

import ra.model.dao.IProductDao;
import ra.model.daoimpl.ProductDaoImpl;
import ra.model.entity.Product;
import ra.model.service.IProductService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductServiceImpl implements IProductService {
    private static IProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public List<Product> findAllSortByPrice() {
        return productDao.findAll().stream()
                .sorted(Comparator.comparingDouble(Product::getPrice))
                .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public void create(Product p) {
        productDao.create(p);
    }

    @Override
    public void update(Product p) {
        productDao.update(p);
    }

    @Override
    public void deleteById(Long id) {
        productDao.deleteById(id);
    }

    @Override
    public Long getNewId() {
        Long idMax = 0L;
        for (Product p: productDao.findAll()) {
            if(idMax<p.getProductId()){
                idMax = p.getProductId();
            }
        }
        return idMax+1;
    }
}
