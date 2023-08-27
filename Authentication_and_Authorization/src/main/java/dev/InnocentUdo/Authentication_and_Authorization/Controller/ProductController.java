package dev.InnocentUdo.Authentication_and_Authorization.Controller;

import dev.InnocentUdo.Authentication_and_Authorization.DTO.Product;
import dev.InnocentUdo.Authentication_and_Authorization.Entities.UserInfo;
import dev.InnocentUdo.Authentication_and_Authorization.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@CrossOrigin("*")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/welcome")
    public String welcome(){
        return "Welcome Tech Bro, this endpoint is not secure";
    }
    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo){
        return service.addUser(userInfo);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('ROLE_AMIN')")
    public List<Product> getAllTheProducts(){
        return service.getProducts();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Product getProductById(@PathVariable int id){
        return service.getProduct(id);
    }
}
