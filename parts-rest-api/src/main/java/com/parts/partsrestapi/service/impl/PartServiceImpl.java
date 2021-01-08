package com.parts.partsrestapi.service.impl;

import com.parts.partsrestapi.domain.PartsDTO;
import com.parts.partsrestapi.entity.PartEntity;
import com.parts.partsrestapi.repository.PartRepository;
import com.parts.partsrestapi.service.PartService;
import com.parts.partsrestapi.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    @Autowired
    private ObjectMapperUtils modelmapper;

    @Autowired
    private PartRepository partRepository;

    @Override
    public void addPart(PartsDTO part) {
        PartEntity partsEntity = modelmapper.map(part, PartEntity.class);
        partRepository.save(partsEntity);
    }

    @Override
    public List<PartsDTO> findAllParts() {
        return modelmapper.mapAll(partRepository.findAll(), PartsDTO.class);
    }
}
