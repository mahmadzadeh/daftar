package com.daftar.daftar.service;

import com.daftar.daftar.DiaryRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DiaryServiceTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();


    @Mock
    private DiaryRepository diaryRepository;

    private DiaryService sut;


    @Before
    public void setUp() {

        sut = new DiaryService( diaryRepository );
    }

    @Test
    public void getDiaryWhenNoDiaryFoundWillReturnNotFound() {

        this.thrown.expect( DiaryNotFoundException.class );
        this.thrown.expectMessage( "Unable to find diary for id 1234" );

        when( diaryRepository.findById( anyLong() ) ).thenReturn( Optional.empty() );

        sut.getDiary( 1234L );
    }


}