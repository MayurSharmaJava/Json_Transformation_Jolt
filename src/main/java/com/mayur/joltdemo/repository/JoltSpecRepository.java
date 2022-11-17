package com.mayur.joltdemo.repository;

import com.mayur.joltdemo.entity.JoltSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoltSpecRepository extends JpaRepository<JoltSpec, Long>{

}
