package ca.sheridancollege.antonye.model;



public class QuestionAndResponse{
	private String question ="";
	private String response ="";
	
	//no-org Constructor
	public QuestionAndResponse() {
		
	}
	
	//constructor with argument
	public QuestionAndResponse(String q) {
		this.question=q;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String q) {
		this.question = q;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String r) {
		this.response = r;
	}
	
	public  String toString()
	{
		String qr=this.question+"\n"+this.response;
		return qr;
	}

}
