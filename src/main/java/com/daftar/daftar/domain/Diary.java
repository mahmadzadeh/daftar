package com.daftar.daftar.domain;

import java.time.LocalDate;

public class Diary {

    private String content;
    private LocalDate date;

    protected Diary() {
    }

    public Diary( String content, LocalDate date ) {
        this.content = content;
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public LocalDate getDate() {
        return date;
    }
}
