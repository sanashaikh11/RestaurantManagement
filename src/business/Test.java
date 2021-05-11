package business;

public class Test {

	private String custName,email,review,feedback,sli,prof;
	private double hour,salary;
	private boolean maxScore;
	//private double sli;

	public String getTestName() {
		return custName;
	}
	public void setTestName(String testName) {
		this.custName = testName;
	}
	public String getprof() {
		return prof;
	}
	public void setprof(String prof) {
		this.prof = prof;
	}
	public double gethour() {
		return hour;
	}
	public void sethour(double hour) {
		this.hour = hour;
	}
	public double getsalary() {
		return salary;
	}
	public void setsalary(double salary) {
		this.salary = salary;
	}
	public String getScoreObtained() {
		return email;
	}
	public void setScoreObtained(String scoreObtained) {
		this.email = scoreObtained;
	}
	public String getMaxScore() {
		return review;
	}
	public void setMaxScore(String maxScore) {
		this.review = maxScore;
	}
	public String getfeedback() {
		return feedback;
	}
	public void setfeedback(String feed) {
		this.feedback = feed;
	}
	//public String getslider() {
	//	return sli;
	//}
	//public void setslider(String slid) {
	//	this.sli = slid;
	//}
	
	public Test(String testName,String email,String rev) {
		this.custName = testName;
		this.email=email;
		this.review = rev;
		//this.feedback=feedback;
		//this.maxScore=maxScore;
		//this.maxScore = maxScore;
	}
	public Test(String testName,String email,String rev,String feedback) {
		this.custName = testName;
		this.email=email;
		this.review = rev;
		this.feedback=feedback;
		//this.maxScore=maxScore;
		//this.maxScore = maxScore;
	}
	public Test() {
		this("NULL", "null",0, 0);
	}
	public Test(String testName,String prof,double h,double salary) {
		this.custName = testName;
		this.hour=h;
		this.prof = prof;
		this.salary=salary;
		//this.maxScore=maxScore;
		//this.maxScore = maxScore;
	}
	
	public String toString() {
		return "Test : " + this.custName + " Score : " + this.email+ " / " + this.review ;
	}
}
