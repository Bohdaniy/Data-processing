package lab5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity

@Table(name="users")
public class User {
	@Id
	@GeneratedValue
	int id;
	String name;
	int age;
	String lang;
	String country;

	public String getLang() {
		return lang;
	}

	String email;
	int phone;
	int password;
	String login;

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	String image;
	public User() {
		
	}
	
	
	public User(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.lang = lang;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.login = login;
		this.image = image;
    }


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public String setLang(){return lang; }
	public void setLang(String lang){this.lang = lang; }

	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country; }

	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email; }

	public int getPhone() {return phone;}
	public void setPhone(int phone) {this.phone = phone; }

	public int getPassword() {return password;}
	public void setPassword(int password) {this.password = password; }

	public String getLogin() {return login;}
	public void setLogin(String login) {this.login = login; }




	@Override
	public String toString() {
		return "{\"id\":"+id+",\"name\":\""+name+"\", \"age\":"+age+", \"lang\":\""+lang+"\", \"country\":\""+country+"\", \"email\":\""+email+"\", \"phone\":"+phone+"}";
	}
	

}
