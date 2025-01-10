package com.abhishek.question_service.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhishek.question_service.dao.QuestionDao;
import com.abhishek.question_service.model.Question;
import com.abhishek.question_service.model.QuestionWrapper;
import com.abhishek.question_service.model.Response;

@Service
public class QuestionService {
	
	private QuestionDao questionDao;
	@Autowired
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<Question> addQuestion(Question question) {
		try {
			return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<Question>(), HttpStatus.BAD_REQUEST);
		}
	}

	public ResponseEntity<List<Integer>> getQuestionsForQuiz(String category, Integer numQuestions) {
		List<Integer> questions = questionDao.findRandomQuestionByCategory(category, numQuestions);
		return new ResponseEntity<>(questions, HttpStatus.CREATED);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(List<Integer> questionIds) {
		List<QuestionWrapper> wrapper = new ArrayList<>();
		List<Question> questions = new ArrayList<>();
		
		for (Integer id: questionIds) {
			questions.add(questionDao.findById(id).get());
		}
		
		for (Question q: questions) {
			QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
			wrapper.add(qw);
		}
		
		return new ResponseEntity<>(wrapper, HttpStatus.OK);
	}

	public ResponseEntity<Integer> getScore(List<Response> responses) {
		int score = 0;
		
		for (Response response: responses) {
			Question q = questionDao.findById(response.getId()).get();
			if (response.getResponse().equals(q.getRightAnswer())) 
				score++;
		}
		return new ResponseEntity<>(score, HttpStatus.OK);
	}
	
	

}
