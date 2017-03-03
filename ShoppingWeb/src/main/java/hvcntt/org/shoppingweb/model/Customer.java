package hvcntt.org.shoppingweb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	@Id
	@GeneratedValue
	private int id;
	@Column(name="firstname")
	private String firstname;
	@Column(name="lastname")
	private String lastname;
	@Column(name="address")
	private String address;
	@Column(name="email")
	private String email;
	@Column(name="age")
	private String age;
	@Column(name="phone")
	private String phone;
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	public Customer(String firstname, String lastname, String address, String email, String age,String phone) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.age = age;
		this.phone=phone;
	}
	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", address=" + address
				+ ", email=" + email + ", age=" + age + ", phone=" + phone + "]";
	}

	
	
}