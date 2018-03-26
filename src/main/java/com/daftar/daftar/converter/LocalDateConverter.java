package com.daftar.daftar.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static java.time.LocalDate.parse;

@Component
public class LocalDateConverter implements Converter<String, Optional<LocalDate>> {

    protected static final String DATE_FORMAT = "yyyy-MM-dd";

    private final DateTimeFormatter formatter;

    public LocalDateConverter() {
        this( DATE_FORMAT );
    }

    public LocalDateConverter( String dateFormat ) {
        this.formatter = DateTimeFormatter.ofPattern( dateFormat );
    }

    @Override
    public Optional<LocalDate> convert( String source ) {

        if ( StringUtils.isBlank( source ) ) {
            return Optional.empty();
        }

        return Optional.of( parse( source, formatter ) );
    }
}
