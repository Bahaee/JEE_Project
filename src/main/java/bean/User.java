package bean;

public class User {
	
	//Properties
	private int idUser;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private double phone;
	private int age;
	private String gender;
	private String nationality;
	private String nationalIdentity;
	private String functionality;
	
	
	//Constructors
	public User() {
		super();
	}
	
	public User(int idUser, String username, String firstName, String lastName, String email, double phone, int age,
			String gender, String nationality, String nationalIdentity, String functionality) {
		super();
		this.idUser=idUser;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		this.nationalIdentity = nationalIdentity;
		this.functionality = functionality;
	}
	
	public User(String username, String firstName, String lastName, String email, double phone, int age, String gender,
			String nationality, String nationalIdentity, String functionality) {
		super();
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.age = age;
		this.gender = gender;
		this.nationality = nationality;
		this.nationalIdentity = nationalIdentity;
		this.functionality = functionality;
	}

	//Getters and Setters
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public double getPhone() {
		return phone;
	}
	public void setPhone(double phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public String getNationalIdentity() {
		return nationalIdentity;
	}
	public void setNationalIdentity(String nationalIdentity) {
		this.nationalIdentity = nationalIdentity;
	}
	public String getFunctionality() {
		return functionality;
	}
	public void setFunctionality(String functionality) {
		this.functionality = functionality;
	}


}
