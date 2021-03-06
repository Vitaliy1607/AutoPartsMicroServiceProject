package com.parts.userrestapi.controller;


import com.dto.dtomanager.domain.PartsDTO;
import com.dto.dtomanager.domain.UserDTO;
import com.parts.userrestapi.config.MessageConfig;
import com.parts.userrestapi.repository.UserRepository;
import com.parts.userrestapi.service.UserService;
import javassist.NotFoundException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RabbitTemplate template;

    @PostMapping("/savePart")
    public String createPart(@RequestBody PartsDTO parts){
        template.convertAndSend(MessageConfig.EXCHANGE, MessageConfig.ROUTING_KEY,parts);
        System.out.println(parts.getPartName() + " : " + parts.getCondition());
        return "Success";
    }

    @PostMapping("/save")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserDTO user){
        System.out.println("User " + user.getFirstName() + " " +
                user.getLastName() + " " +
                user.getEmail() + " was created");

        userService.addUser(user);
        return new ResponseEntity<>(user ,HttpStatus.CREATED);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<UserDTO>> getAllUsers(){

        return new ResponseEntity<>(userService.findAllUsers(), HttpStatus.OK);
     }

    @GetMapping("/deletedUsers")
    public ResponseEntity<List<UserDTO>> getDeletedUsers(){

        return new ResponseEntity<>(userService.findDeletedUsers(), HttpStatus.OK);
    }

     @GetMapping("{userId}")
     public ResponseEntity<?> getUserById(@PathVariable("userId") Long id){
        UserDTO userDTO = userService.findUserById(id);
        if (userDTO == null){
            return null;
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
     }

     @PutMapping("update/{id}")
     public ResponseEntity<?> updateUser(
             @PathVariable("id") Long id,
             @RequestBody UserDTO userToUpdate) throws NoSuchFieldException {
         boolean isUserExist = userRepository.existsById(id);
         if (isUserExist){
             userToUpdate.setId(id);
             userService.updateUser(userToUpdate, id);
             return new ResponseEntity<>(userToUpdate, HttpStatus.OK);
         }
         return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
     }

     @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable("userId") Long id) throws NotFoundException {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
     }


}
