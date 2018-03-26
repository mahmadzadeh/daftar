package com.daftar.daftar.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Diary {


    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "date")
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

    public Long getId() {
        return id;
    }


    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;

        if ( !( o instanceof Diary ) ) return false;

        Diary diary = (Diary) o;

        return new EqualsBuilder()
                .append( id, diary.id )
                .append( getContent(), diary.getContent() )
                .append( getDate(), diary.getDate() )
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder( 17, 37 )
                .append( id )
                .append( getContent() )
                .append( getDate() )
                .toHashCode();
    }
}
