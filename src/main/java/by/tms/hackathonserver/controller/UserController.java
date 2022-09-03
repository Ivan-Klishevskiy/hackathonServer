package by.tms.hackathonserver.controller;

import by.tms.hackathonserver.dto.response.LoginDto;
import by.tms.hackathonserver.model.User;
import by.tms.hackathonserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginDto user){
        return new ResponseEntity<>(userService.getUser(user.getEmail(), user.getPassword()), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }


}
