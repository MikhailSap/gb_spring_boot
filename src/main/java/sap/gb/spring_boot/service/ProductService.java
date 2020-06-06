package sap.gb.spring_boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import sap.gb.spring_boot.model.Product;


public interface ProductService {

    void save(Product product);

    Product getProductById(Long id);

    Page<Product> filter(Integer min, Integer max, String partOfName, Pageable pageable);

    void deleteProductById(Long id);
}
