package com.manoj.quiz_service.Feign;

import com.manoj.quiz_service.model.QuestionWrapper;
import com.manoj.quiz_service.model.QuizDto;
import com.manoj.quiz_service.model.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {

    @GetMapping("/question/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(
            @RequestParam("categoryName") String categoryName,
            @RequestParam("numQuestions") Integer numQuestions);
    @PostMapping("/question/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionId);
    @PostMapping("/question/getScore")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);


}
