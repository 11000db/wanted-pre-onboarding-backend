package com.wanted.employment.repository;

import com.wanted.employment.entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<EmpEntity, Long> {
}
