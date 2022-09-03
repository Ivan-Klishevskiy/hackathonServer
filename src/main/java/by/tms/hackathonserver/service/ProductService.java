package by.tms.hackathonserver.service;


import by.tms.hackathonserver.dto.response.ProductResponse;
import by.tms.hackathonserver.model.Product;
import by.tms.hackathonserver.model.User;
import by.tms.hackathonserver.repository.ProductRepository;
import by.tms.hackathonserver.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper mapper;


    public List<ProductResponse> getAll(){
        List<Product> allProducts = productRepository.findAll();
        List<ProductResponse> listProductResponse = new ArrayList<>();
        for (Product tempProduct : allProducts) {
            User tempUser = userRepository.findByUsername(tempProduct.getCreatorUsername());
            ProductResponse productResponse = mapper.map(tempProduct, ProductResponse.class);
            productResponse.setUser(tempUser);
            listProductResponse.add(productResponse);
        }
        return listProductResponse;
    }

    public List<ProductResponse> getProductStartWith(String line){
        line =line.substring(0, 1).toUpperCase() + line.substring(1).toLowerCase();
        List<Product> allProducts = productRepository.findByTitleStartingWith(line);
        List<ProductResponse> listProductResponse = new ArrayList<>();
        for (Product tempProduct : allProducts) {
            User tempUser = userRepository.findByUsername(tempProduct.getCreatorUsername());
            ProductResponse productResponse = mapper.map(tempProduct, ProductResponse.class);
            productResponse.setUser(tempUser);
            listProductResponse.add(productResponse);
        }
        return listProductResponse;
    }

    public Product save(Product product) {

        Optional<User> dataUser = Optional.ofNullable(userRepository.findByUsername(product.getCreatorUsername()));

        return productRepository.save(product);

    }

    public long delete(long productId) {
        Optional<Product> productById = productRepository.findById(productId);
        if (productById.isPresent()) {
            productRepository.delete(productById.get());
            return productId;
        } else {
            return 0;
        }
    }

    public List<Product> getAllProductByCategory(String category) {
        if (productRepository.findAllByCategory(category).isPresent()) {
            return productRepository.findAllByCategory(category).get();
        }
        throw new RuntimeException("list product empty");
    }

    public List<Product> getAllProductByCreatorName(String username) {
        if (productRepository.findAllByCreatorUsername(username).isPresent()) {
            return productRepository.findAllByCreatorUsername(username).get();
        }
        throw new RuntimeException("list product empty");
    }

    public Product getProductById(long productId) {
        if (productRepository.findById(productId).isPresent()) {
            return productRepository.findById(productId).get();
        }
        throw new RuntimeException("product id not found");
    }



//    public Post save(Post post, String username) {
//        log.info(String.format("Request Post %s save by %s", post.getDescription(), username));
//        User byUsername = userRepository.findByUsername(username)
//                .orElseThrow(() -> new RuntimeException(String.format("User %s not found", username)));
//        post.setCreatorUsername(byUsername.getUsername());
//        return postRepository.save(post);
//    }

}
