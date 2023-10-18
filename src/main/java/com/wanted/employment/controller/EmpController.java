package com.wanted.employment.controller;

import com.wanted.employment.EmploymentApplication;
import com.wanted.employment.dto.EmpDTO;
import com.wanted.employment.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/emp")
public class EmpController {
  private final EmpService empService;

  @GetMapping("/save")
  public String saveForm(){
    return "save";
  }
  @PostMapping("/save")
  public String save(@ModelAttribute EmpDTO empDTO){
    System.out.println("empDTO = " + empDTO);
    empService.save(empDTO);
    return "index";
  }

  @GetMapping("/")
  public String findAll(Model model){
    //DB에서 전체 게시글 데이터 가져와서 list.html에 출력
    List<EmpDTO> empDTOList = empService.findAll();
    model.addAttribute("empList", empDTOList);
    return "list";
  }

  @GetMapping("/{id}")
  public String findById(@PathVariable Long id, Model model){
    EmpDTO empDTO = empService.findById(id);
    model.addAttribute("emp", empDTO);
    return "detail";
  }

  @GetMapping("/update/{id}")
  public String updateForm(@PathVariable Long id, Model model){
    EmpDTO empDTO = empService.findById(id);
    model.addAttribute("empUpdate", empDTO);
    return "update";
  }

  @PostMapping("/update")
  public String update(@ModelAttribute EmpDTO empDTO, Model model){
    EmpDTO emp= empService.update(empDTO);
    model.addAttribute("emp", empDTO);
    return "detail";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id){
    empService.delete(id);
    return "redirect:/emp/";
  }
}
