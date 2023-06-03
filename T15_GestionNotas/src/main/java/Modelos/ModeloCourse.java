package Modelos;

public class ModeloCourse {
	private Integer identifier;
	private String Course_name;
	
	public ModeloCourse() {
	 }

	
	 public ModeloCourse(Integer identifier, String course_name) {
		super();
		this.identifier = identifier;
		Course_name = course_name;
	}


	public Integer getIdentifier() {
		return identifier;
	}


	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}


	public String getCourse_name() {
		return Course_name;
	}


	public void setCourse_name(String course_name) {
		Course_name = course_name;
	}

	
}
