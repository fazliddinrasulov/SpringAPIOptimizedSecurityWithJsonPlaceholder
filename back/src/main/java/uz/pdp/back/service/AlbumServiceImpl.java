package uz.pdp.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {
    private final UtilService utilService;
    @Override
    public String getUserAlbum(int userId) {
        return utilService.fetchData("https://jsonplaceholder.typicode.com/albums?userId="+userId);
    }
}
