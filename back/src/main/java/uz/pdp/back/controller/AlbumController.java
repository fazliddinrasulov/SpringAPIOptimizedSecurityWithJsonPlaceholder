package uz.pdp.back.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.back.service.AlbumService;

@RestController
@RequestMapping("api/albums")
@RequiredArgsConstructor
public class AlbumController {
    private final AlbumService albumService;
    @GetMapping
    public HttpEntity<?> getUserAlbums(@RequestParam Integer userId){
        return ResponseEntity.ok(albumService.getUserAlbum(userId));
    }
}
