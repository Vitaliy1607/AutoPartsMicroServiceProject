package com.parts.partsrestapi.controller;

import com.parts.partsrestapi.domain.UserDTO;
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

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser(@RequestBody UserDTO userDTO){
        return userFeignClient.create(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return userFeignClient.getAllUsers();
    }


}
