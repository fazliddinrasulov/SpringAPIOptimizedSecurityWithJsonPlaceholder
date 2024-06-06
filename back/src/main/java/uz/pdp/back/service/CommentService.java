package uz.pdp.back.service;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
    String getPostComments(int postId);
}
