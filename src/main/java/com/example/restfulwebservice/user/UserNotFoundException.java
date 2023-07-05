package com.example.restfulwebservice.user;


// 2XX -> OK
// 4XX -> Client error(존재하지 않는 리소스, 권한을 가지고 있지 않을 때, 제공하지 않는 메소드 호출 시)
// 5XX -> Server error(서버측 오류, 서버가 사용하지 않는 리소스 오류)

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//리소스가 존재하지 않을 때
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
