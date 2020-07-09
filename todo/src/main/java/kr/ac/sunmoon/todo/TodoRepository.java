package kr.ac.sunmoon.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<TodoVo, Long> {
	public List<TodoVo> findByNo(Long no);
	public List<TodoVo> findBytitle(String title);
	public List<TodoVo> findBycontentsLike(String contents);
	public void deleteByNo(Long no);
	public TodoVo save(TodoVo todoVo);
	public void updateByNo(Long no, TodoVo todoVo);
}
