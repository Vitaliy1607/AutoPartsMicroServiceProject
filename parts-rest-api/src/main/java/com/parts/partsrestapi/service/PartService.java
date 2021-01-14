package com.parts.partsrestapi.service;



import com.dto.dtomanager.domain.PartsDTO;

import java.util.List;

public interface PartService {

    void addPart(PartsDTO partsDTO);

    List<PartsDTO> findAllParts();

    PartsDTO findPartById(Long id);

    void deletePart(Long id);
}
