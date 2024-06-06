package uz.pdp.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.back.service.TodoService;

@RestController
@RequestMapping("api/todos")
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
    @GetMapping
    public HttpEntity<?> getUserTodos(@RequestParam Integer userId){
        String json = todoService.getUserTodos(userId);
        return ResponseEntity.ok(json);
    }

}
