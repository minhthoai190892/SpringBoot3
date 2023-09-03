package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REFRESH})
	@JoinColumn(name = "instructor_id")
	private Instructor instructor;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "course_id")
	private List<Review> listReviews;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "course_student"
			,joinColumns = @JoinColumn(name="course_id")
			,inverseJoinColumns = @JoinColumn(name="student_id"))
	private List<Student> listStudents;
	public Course(String title) {
		super();
		this.title = title;
	}
	public Course() {
		super();
	}
	
	
	public List<Student> getListStudents() {
		return listStudents;
	}
	public void setListStudents(List<Student> listStudents) {
		this.listStudents = listStudents;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	

	public List<Review> getListReviews() {
		return listReviews;
	}
	public void setListReviews(List<Review> listReviews) {
		this.listReviews = listReviews;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + "]";
	}
//	
	public void addReview(Review review) {
		if (listReviews==null) {
			listReviews = new ArrayList<>();
		}
		listReviews.add(review);
		
	}
	public void addStudent(Student student) {
		if (listStudents ==null) {
			listReviews= new ArrayList<>();
		}
		listStudents.add(student);
	}

}
