package com.daftar.daftar;

import com.daftar.daftar.domain.Diary;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class DaftarApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void diariesWhenExistThen() {
        ResponseEntity<Diary> response = restTemplate.getForEntity( "/diaries/22334", Diary.class );

        assertThat( response.getStatusCode() ).isEqualTo( HttpStatus.OK );
        assertThat( response.getBody().getContent() ).isEqualTo( "This is my diary" );
    }
}
