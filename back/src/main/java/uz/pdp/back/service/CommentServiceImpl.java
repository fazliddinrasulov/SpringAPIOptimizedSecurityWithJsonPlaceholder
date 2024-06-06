package uz.pdp.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final UtilService utilService;
    @Override
    public String getPostComments(int postId) {
        return utilService.fetchData("https://jsonplaceholder.typicode.com/comments?postId="+postId);
    }
}
