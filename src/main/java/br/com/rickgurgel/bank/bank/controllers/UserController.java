package br.com.rickgurgel.bank.bank.controllers;

import br.com.rickgurgel.bank.bank.entities.User;
import br.com.rickgurgel.bank.bank.repositories.UserRepository;
import br.com.rickgurgel.bank.bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    private UserRepository userRepository;

    @GetMapping("/find/{username}")
    public User getUserById(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    @GetMapping("/all")
    public ResponseEntity getAllUsers() {
        List<User> users = userRepository.findAll().stream().map(User::new).toList();
        return ResponseEntity.ok(users);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.delete(Long.valueOf(String.valueOf(id)));
        System.out.println("Deleted user with id " + id);
    }

    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.insert(user);
        System.out.println("Created user with id " + user.getId());
    }

    @PutMapping("/update")
    public void updateUser(@RequestBody User user) {
        userService.update(user);
    }

}

