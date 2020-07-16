package kr.ac.sunmoon.todo;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.ac.sunmoon.todo.entity.Todo;
import kr.ac.sunmoon.todo.entity.TodoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TodoService {
	private final TodoRepository todoRepository;
	
	public List<TodoVo> getTodoList() {
		List<Todo> todoList = todoRepository.findAll();
		
		List<TodoVo> todoVoList = new ArrayList<TodoVo>();
		for (Todo todo : todoList) {
			TodoVo todoVo = TodoVo.builder()
							.no(todo.getNo())
							.title(todo.getTitle())
							.contents(todo.getContents())
							.registerDate(todo.getRegisterDate())
							.build();
			todoVoList.add(todoVo);
		}
		
		return todoVoList;
		
	}
}
