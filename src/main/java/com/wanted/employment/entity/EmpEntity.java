package com.wanted.employment.entity;

import com.wanted.employment.dto.EmpDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "emp_table")
public class EmpEntity {

  @Id //pk
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(length =20, nullable = false)
  private String companyId;

  @Column //default값은 크기는 255, null 가능
  private String pass;

  @Column
  private String nation;

  @Column
  private String area;

  @Column
  private String position;

  @Column
  private int compensation;

  @Column
  private String skill;

  @Column(length = 500)
  private String contents;

  public static EmpEntity toSaveEntity(EmpDTO empDTO) {
    //회사id, 채용포지션, 보상금, 내용, 기술
    EmpEntity empEntity = new EmpEntity();
    empEntity.setCompanyId(empDTO.getCompanyId());
    empEntity.setPass(empDTO.getPass());
    empEntity.setNation(empDTO.getNation());
    empEntity.setArea(empDTO.getArea());
    empEntity.setPosition(empDTO.getPosition());
    empEntity.setCompensation(empDTO.getCompensation());
    empEntity.setContents(empDTO.getContents());
    empEntity.setSkill(empDTO.getSkill());
    return empEntity;
  }

  public static EmpEntity toUpdateEntity(EmpDTO empDTO) {
    EmpEntity empEntity = new EmpEntity();
    empEntity.setCompanyId(empDTO.getCompanyId());
    empEntity.setPass(empDTO.getPass());
    empEntity.setNation(empDTO.getNation());
    empEntity.setArea(empDTO.getArea());
    empEntity.setPosition(empDTO.getPosition());
    empEntity.setCompensation(empDTO.getCompensation());
    empEntity.setContents(empDTO.getContents());
    empEntity.setSkill(empDTO.getSkill());
    return empEntity;
  }
}
