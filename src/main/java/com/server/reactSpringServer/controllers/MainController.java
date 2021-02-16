package com.server.reactSpringServer.controllers;

import com.server.reactSpringServer.dao.UserDAO;
import com.server.reactSpringServer.models.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//package com.server.reactSpringServer.controllers;
//
//import com.server.reactSpringServer.dao.UserDAO;
//import com.server.reactSpringServer.models.Car;
//import com.server.reactSpringServer.models.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@RestController
//@CrossOrigin("http://localhost:3000")
//public class MainController {
////    @Autowired
//    private UserDAO userDAO;
//
//    @Autowired
//    public MainController(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }
//
//    @GetMapping("/")
//    public void addUser ()
//    {
//        User user = new User("Petia");
//        user.setSkills(Arrays.asList("blue","green"));
//        List<Car> cars = new ArrayList<>();
//        cars.add(new Car("porsche2"));
//        cars.add(new Car("bmw2"));
//        user.setCars(cars);
//       //userDAO.addUser(user);
//        userDAO.save(user);
//
//    }
//
//    @GetMapping("/users")
//    public List<User> getUsers ()
//    {
//      // return userDAO.getUsers();
//       return userDAO.findAll();
//    }
//}

@RestController
@AllArgsConstructor
public class MainController {

    private UserDAO userDAO;

//    public MainController(UserDAO userDAO) {
//        this.userDAO = userDAO;
//    }

    @PostMapping("/saveUser")
    public ResponseEntity<List<User>> saveUser(@RequestBody User user) {
        userDAO.save(user);
        System.out.println(user);
        return new ResponseEntity<List<User>>(userDAO.findAll(), HttpStatus.OK);

    }

    @PostMapping("/save")
    public void saveUser(@RequestParam String name, @RequestParam String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userDAO.save(user);
    }

    @GetMapping("/")
    public String hello() {
        return "hello";
    }

    @GetMapping("/users")
    public List<User> all() {
        return userDAO.findAll();
    }

    private PasswordEncoder passwordEncoder;
    @PostMapping("/registration")
    public void reg(@RequestParam String username,
                    @RequestParam String password) {
        User user = new User();
        user.setUserName(username);
        String encode = passwordEncoder.encode(password);
        user.setPassword(encode);
        userDAO.save(user);
    }
}