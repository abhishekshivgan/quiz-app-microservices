package com.abhishek.quiz_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhishek.quiz_service.dao.QuizDao;
import com.abhishek.quiz_service.feign.QuizInterface;
import com.abhishek.quiz_service.model.QuestionWrapper;
import com.abhishek.quiz_service.model.Quiz;
import com.abhishek.quiz_service.model.Response;

@Service
public class QuizService {
	
	@Autowired
	private QuizDao quizDao;
	public void setQuizDao(QuizDao quizDao) {
		this.quizDao = quizDao;
	}
	
	@Autowired
	private QuizInterface quizInterface;
	public void setQuestionDao(QuizInterface quizInterface) {
		this.quizInterface = quizInterface;
	}

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Integer> questions = quizInterface.getQuestionsForQuiz(category, numQ).getBody();
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		
		return new ResponseEntity<>("Success", HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(int id) {
		Optional<Quiz> quiz = quizDao.findById(id);
		List<Integer> questionIds = quiz.get().getQuestionIds();
		ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
		return questions;
	}

	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		ResponseEntity<Integer> score = quizInterface.getScore(responses);
		return score;
	}

}
