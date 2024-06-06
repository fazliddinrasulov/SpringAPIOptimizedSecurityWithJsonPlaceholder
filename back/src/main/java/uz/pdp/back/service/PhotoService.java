package uz.pdp.back.service;

import org.springframework.stereotype.Service;

@Service
public interface PhotoService {
    String getAlbumPhotos(String albumId);
}
