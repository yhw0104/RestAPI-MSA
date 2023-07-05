package com.example.restfulwebservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
// 예외 처리를 위한 객체
public class ExceptionResponse {
    //예외 발생 시간
    private Date timeStamp;

    //예외 발생 시 메세지
    private String message;

    //예외 발생 시 상세 정보
    private String details;
}
