package com.example.demo.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "youtube_chanel")
	private String youtubeChanel;
	private String hobby;
	@OneToOne(mappedBy = "instructorDetail",cascade = CascadeType.ALL)
	private Instructor instructor;
	
	public Instructor getInstructor() {
		return instructor;
	}
	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	public InstructorDetail(String youtubeChanel, String hobby) {
		super();
		this.youtubeChanel = youtubeChanel;
		this.hobby = hobby;
	}
	public InstructorDetail() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYoutubeChanel() {
		return youtubeChanel;
	}
	public void setYoutubeChanel(String youtubeChanel) {
		this.youtubeChanel = youtubeChanel;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChanel=" + youtubeChanel + ", hobby=" + hobby + "]";
	}
	
}
