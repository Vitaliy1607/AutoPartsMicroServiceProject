package com.parts.partsrestapi.service;



import com.parts.partsrestapi.domain.PartsDTO;
import com.parts.partsrestapi.entity.PartEntity;

import java.util.List;

public interface PartService {

    void addPart(PartsDTO partsDTO);

    List<PartsDTO> findAllParts();

    PartsDTO findPartById(Long id);

    void deletePart(Long id);
}
