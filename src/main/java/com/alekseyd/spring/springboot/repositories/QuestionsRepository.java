package com.alekseyd.spring.springboot.repositories;

import com.alekseyd.spring.springboot.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface QuestionsRepository extends JpaRepository<Question, Integer> {
@Query("SELECT q.id FROM Question q WHERE q.section.name = ?1")
    List<Integer> findAllIdsBySection(String section);

@Query("SELECT id FROM Question")
    List<Integer> findAllIds();
}
