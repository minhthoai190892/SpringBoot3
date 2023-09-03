package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor")
public class Instructor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "frist_name")
	private String fristName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@OneToOne(cascade = CascadeType.ALL)
	private InstructorDetail instructorDetail;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "instructor",cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	private List<Course> courses;
	
	
	
	@Override
	public String toString() {
		return "Instructor [id=" + id + ", fristName=" + fristName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

	public Instructor(String fristName, String lastName, String email) {
		super();
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public InstructorDetail getInstructorDetail() {
		return instructorDetail;
	}
	public void setInstructorDetail(InstructorDetail instructorDetail) {
		this.instructorDetail = instructorDetail;
	}
	public Instructor() {
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
	public void addCourse(Course tempCourse) {
		if (courses==null) {
			courses = new ArrayList<>();
		}
		
		courses.add(tempCourse);
		tempCourse.setInstructor(this);
	}
}
