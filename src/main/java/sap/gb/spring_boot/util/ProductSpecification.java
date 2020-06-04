package sap.gb.spring_boot.util;

import org.springframework.data.jpa.domain.Specification;
import sap.gb.spring_boot.model.Product;

public class ProductSpecification {
    public static Specification<Product> trueLiteral() {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isTrue(criteriaBuilder.literal(true)));

    }

    public static Specification<Product> priceGreaterThan(Integer min) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), min));

    }

    public static Specification<Product> priceLessThan(Integer max) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), max));

    }

    public static Specification<Product> nameLike(String partOfName) {
        return ((root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%"+partOfName+"%"));

    }
}
