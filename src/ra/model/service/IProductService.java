package ra.model.service;

import ra.model.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    List<Product> findAllSortByPrice();
    Product findById(Long id);
    void create(Product p);
    void update(Product p);
    void deleteById(Long id);
    Long getNewId();

}
