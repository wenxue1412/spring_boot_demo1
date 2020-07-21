package com.edu.domain;

import java.util.Date;

import javax.persistence.*;
@Entity
@Table(name="test_user")
public class TestUser {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 20)
	private String name;
	
	public TestUser(Integer id, String name, Date birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}
	public TestUser() {
		
	}
	@Override
	public String toString() {
		return "TestUser [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	private Date birthday;
}
