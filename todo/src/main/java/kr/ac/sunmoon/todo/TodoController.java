package kr.ac.sunmoon.todo;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ModelAndView getTodoList(@RequestParam(value = "result", required = false, defaultValue = "none") String result) {
		ModelAndView mav = new ModelAndView("/main");
		mav.addObject(result);
		return mav;
	}
	
	@GetMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<TodoVo> getTodoList() {
		List<TodoVo> todoVoList = todoService.getTodoList();
		return todoVoList;
	}
	
	@PostMapping("/{no}")
	public TodoVo getTodo (@PathVariable long no) {
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
