package uz.pdp.back.service;

import org.springframework.stereotype.Service;

@Service
public interface TodoService {
    String getUserTodos(Integer userId);
}
