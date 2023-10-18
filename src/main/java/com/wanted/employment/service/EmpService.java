package com.wanted.employment.service;

import com.wanted.employment.dto.EmpDTO;
import com.wanted.employment.entity.EmpEntity;
import com.wanted.employment.repository.EmpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmpService {
  private final EmpRepository empRepository;


  public void save(EmpDTO empDTO){
    EmpEntity empEntity = EmpEntity.toSaveEntity(empDTO);
    empRepository.save(empEntity);
  }

  public List<EmpDTO> findAll(){
    List<EmpEntity> empEntityList = empRepository.findAll();
    List<EmpDTO> empDTOList = new ArrayList<>();
    for(EmpEntity empEntity: empEntityList){
      empDTOList.add(EmpDTO.toEmpDTO(empEntity));
    }
    return empDTOList;
  }
  @Transactional
  public EmpDTO findById(Long id) {
    Optional<EmpEntity> optionalEmpEntity = empRepository.findById(id);
    if (optionalEmpEntity.isPresent()) {
      EmpEntity empEntity = optionalEmpEntity.get();
      EmpDTO empDTO = EmpDTO.toEmpDTO(empEntity);
      return empDTO;
    } else {
      return null;
    }
  }
  @Transactional
  public EmpDTO update(EmpDTO empDTO) {
    EmpEntity empEntity = EmpEntity.toUpdateEntity(empDTO);
    empRepository.save(empEntity);
    return findById(empDTO.getId());
  }
  public void delete(Long id){
    empRepository.deleteById(id);
  }
}
