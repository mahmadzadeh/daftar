package com.daftar.daftar;

import com.daftar.daftar.domain.Diary;
import com.daftar.daftar.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiaryController {

    @Autowired
    private final DiaryService service;

    public DiaryController( DiaryService service ) {
        this.service = service;
    }

    @GetMapping("/diaries/{id}")
    private Diary getDiary( @PathVariable Long id ) {
        return service.getDiary( id );
    }

}

