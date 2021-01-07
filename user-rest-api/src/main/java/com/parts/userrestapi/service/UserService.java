package com.parts.userrestapi.service;

import com.parts.userrestapi.domain.UserDTO;
import com.parts.userrestapi.entity.UserEntity;

import java.util.List;


public interface UserService {

    void addUser(UserDTO user);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    UserEntity updateUser(UserDTO userDTO, Long id) throws NoSuchFieldException;

    UserEntity DTOToEntityMapper(UserDTO userDTO);
}
