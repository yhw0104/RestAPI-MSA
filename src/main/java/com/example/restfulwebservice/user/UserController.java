package com.example.restfulwebservice.user;

import org.apache.coyote.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {
    private UserDaoService service;

    public UserController(UserDaoService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    // GET /users/1 ot /users/10
    @GetMapping("/users/{id}")
    public User retrieveUsers(@PathVariable int id) {
        User findUser = service.findOne(id);
        if (findUser == null) {
            throw new UserNotFoundException(String.format("ID[%s] is not found", id));
        }

        return findUser;

    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("location", String.valueOf(location));

        return ResponseEntity.created(location).build();
//        return ResponseEntity.created(location).body(savedUser);
//        return ResponseEntity.ok().headers(headers).body(savedUser);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        User user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException(String.format("ID[%s] not found", id));
        }
    }

    @PutMapping("/users/{id}")
    public User editUser(@PathVariable("id") int id, @RequestBody User user) {
        User editUser = service.editUser(id, user);

        return editUser;
    }
}
