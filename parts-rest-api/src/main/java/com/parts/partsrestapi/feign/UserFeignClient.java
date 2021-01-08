package com.parts.partsrestapi.feign;

import com.parts.partsrestapi.domain.UserDTO;
import com.parts.partsrestapi.utils.Constants.ConstantsUtil;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Headers("Content-Type: application/json")
@FeignClient(name = "user-rest-api", url = ConstantsUtil.USER_API_URL)
public interface UserFeignClient {

    @PostMapping("/save")
    ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO);

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers();


}
