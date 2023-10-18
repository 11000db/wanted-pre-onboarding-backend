package com.wanted.employment.dto;

import com.wanted.employment.entity.EmpEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmpDTO {
  private Long id;
  private String companyId;
  private String pass;
  private String nation;
  private String area;
  private String position;
  private int compensation;
  private String skill;
  private String contents;

  public static EmpDTO toEmpDTO(EmpEntity empEntity) {
    EmpDTO empDTO = new EmpDTO();
    empDTO.setId(empEntity.getId());
    empDTO.setCompanyId(empEntity.getCompanyId());
    empDTO.setPass(empEntity.getPass());
    empDTO.setNation(empEntity.getNation());
    empDTO.setArea(empEntity.getArea());
    empDTO.setPosition(empEntity.getPosition());
    empDTO.setCompensation(empEntity.getCompensation());
    empDTO.setSkill(empEntity.getSkill());
    empDTO.setContents(empEntity.getContents());
    return empDTO;
  }

}
