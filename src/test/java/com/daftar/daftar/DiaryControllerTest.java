package com.daftar.daftar;

import com.daftar.daftar.domain.Diary;
import com.daftar.daftar.service.DiaryNotFoundException;
import com.daftar.daftar.service.DiaryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(DiaryController.class)
public class DiaryControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    DiaryService service;

    @Test
    public void getDiaryShouldReturnSingleDiary() throws Exception {

        String diaryContent = "my daily diary";
        LocalDate expectedDate = LocalDate.now();

        when( service.getDiary( anyLong() ) ).thenReturn( new Diary( diaryContent, expectedDate ) );

        mockMvc.perform( MockMvcRequestBuilders.get( "/diaries/id/12345" ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "content" ).value( diaryContent ) )
                .andExpect( jsonPath( "date" ).value( expectedDate.toString() ) );
    }

    @Test
    public void getDiaryWhenNoDiaryExistReturnsNotFound() throws Exception {

        when( service.getDiary( anyLong() ) ).thenThrow( new DiaryNotFoundException( "Unable to find diary with id" ) );

        mockMvc.perform( MockMvcRequestBuilders.get( "/diaries/id/12345" ) ).andExpect( status().isNotFound() );
    }

    @Test
    public void getDiaryGivenDateWhenNoDiaryExistForDateReturnsNothing() throws Exception {

        when( service.getDiary( Optional.of( LocalDate.now() ) ) )
                .thenThrow( new DiaryNotFoundException( "Unable to find diary with id" ) );

        mockMvc.perform( MockMvcRequestBuilders.get( "/diaries/date/2018-03-25" ) ).andExpect( status().isNotFound() );
    }


}
