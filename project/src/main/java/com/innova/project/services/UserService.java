package com.innova.project.services;

import com.innova.project.dto.LoginDTO;
import com.innova.project.dto.UserDTO;
import com.innova.project.model.User;
import com.innova.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public List<User> listAllUser() {

        return userRepository.findAll();
    }
    public Optional<User> getUser(Long tckn){
        return Optional.of(userRepository.getByTckn(tckn));
    }

    public String addUser(UserDTO userDTO) {
        User userr = new User();
        UUID id = UUID.randomUUID();
        userr.setId(id);
        userr.setTckn(userDTO.getTckn());
        userr.setPassword(userDTO.getPassword());
        userr.setName(userDTO.getName());
        userr.setSurName(userDTO.getSurName());
        userr.setPhone(userDTO.getPhone());
        userr.setSalary(userDTO.getSalary());
        userr.setCreditNote(userDTO.getCreditNote());
        userr.setStatus(userDTO.getStatus());
        userRepository.save(userr);
        return "success";
    }

    public boolean loginUser(LoginDTO loginDTO){
        User userr =userRepository.getByTcknAndPassword(loginDTO.getTckn(),loginDTO.getPassword());
        if(userr != null){
            return true;
        } else {
            return false;
        }
    }

    public String updateUser(UserDTO userDTO) {
        User userr = new User();
        userr.setName(userDTO.getName());
        userRepository.save(userr);
        return "user updated";
    }

    public String deleteUserById(Long tckn) {
        userRepository.deleteById(tckn);
        return "user deleted";
    }
}
