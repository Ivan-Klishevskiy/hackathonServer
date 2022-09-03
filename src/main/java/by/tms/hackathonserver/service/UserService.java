package by.tms.hackathonserver.service;

import by.tms.hackathonserver.model.User;
import by.tms.hackathonserver.model.UserStatus;
import by.tms.hackathonserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User getUser(String email, String password){
        Optional<User> tempUser = userRepository.findByEmailAndPassword(email, password);
        if(tempUser.isPresent()){
            return tempUser.get();
        }else{
            throw new RuntimeException("User not found");
        }
    }

    public User save(User user) {
        Optional<User> dataUser = Optional.ofNullable(userRepository.findByUsername(user.getUsername()));

        if(dataUser.isPresent()){
            throw new RuntimeException("User already exist");
        }
        return userRepository.save(user);
    }

    public void delete(String username){
        Optional<User> dataUser = Optional.ofNullable(userRepository.findByUsername(username));

        if(dataUser.isPresent()){
            userRepository.delete(dataUser.get());
        }else {
            throw new RuntimeException("user not found");
        }
    }
}
