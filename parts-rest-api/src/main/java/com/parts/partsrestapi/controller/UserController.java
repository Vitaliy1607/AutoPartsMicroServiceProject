package com.parts.partsrestapi.controller;


import com.dto.dtomanager.domain.UserDTO;
import com.parts.partsrestapi.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserFeignClient userFeignClient;

    @PostMapping(name = "/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return userFeignClient.create(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return userFeignClient.getAllUsers();
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable("userId") Long id){
        return userFeignClient.deleteUser(id);
    }

    @GetMapping("/chrome")
    ResponseEntity<List<UserDTO>> getDeletedUsers(){
        return userFeignClient.getDeletedUsers();
    }

}
