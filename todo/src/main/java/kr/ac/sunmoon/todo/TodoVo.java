package kr.ac.sunmoon.todo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.Entity;

import lombok.Data;

@Data
@Entity
public class TodoVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long no;
	private String title;
	private String contents;
	private String registerDate;
}
