package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "frist_name")
	private String  fristName;
	@Column(name = "last_name")
	private String  lastName;
	private String email;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
				name = "course_student"
				,joinColumns = @JoinColumn(name="student_id")
				,inverseJoinColumns = @JoinColumn(name = "course_id")
				
			)
	
	private List<Course> listCourses;
	public Student(String fristName, String lastName, String email) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
	}
	public Student() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFristName() {
		return fristName;
	}
	public void setFristName(String fristName) {
		this.fristName = fristName;
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
	@Override
	public String toString() {
		return "Student [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	public List<Course> getListCourses() {
		return listCourses;
	}
	public void setListCourses(List<Course> listCourses) {
		this.listCourses = listCourses;
	}
	public void addCourse(Course course) {
		if (listCourses == null) {
			listCourses = new ArrayList<>();
		}
		listCourses.add(course);
	}
	
}
