package sap.gb.spring_boot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sap.gb.spring_boot.service.ProductService;
import sap.gb.spring_boot.model.Product;


import javax.validation.Valid;
import java.util.Optional;


@Controller
public class ProductController {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("new")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product";

    }

    @PostMapping("product")
    public String addProduct(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "product";
        }
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("products")
    public String filter(@RequestParam(value = "minPrice", required = false) Integer min,
                         @RequestParam(value = "maxPrice", required = false) Integer max,
                         @RequestParam(value = "partOfName", required = false) String partOfName,
                         @RequestParam(value = "pageNumber") Optional<Integer> pageNumber,
                         @RequestParam(value = "pageSize") Optional<Integer> pageSize,
                         Model model) {
        model.addAttribute("productsPage",
                productService.filter(
                        min, max,
                        partOfName,
                        PageRequest.of(pageNumber.orElse(1) -1, pageSize.orElse(5)))
        );
        model.addAttribute("min", min);
        model.addAttribute("max", max);
        model.addAttribute("partOfName", partOfName);
        return "products";
    }

    @GetMapping("edit")
    public String editProduct(@RequestParam(name = "id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product";
    }

    @DeleteMapping("delete")
    public String deleteProduct(@RequestParam(name = "id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products";
    }
}
