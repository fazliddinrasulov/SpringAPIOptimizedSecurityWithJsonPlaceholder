package uz.pdp.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.back.service.PostService;

@RestController
@RequestMapping("api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @GetMapping
    public HttpEntity<?> getPosts(@RequestParam Integer userId) {
        String json = postService.getPosts(userId);
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
