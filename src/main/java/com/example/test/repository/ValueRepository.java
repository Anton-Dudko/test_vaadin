package com.example.test.repository;

import com.example.test.model.Value;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValueRepository extends JpaRepository<Value, Long> {


}
