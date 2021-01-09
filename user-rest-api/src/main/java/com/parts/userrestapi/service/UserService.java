package com.parts.userrestapi.service;

import com.parts.userrestapi.domain.UserDTO;
import com.parts.userrestapi.entity.UserEntity;
import javassist.NotFoundException;

import java.util.List;


public interface UserService {

    void addUser(UserDTO user);

    List<UserDTO> findAllUsers();

    List<UserDTO> findActiveUsers();

    List<UserDTO> findDeletedUsers();

    UserDTO findUserById(Long id);

    UserEntity updateUser(UserDTO userDTO, Long id) throws NoSuchFieldException;

    void deleteUser(Long id) throws NotFoundException;
}
