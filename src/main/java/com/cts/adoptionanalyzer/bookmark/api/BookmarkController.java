package com.cts.adoptionanalyzer.bookmark.api;

import com.cts.adoptionanalyzer.bookmark.dto.BookmarkResponseDTO;
import com.cts.adoptionanalyzer.bookmark.service.BookmarkService;
import com.cts.adoptionanalyzer.bookmark.dto.BookmarkRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bookmark")
public class BookmarkController {

    private final BookmarkService service;

    public BookmarkController(BookmarkService service){
        this.service = service;
    }

    @PostMapping("/save")
    public BookmarkResponseDTO saveJob(@RequestBody BookmarkRequestDTO dto){
        return service.addBookmark(dto);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBookmark(@PathVariable String id) {
        service.deleteBookmark(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{userId}")
    public List<BookmarkResponseDTO> getBookmarkByUserId(@PathVariable String userId){
        return service.getByUserId(userId);
    }
}
