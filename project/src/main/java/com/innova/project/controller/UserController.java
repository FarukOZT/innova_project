package com.innova.project.controller;

import com.innova.project.dto.LoginDTO;
import com.innova.project.dto.UserDTO;
import com.innova.project.model.User;
import com.innova.project.repository.UserRepository;
import com.innova.project.services.UserService;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
@Slf4j
@Api(value = "User")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> userList(){
        log.info("[GetAllUsers] 'Get Users' request was received.");
        return ResponseEntity.ok(userService.listAllUser());
    }

    @GetMapping("/{tckn}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable("tckn") Long tckn){
        return ResponseEntity.ok(userService.getUser(tckn));
    }

    @PostMapping("/add")
    ResponseEntity<UserDTO> addUser(@Valid @RequestBody UserDTO user){
        log.info("[PostUser] 'Post user' request was received.");
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PostMapping("/login")
    boolean loginUser(@RequestBody LoginDTO loginDTO) {
        return userService.loginUser(loginDTO);
    }
    @PutMapping("/update")
    public String updateUser(@RequestBody UserDTO user){
        return userService.updateUser(user);
    }


    @DeleteMapping("/delete/{tckn}")
    public void userDeleteById(@PathVariable Long tckn){
        log.info("[DeleteUser] 'Delete user' request was received.");
        userService.deleteUserById(tckn);
    }
}
