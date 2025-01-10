package com.abhishek.question_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.abhishek.question_service.model.Question;
import com.abhishek.question_service.model.QuestionWrapper;
import com.abhishek.question_service.model.Response;
import com.abhishek.question_service.service.QuestionService;



@RestController
@CrossOrigin
@RequestMapping("questions")
public class QuestionController {
    
    
    private QuestionService questionService;
    @Autowired
    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }
    
    @GetMapping("all-questions")
    public ResponseEntity<List<Question>> allQuestions() {
        return questionService.getAllQuestions();
    }
    
    @GetMapping("category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
    	return questionService.getQuestionByCategory(category);
    }
    
    @PostMapping("add-question")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question) {
        return questionService.addQuestion(question);
    }
    
    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQuestions) {
    	return questionService.getQuestionsForQuiz(category, numQuestions);
    }
    
    @PostMapping("get-questions")
    public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody List<Integer> questionIds) {
    	return questionService.getQuestionsFromId(questionIds);
    }
    
    @PostMapping("get-score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses) {
    	return questionService.getScore(responses);
    }
}
