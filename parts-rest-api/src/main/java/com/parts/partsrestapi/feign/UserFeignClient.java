package com.parts.partsrestapi.feign;

import com.parts.partsrestapi.domain.UserDTO;
import com.parts.partsrestapi.utils.Constants.ConstantsUtil;
import feign.Headers;
import org.apache.catalina.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Headers("Content-Type: application/json")
@FeignClient(name = "user-rest-api", url = ConstantsUtil.USER_API_URL)
public interface UserFeignClient {

    @PostMapping(value = "/save")
    ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO);

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();

    @DeleteMapping("/{userId}")
    ResponseEntity<?> deleteUser(@PathVariable("userId") Long id);

    @GetMapping("/deletedUsers")
    ResponseEntity<List<UserDTO>> getDeletedUsers();





}
