package com.parts.userrestapi.service;

import com.parts.userrestapi.domain.UserDTO;
import com.parts.userrestapi.entity.UserEntity;

import java.util.List;


public interface UserService {

    void addUser(UserDTO user);

    List<UserDTO> findAllUsers();

    UserDTO findUserById(Long id);

    void updateUser(UserDTO userBeforeUpdate);

    UserEntity DTOToEntityMapper(UserDTO userDTO);
}
