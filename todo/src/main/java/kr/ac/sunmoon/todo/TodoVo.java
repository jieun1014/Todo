package kr.ac.sunmoon.todo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.ibatis.type.Alias;

import lombok.Builder;
import lombok.Data;

@Data
public class TodoVo {
	private Long no;
	private String title;
	private String contents;
	private Date registerDate;
	
	@Builder
	public TodoVo(Long no, String title, String contents, Date registerDate) {
		this.no = no;
		this.title = title;
		this.contents = contents;
		this.registerDate = registerDate;
	}
}
