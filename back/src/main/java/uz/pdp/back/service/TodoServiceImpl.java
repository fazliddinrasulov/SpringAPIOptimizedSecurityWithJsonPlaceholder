package uz.pdp.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoServiceImpl  implements TodoService {
    private final UtilService utilService;
    @Override
    public String getUserTodos(Integer userId) {
        return utilService.fetchData("https://jsonplaceholder.typicode.com/todos?userId="+userId);
    }
}
