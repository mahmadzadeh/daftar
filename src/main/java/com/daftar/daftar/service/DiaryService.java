package com.daftar.daftar.service;

import com.daftar.daftar.DiaryRepository;
import com.daftar.daftar.domain.Diary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService( DiaryRepository diaryRepository ) {

        this.diaryRepository = diaryRepository;

    }

    public Diary getDiary( Long id ) {

        return diaryRepository.findById( id )
                .orElseThrow( () -> new DiaryNotFoundException( "Unable to find diary for id " + id ) );
    }

    public Diary getDiary( Optional<LocalDate> date ) {
        return null;
    }
}
