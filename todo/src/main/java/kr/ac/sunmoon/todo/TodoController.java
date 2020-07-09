package kr.ac.sunmoon.todo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	
	@GetMapping
	public ModelAndView getTodo () {
		return null;
	}  
	
	@PostMapping
	public ModelAndView addTodo() {
		return null;
	}
	
	@PutMapping
	public ModelAndView editTodo() {
		return null;
	}
	
	@DeleteMapping
	public ModelAndView removeTodo() {
		return null;
	}
}
