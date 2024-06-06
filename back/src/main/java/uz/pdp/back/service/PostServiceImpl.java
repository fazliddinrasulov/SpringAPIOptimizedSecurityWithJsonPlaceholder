package uz.pdp.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    private final UtilService utilService;
    @Override
    public String getPosts(Integer userId) {
        return utilService.fetchData("https://jsonplaceholder.typicode.com/posts?userId=" + userId);
    }
}
