package Exercises;

/*Create a Student Database with the following attributes:
- New Student constructor that takes name and SSN in the arguments
- Automatically create an email ID based on the name
- Set a private static ID
- Generate a user ID that is combination of Static ID, random 4-digit number between 1000 and 9000, and last 4 of SSN
- Methods: enroll(), pay(), checkBalance(), toString(), showCourses()
- Use encapsulation to set variables (phone, city, state)*/

public class studentDatabase {

	public static void main(String[] args) {
		//Create a student
		Student s1 = new Student ("John", "348962718");
		Student s2 = new Student ("Maria", "348912318");
		
		
		s1.enroll("Maths");
		s1.enroll("Romanian");
		s1.enroll("French");
		
		s1.showCourses();
		s1.checkBalance();
		s1.payTuition(600);
		s1.checkBalance();
		System.out.println(s1.toString());
		
		s2.enroll("History");
		s2.enroll("Romanian");
		s2.enroll("Chemistry");
		
		s2.showCourses();
		s2.checkBalance();
		s2.payTuition(400);
		s2.checkBalance();
		System.out.println(s2.toString());
	}
}
class Student {
	//Properties
	private static int iD = 10;
	private String name;
	private String email;
	private String ssn;
	private String userId;
	private String courses = "";
	private static final int costOfCourse = 400;
	private int balance=0;
	private String phone;
	private String state;
	private String city;
	
	public Student(String name, String ssn) {
		iD++;
		this.name = name;
		this.ssn = ssn;
		setUserId();
		setEmail();
		
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	private void setEmail() {
		email = name.toLowerCase() + "." + iD + "@studentuniversity.com";
	System.out.println("Your email: " + email);	
	}
	public String getEmail() {
		return email;
	}
	private void setUserId() {
		int max = 9000;
		int min = 1000;
		int ranNum = (int) (Math.random()*((max-min)));
		ranNum = ranNum + min;
		userId = iD + "" + ranNum + ssn.substring(4);
		System.out.println("Your user ID: " + userId);
	}
	public void enroll(String course) {
		this.courses = this.courses + "\n" + course;
	System.out.println(courses);
	balance = balance + costOfCourse;
	}
	public void payTuition(int amount) {
		System.out.println("Payment: $" + amount);
		balance = balance + amount;
		
	}
	public void checkBalance() {
		System.out.println("Balance: $" + balance);
	}
	public void showCourses() {
		System.out.println(courses);
	}
	public String toString() {
		return "[NAME: " + name + " ]\n[COURSES: " + courses + " ]\nBALANCE: " + balance + " ]";
	}
}
