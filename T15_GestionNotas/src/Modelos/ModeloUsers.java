package Modelos;

public class ModeloUsers {
	private Integer identifier;
	private String type_document;
	private String number_document;
	private String type_user;
	private String names;
	private String last_name;
	private String email;
	private String cell_phone;
	private String activate;

	
	public ModeloUsers() {
	}

	public ModeloUsers(Integer identifier,  String type_document,  String number_document, String type_user, String names, String last_name,
			 String email, String cell_phone, String activate)
	{
		super();
		this.identifier = identifier;
		this.type_document = type_document;
		this.number_document = number_document;
		this.type_user = type_user;
		this.names = names;
		this.last_name = last_name;
		this.email = email;
		this.cell_phone = cell_phone;
		this.activate = activate;
	}
	
	public Integer getIdentifier() {
		return identifier;
	}

	public void setIdentifier(Integer identifier) {
		this.identifier = identifier;
	}
	
	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
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

	public String getType_user() {
		return type_user;
	}

	public void setType_user(String type_user) {
		this.type_user = type_user;
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
		String data = "[id: " + this.identifier;
		data += ", type_document: " + this.type_document;
		data += ", number_document: " + this.number_document;
		data += ", type_user: " + this.type_user;
		data += ", names: " + this.names;
		data += ", last_name: " + this.last_name;
		data += ", email: " + this.email;
		data += ", cell_phone: " + this.cell_phone;
		data += ", activate: " + this.activate + "]";
		return data;
	}

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}


}
