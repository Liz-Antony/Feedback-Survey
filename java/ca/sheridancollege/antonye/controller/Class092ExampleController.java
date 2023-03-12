package ca.sheridancollege.antonye.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.antonye.model.Participant;
import ca.sheridancollege.antonye.model.QuestionAndResponse;

@Controller
public class Class092ExampleController {
	@GetMapping("/index")
	public String index() {
	return "index";
    }
	
	//Get ParticipantInfo
	@GetMapping("/participantInfo")
	public String getParticipantInfo() {
	return "participantInfo";
	}
	
	@GetMapping("/surveyInitialization")
	public String surveyInitialization( @RequestParam String firstName,
	@RequestParam String lastName, HttpSession session) {
	Participant participant = new Participant(firstName, lastName);
	session.setAttribute("participant", participant);
	// Create question 1
	String q1="What is one thing about the application that you liked?";
	QuestionAndResponse question1 = new QuestionAndResponse();
	question1.setQuestion(q1);
	
	// Create question
	String q2="What is one thing about the application that you did not like?";
	QuestionAndResponse question2 = new QuestionAndResponse(q2);
	question2.setQuestion(q2);
	
	// Add Survey questions to the session
	session.setAttribute("q1", question1);
	session.setAttribute("q2", question2);
	return "question1";
	}
	

	// Process the response to question 1 and give question 2 for feedback
	@GetMapping("/processQuestion1")
	public String processQuestion1 (Model model, @RequestParam String response1,
	HttpSession session ) {
	// get question1 object from the session
	QuestionAndResponse q1 = (QuestionAndResponse) session.getAttribute("q1");
	// add response to the question
	q1.setResponse(response1);
	return "question2";
	}

	@GetMapping("/processQuestion2")
	public String processQuestion2 (Model model, @RequestParam String response2,
	HttpSession session ) {
	// get question1 object from the session
	QuestionAndResponse q2 = (QuestionAndResponse) session.getAttribute("q2");
	// add response to the question
	q2.setResponse(response2);
	return "surveySummary";
	}


}
