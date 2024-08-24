package com.manoj.quiz_service.service;


import com.manoj.quiz_service.Feign.QuizInterface;
import com.manoj.quiz_service.dao.QuizDao;
import com.manoj.quiz_service.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String categoryName,Integer numQuestions,String title) {
        List<Integer> questions = quizInterface.getQuestionsForQuiz(categoryName,numQuestions).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("success",HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
        Quiz quiz = quizDao.findById(id).get();
        List<Integer> questionIds = quiz.getQuestions();
        ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {

        ResponseEntity<Integer> score = quizInterface.getScore(responses);
        return score;

    }
}
