package uz.pdp.back.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService{
    private final UtilService utilService;
    @Override
    public String getAlbumPhotos(String albumId) {
       return utilService.fetchData("https://jsonplaceholder.typicode.com/photos?albumId="+albumId);
    }
}
