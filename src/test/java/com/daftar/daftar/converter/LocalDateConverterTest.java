package com.daftar.daftar.converter;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static com.daftar.daftar.converter.LocalDateConverter.DATE_FORMAT;
import static java.time.LocalDate.parse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LocalDateConverterTest {

    @Test
    public void convertWhenInvalidInputGivenReturnsOptionalOfEmpty() {
        assertEquals( Optional.empty(), new LocalDateConverter( DATE_FORMAT ).convert( null ) );
    }

    @Test
    public void convertWhenValidInputGivenReturnsDate() {
        Optional<LocalDate> actual = new LocalDateConverter( DATE_FORMAT ).convert( "2018-03-25" );

        assertTrue( actual.isPresent() );

        LocalDate expected = parse( "2018-03-25", DateTimeFormatter.ofPattern( DATE_FORMAT ) );

        Assertions.assertThat( actual.get() ).isEqualTo( expected );
    }
}