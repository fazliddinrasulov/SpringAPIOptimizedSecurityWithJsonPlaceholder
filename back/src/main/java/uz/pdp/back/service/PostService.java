package uz.pdp.back.service;

import org.springframework.stereotype.Service;

@Service
public interface PostService {
    String getPosts(Integer userId);
}
