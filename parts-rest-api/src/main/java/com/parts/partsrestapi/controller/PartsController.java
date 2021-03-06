package com.parts.partsrestapi.controller;

import com.dto.dtomanager.domain.PartsDTO;
import com.parts.partsrestapi.feign.UserFeignClient;
import com.parts.partsrestapi.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("parts")
public class PartsController {

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private PartService partService;

    @PostMapping()
    public ResponseEntity<?> addPart(@RequestBody PartsDTO partsDTO){
        partService.addPart(partsDTO);
        if (partsDTO.getUserDTO() == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(partsDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PartsDTO>> getAllParts(){
        List<PartsDTO> partsDTO = partService.findAllParts();
        List<PartsDTO> updateList = new ArrayList<>(30);

       partsDTO.forEach(part -> {
           part.setUserDTO(userFeignClient.findUserById(part.getUserId()));
           updateList.add(part);
       });
        return new ResponseEntity<>(updateList, HttpStatus.OK);
    }

    @GetMapping("/{partId}")
    public ResponseEntity<?> getPart(@PathVariable("partId") Long id){
        PartsDTO partsDTO = partService.findPartById(id);
        if (partsDTO == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        partsDTO.setUserDTO(userFeignClient.findUserById(partsDTO.getUserId()));
        if (partsDTO.getUserDTO() == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(partsDTO, HttpStatus.OK);
    }
}
