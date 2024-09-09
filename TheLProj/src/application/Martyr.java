package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;

//Martyr class that have Martyr method and attribute
class Martyr {
	private String name;
	private int age;
	private Date dateOfDeath;
	private char gender;
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
	private String location;

	public SimpleDateFormat getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(SimpleDateFormat dateFormat) {
		this.dateFormat = dateFormat;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Martyr(String name, int age, Date dateOfDeath, char gender) {
		this.name = name;
		this.age = age;
		this.dateOfDeath = dateOfDeath;
		this.gender = gender;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setDateOfDeath(Date dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getDateOfDeath() {
		return dateFormat.format(dateOfDeath);
	}

	public Date getDateOfDeathAsDate() {
		return dateOfDeath;
	}

	public char getGender() {
		return gender;
	}

	@Override
	public String toString() {
		int year = dateOfDeath.getYear() + 1900; // Add 1900 to get the actual year
		int month = dateOfDeath.getMonth() + 1; // Add 1 to get the actual month (0-indexed)
		int day = dateOfDeath.getDate();
		return "" + name + "," + age + "," + location + "," + month + "/" + day + "/" + year + "," + gender;

	}

	public String print() {
		int year = dateOfDeath.getYear() + 1900; // Add 1900 to get the actual year
		int month = dateOfDeath.getMonth() + 1; // Add 1 to get the actual month (0-indexed)
		int day = dateOfDeath.getDate();
		return "" + name + "," + age + "," + month + "/" + day + "/" + year + "," + gender;

	}
}
