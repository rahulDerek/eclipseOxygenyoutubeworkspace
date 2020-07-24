package serialization_DeSerialization;

import java.util.List;

public class Student {
	
	public Integer id;
	public String firstName;
	public String lastName;
	public String email;
	public String programme;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProgramme() {
		return programme;
	}
	public void setProgramme(String programme) {
		this.programme = programme;
	}
	
	List<String> courses;
	public List<String> getCourses() {
		return courses;
	}
	public void setCourses(List<String> courses) {
		this.courses = courses;
	}

	public Integer getSId() {
		return id;
	}
	public void setSId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName()
	{
		
		return firstName;
	}
	
	public void setFirstName(String fName)
	{
		this.firstName =fName;
	}
	
	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lName)
	{
		this.lastName =lName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String semail)
	{
		this.email =semail;
	}
	
	public String getStudentRecord()
	{
		
		
		return(this.id+" "+this.firstName+" "+this.lastName+"  "+this.email+" "+this.programme+"  "+this.courses);
	}
	
	
	
	
}
