package uz.pdp.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.pdp.back.service.PhotoService;

@RestController
@RequestMapping("api/photos")
@RequiredArgsConstructor
public class PhotoController {
    private final PhotoService photoService;
    @GetMapping
    public HttpEntity<?> getAlbumPhotos(@RequestParam String albumId) {
        String json = photoService.getAlbumPhotos(albumId);
        return ResponseEntity.ok(json);
    }
}
