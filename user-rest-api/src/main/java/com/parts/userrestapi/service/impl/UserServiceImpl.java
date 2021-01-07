package com.parts.userrestapi.service.impl;


import com.parts.userrestapi.domain.UserDTO;
import com.parts.userrestapi.entity.UserEntity;
import com.parts.userrestapi.repository.UserRepository;
import com.parts.userrestapi.service.UserService;
import com.parts.userrestapi.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMapperUtils modelMapper;

    @Override
    public void addUser(UserDTO user) {
        UserEntity userEntity = modelMapper.map(user, UserEntity.class);
            userRepository.save(userEntity);
    }

    @Override
    public List<UserDTO> findAllUsers() {
       return modelMapper.mapAll(userRepository.findAll(),UserDTO.class);
    }

    @Override
    public UserDTO findUserById(Long id) {
        boolean existById = userRepository.existsById(id);
        if (existById){
            UserEntity userEntity = userRepository.findById(id).get();
            return modelMapper.map(userEntity, UserDTO.class);
        }
    return null;
    }

    @Override
    public UserEntity updateUser(UserDTO userDTO, Long id) throws NoSuchFieldException {
        if (userRepository.findById(id).isPresent()){
            UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);
            return userRepository.save(userEntity);
        }else{
            throw new NoSuchFieldException("Not found");
        }
    }

    @Override
    public UserEntity DTOToEntityMapper(UserDTO userDTO) {
        return modelMapper.map(userDTO, UserEntity.class);
    }
}
