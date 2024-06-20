package br.com.rickgurgel.bank.bank.services;

import br.com.rickgurgel.bank.bank.entities.User;
import br.com.rickgurgel.bank.bank.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User insert(User user) {
        return userRepository.save(user);
    }

    public User update(User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        return userRepository.save(newUser);
    }

    public User delete(Long id) {
        Optional<User> user = userRepository.findById(id);
        userRepository.deleteById(id);
        System.out.println("User: " + user.toString() + "deleted...");
        return null;
    }

    public User findById(Long id) {
        return userRepository.findById(Long.valueOf(String.valueOf(id))).get();
    }

    public User findAll(){
        return (User) userRepository.findAll();
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
