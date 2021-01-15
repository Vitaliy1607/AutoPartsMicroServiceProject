package com.parts.partsrestapi.service.impl;

import com.dto.dtomanager.domain.PartsDTO;
import com.dto.dtomanager.domain.UserDTO;
import com.parts.partsrestapi.config.MessageConfig;
import com.parts.partsrestapi.entity.PartEntity;
import com.parts.partsrestapi.feign.UserFeignClient;
import com.parts.partsrestapi.repository.PartRepository;
import com.parts.partsrestapi.service.PartService;
import com.parts.partsrestapi.utils.ObjectMapperUtils;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private ObjectMapperUtils modelmapper;

    @Autowired
    private PartRepository partRepository;

    @Autowired
    private UserFeignClient userFeignClient;

    @Override
    @RabbitListener(queues = MessageConfig.QUEUENAME)
    public void addPart(PartsDTO part) {
        PartEntity partsEntity = modelmapper.map(part, PartEntity.class);
        Long userId = partsEntity.getUserId();
        if (userFeignClient.findUserById(userId) != null){
            UserDTO userDTO = userFeignClient.findUserById(userId);
            part.setUserDTO(userDTO);
        }
        System.out.println("message received from queue " + part);
        partRepository.save(partsEntity);

    }

    @Override
    public List<PartsDTO> findAllParts() {
           return modelmapper.mapAll(partRepository.findAll(), PartsDTO.class);
    }

    @Override
    public PartsDTO findPartById(Long id) {
        boolean existById = partRepository.existsById(id);

        if (existById){
            PartEntity partsEntity = partRepository.findById(id).get();
            return modelmapper.map(partsEntity, PartsDTO.class);
        }
        return null;
    }

    @Override
    public void deletePart(Long id) {

    }
}
