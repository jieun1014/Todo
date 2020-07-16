package kr.ac.sunmoon.todo.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;

@Getter
@Entity
public class Todo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long no;
	private String title;
	private String contents;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date registerDate;
}
