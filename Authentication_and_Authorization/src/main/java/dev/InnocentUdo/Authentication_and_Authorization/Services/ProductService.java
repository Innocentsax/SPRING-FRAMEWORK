package dev.InnocentUdo.Authentication_and_Authorization.Services;

import dev.InnocentUdo.Authentication_and_Authorization.DTO.Product;
import dev.InnocentUdo.Authentication_and_Authorization.Entities.UserInfo;
import dev.InnocentUdo.Authentication_and_Authorization.Repository.UserInfoRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class ProductService {
    List<Product> productList = null;

    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public ProductService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    @PostConstruct
    public void LoadProductsFromDB(){
        productList = IntStream.range(1, 100).mapToObj(i ->Product.builder()
                .productId(i).name("product " + i).quantity(new Random().nextInt(10))
                .price(new Random().nextInt(5000)).build()).collect(Collectors.toList());
    }

    public List<Product> getProducts(){
        return productList;
    }

    public Product getProduct(int id){
        return productList.stream().filter(product -> product.getProductId() == id)
                .findAny().orElseThrow(() -> new RuntimeException("product " + id + " not found"));
    }

    public String addUser(UserInfo userInfo){
        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);
        return "user added to system";
    }
}
