package com.abhishek.quiz_service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.abhishek.quiz_service.model.QuestionWrapper;
import com.abhishek.quiz_service.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuizInterface {
	
	@GetMapping("questions/generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQuestions);
    
    @PostMapping("questions/get-questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds);
    
    @PostMapping("questions/get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);
}
