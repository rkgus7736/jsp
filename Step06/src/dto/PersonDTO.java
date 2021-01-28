package dto;

public class PersonDTO {
	private String name;
	private int age;
	//기본 생성자, setter, getter 만들어주기 필수 (데이터 세팅,읽어오기위해)
	public PersonDTO() {
		super();
		System.out.println("PersonDTO Constructor");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
