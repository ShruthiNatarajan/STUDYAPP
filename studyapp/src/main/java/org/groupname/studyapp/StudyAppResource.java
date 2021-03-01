package org.groupname.studyapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class StudyAppResource {
@Autowired
private StudyAppService studyAppService;

@GetMapping("/quiz")
public QuizSession getQuizSession() {
return studyAppService.generateQuestion();
}

@PutMapping("/quiz2")
public QuizSession getQuizSession(@RequestParam("response") String response) {
return studyAppService.generateQuestion(response);
}
}