package kr.ac.sunmoon.todo;

import java.util.List;

import kr.ac.sunmoon.todo.entity.Todo;

public interface TodoServiceIn {
	public boolean addTodo(TodoVo todoVo);
	public List<TodoVo> getTodoList();
	public TodoVo getTodo(long no);
	public boolean editTodo(TodoVo todoVo);
	public boolean removeTodo(long no);
}
