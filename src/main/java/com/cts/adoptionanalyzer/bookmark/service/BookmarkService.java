package com.cts.adoptionanalyzer.bookmark.service;

import com.cts.adoptionanalyzer.bookmark.dto.BookmarkResponseDTO;
import com.cts.adoptionanalyzer.bookmark.model.Bookmark;
import com.cts.adoptionanalyzer.bookmark.dto.BookmarkRequestDTO;
import com.cts.adoptionanalyzer.bookmark.repo.BookmarkRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookmarkService {

    private final BookmarkRepository repository;

    public BookmarkService(BookmarkRepository repository){
        this.repository = repository;
    }

    public BookmarkResponseDTO addBookmark(BookmarkRequestDTO dto){
        return convertModelToDto(repository.save(convertDtoToModel(dto)));
    }

    public List<BookmarkResponseDTO> getByUserId(String userId){
        return repository.findByUserId(userId).stream().map(this::convertModelToDto).toList();
    }

    public void deleteBookmark(String id){
        repository.deleteById(id);
    }


    private Bookmark convertDtoToModel(BookmarkRequestDTO s){
        return new Bookmark(null, s.userId(),s.jobId(),s.notes(), LocalDateTime.now());
    }
    private BookmarkResponseDTO convertModelToDto(Bookmark s){
        return new BookmarkResponseDTO(s.id(),s.userId(),s.jobId(),s.notes(),s.createdDate());
    }
}
