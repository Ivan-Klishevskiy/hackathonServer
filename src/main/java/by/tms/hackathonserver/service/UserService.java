package by.tms.hackathonserver.service;

import by.tms.hackathonserver.dto.response.ProductResponse;
import by.tms.hackathonserver.dto.response.UserDto;
import by.tms.hackathonserver.model.Product;
import by.tms.hackathonserver.model.User;
import by.tms.hackathonserver.model.UserStatus;
import by.tms.hackathonserver.repository.ProductRepository;
import by.tms.hackathonserver.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper mapper;

    public UserDto getUser(String email, String password) {
        Optional<User> tempUser = userRepository.findByEmailAndPassword(email, password);
        if (tempUser.isPresent()) {
            User foundUser = tempUser.get();
            List<Product> userProducts = productRepository
                    .findAllByCreatorUsername(foundUser.getUsername()).get();
            UserDto userDto = mapper.map(foundUser, UserDto.class);
            userDto.setProducts(userProducts);
            return userDto;
        } else {
            throw new RuntimeException("User not found");
        }
    }

    public User save(User user) {
        Optional<User> dataUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));

        if (dataUser.isPresent()) {
            throw new RuntimeException("User already exist");
        }
        return userRepository.save(user);
    }

    public void delete(String username) {
        Optional<User> dataUser = Optional.ofNullable(userRepository.findByUsername(username));

        if (dataUser.isPresent()) {
            userRepository.delete(dataUser.get());
        } else {
            throw new RuntimeException("user not found");
        }
    }
}
