package com.daftar.daftar;

import com.daftar.daftar.service.DiaryNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler
    @ResponseStatus(NOT_FOUND)
    private void diaryNotFoundException( DiaryNotFoundException e ) {

    }

}
