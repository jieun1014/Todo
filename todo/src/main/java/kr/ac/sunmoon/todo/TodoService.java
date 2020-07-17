package kr.ac.sunmoon.todo;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import kr.ac.sunmoon.todo.entity.Todo;
import kr.ac.sunmoon.todo.entity.TodoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class TodoService implements TodoServiceIn{
	private final TodoRepository todoRepository;
	
	@Transactional
	@SuppressWarnings("finally")
	@Override
	public boolean addTodo(TodoVo todoVo) {
		boolean result = false;
		try {
			Todo todo = Todo.builder()
					.title(todoVo.getTitle())
					.contents(todoVo.getContents())
					.registerDate(new Date())
					.build();
			
			todoRepository.save(todo);
			
			result = true;
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}
	}

	@Override
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

	@Override
	public TodoVo getTodo(long no) {
		Optional<Todo> todoOp = todoRepository.findById(no);
		
		TodoVo todoVo = null;
		
		if (todoOp.isPresent()) {
			Todo todo = todoOp.get();
			
			todoVo = TodoVo.builder()
							.no(todo.getNo())
							.title(todo.getTitle())
							.contents(todo.getContents())
							.registerDate(todo.getRegisterDate())
							.build();
		}
		return todoVo;
	}

	@Transactional
	@SuppressWarnings("finally")
	@Override
	public boolean editTodo(TodoVo todoVo) {
		boolean result = false;
		
		try {
			if (todoVo.getNo() > 0) {
				Todo todo = Todo.builder()
						.title(todoVo.getTitle())
						.contents(todoVo.getContents())
						.registerDate(todoVo.getRegisterDate())
						.build();
				
				todoRepository.save(todo);
				
				result =  true;
			}
		} catch(Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}
	}

	@Transactional
	@SuppressWarnings("finally")
	@Override
	public boolean removeTodo(long no) {
		boolean result = false;
		try {
			Optional<Todo> option = todoRepository.findById(no);
			
			if (option.isPresent()) {
				Todo todo = option.get();
				
				todoRepository.delete(todo);
				result =  true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = false;
		} finally {
			return result;
		}
	}
}
