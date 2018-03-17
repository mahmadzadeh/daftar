package com.daftar.daftar;

import com.daftar.daftar.domain.Diary;
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

        mockMvc.perform( MockMvcRequestBuilders.get( "/diaries/12345" ) )
                .andExpect( status().isOk() )
                .andExpect( jsonPath( "content" ).value( diaryContent ) )
                .andExpect( jsonPath( "date" ).value( expectedDate.toString() ) );
    }

}
