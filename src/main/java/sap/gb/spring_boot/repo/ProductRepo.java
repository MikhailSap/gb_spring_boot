package sap.gb.spring_boot.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import sap.gb.spring_boot.model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {
   // Page<Product> findAll(Specification<Product> specification, Pageable pageable);
//    Page<Product> findByPriceLessThan(Integer max, Pageable pageable);
//    Page<Product> findByPriceGreaterThan(Integer min, Pageable pageable);
//    Page<Product> findByPriceBetween(Integer min, Integer max, Pageable pageable);
//
//    Page<Product> findByNameLike(String partOfName, Pageable pageable);
}
