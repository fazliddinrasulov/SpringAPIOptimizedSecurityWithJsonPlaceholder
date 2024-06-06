package uz.pdp.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.pdp.back.entity.User;
import uz.pdp.back.repo.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UtilService utilService;
    private final UserRepository userRepository;
    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public String getAllUser() {
        return utilService.fetchData("https://jsonplaceholder.typicode.com/users");
    }
}
