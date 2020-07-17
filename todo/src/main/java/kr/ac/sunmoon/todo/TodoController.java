package kr.ac.sunmoon.todo;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.servlet.view.RedirectView;

import kr.ac.sunmoon.todo.entity.TodoRepository;
import kr.ac.sunmoon.todo.userEntity.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	private final HttpSession httpSession;
	
	@GetMapping("/login")
	public 	ModelAndView login() {
		ModelAndView mav = new ModelAndView("/todo");
		
		SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if (user != null) {
			mav.addObject("username", user.getName());
		}
		
		return mav;
	}
	
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
	public ModelAndView getTodo (@PathVariable long no) {
		ModelAndView mav = new ModelAndView("/view");
		
		TodoVo todoVo = todoService.getTodo(no);
		mav.addObject("todo", todoVo);
		
		return mav;
	} 
	
	@GetMapping("/new")
	public ModelAndView getTodoForm() {
		ModelAndView mav = new ModelAndView("/add");
		return mav;
	}
	
	@PostMapping
	public ModelAndView addTodo(TodoVo todoVo) {
		ModelAndView mav = new ModelAndView(new RedirectView("/todo"));
		
		boolean result = todoService.addTodo(todoVo);
		
		if (result) {
			mav.addObject("result", "addSuccess");
		} else {
			mav.addObject("result", "addFail");
		}

		return mav;
	}
	
	@PutMapping
	public ModelAndView editTodo(TodoVo todoVo) {
		ModelAndView mav = new ModelAndView(new RedirectView("/todo/" + todoVo.getNo()));
		
		boolean result = todoService.editTodo(todoVo);
		
		if (result) {
			mav.addObject("result", "editSuccess");
		} else {
			mav.addObject("result", "editFail");
		}
		
		return mav;
	}
	
	@DeleteMapping
	public ModelAndView removeTodo(long no) {
		ModelAndView mav = new ModelAndView(new RedirectView("/todo"));
		
		boolean result = todoService.removeTodo(no);
		
		if (result) {
			mav.addObject("result", "removeSuccess");
		} else {
			mav.addObject("result", "removeFail");
		}
		
		return mav;
	}
}
