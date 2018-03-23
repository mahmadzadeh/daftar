package com.daftar.daftar;

import com.daftar.daftar.domain.Diary;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@DataJpaTest
public class DiaryRepositoryTest {

    @Autowired
    private DiaryRepository repository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void findByIdWhenDiaryWithIdExistReturnsDiary() {

        Diary expected = persist( new Diary( "aasda", LocalDate.now() ) );

        Optional<Diary> actual = repository.findById( expected.getId() );

        assertTrue( actual.isPresent() );

        Assertions.assertThat( actual.get() ).isEqualTo( expected );
    }

    @Test
    public void diariesCanBeSearchedByDate() {

        LocalDate now = LocalDate.now();

        persist( new Diary( "aasda", now ) );

        Optional<Diary> actual = repository.findByDate( now );

        assertTrue( actual.isPresent() );
    }

    private Diary persist( Diary diary ) {
        return testEntityManager.persistFlushFind( diary );
    }
}