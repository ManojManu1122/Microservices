package com.manoj.question_service.dao;

import com.manoj.question_service.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {

    List<Question> findByCategory(String category);

    /*
    The DAO layer connects to data base and retrieves the data based on the query
     */
    @Query(value = "SELECT q.id FROM question q WHERE q.category=:category ORDER BY RANDOM() LIMIT :numQ", nativeQuery = true)
    List<Integer> findRandomQuestionsByCategory(String category, int numQ);
}
