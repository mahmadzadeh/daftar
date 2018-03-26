package com.daftar.daftar;

import com.daftar.daftar.domain.Diary;
import com.daftar.daftar.service.DiaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/diaries")
public class DiaryController {

    private final DiaryService service;

    public DiaryController( DiaryService service ) {
        this.service = service;
    }

    @GetMapping("/id/{id}")
    private Diary getDiary( @PathVariable Long id ) {
        return service.getDiary( id );
    }

    @GetMapping("/date/{date}")
    private Diary getDiary( @PathVariable Optional<LocalDate> date ) {
        return service.getDiary( date );
    }
}

