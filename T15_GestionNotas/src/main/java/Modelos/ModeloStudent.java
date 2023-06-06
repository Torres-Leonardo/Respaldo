package Modelos;

public class ModeloStudent {
	private Integer id;
	private String names;
	private String last_name;
	private String type_document;
	private String number_document;
	private String email;
	private String cell_phone;
	private String activate;
	private String grade_id;
	
	public ModeloStudent() {
	}

	public ModeloStudent(Integer id, String names, String last_name, String type_document, String number_document,
			String email, String cell_phone, String activate, String grade_id) {
		super();
		this.id = id;
		this.names = names;
		this.last_name = last_name;
		this.type_document = type_document;
		this.number_document = number_document;
		this.email = email;
		this.cell_phone = cell_phone;
		this.activate = activate;
		this.grade_id = grade_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String string) {
		this.names = string;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getType_document() {
		return type_document;
	}

	public void setType_document(String type_document) {
		this.type_document = type_document;
	}

	public String getNumber_document() {
		return number_document;
	}

	public void setNumber_document(String number_document) {
		this.number_document = number_document;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCell_phone() {
		return cell_phone;
	}

	public void setCell_phone(String cell_phone) {
		this.cell_phone = cell_phone;
	}

	public String getActivate() {
		return activate;
	}

	public void setActivate(String activate) {
		this.activate = activate;
	}

	@Override
	public String toString() {
		String data = "[id: " + this.id;
		data += ", names: " + this.names;
		data += ", last_name: " + this.last_name;
		data += ", type_document: " + this.type_document;
		data += ", number_document: " + this.number_document;
		data += ", email: " + this.email;
		data += ", cell_phone: " + this.cell_phone;
		data += ", activate: " + this.activate; 
		data += ", grade_id: " + this.grade_id + "]";
		return data;
	}

	public String getGrade_id() {
		return grade_id;
	}

	public void setGrade_id(String grade_id) {
		this.grade_id = grade_id;
	}
}