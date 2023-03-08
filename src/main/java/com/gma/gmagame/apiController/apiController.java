package com.gma.gmagame.apiController;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class apiController {
        //여기 뭔지 모르겟음 저장하는건가 흠
//    @GetMapping("/login/success")
//    public ResponseEntity notSesstion() {
//        log.info("로그인 성공");
//        Map<String, Object> map = new HashMap<>();
//        map.put("result", 1);
//        return new ResponseEntity(map, HttpStatus.OK);
//    }
//
//    @GetMapping("/login/fail")
//    public ResponseEntity hello() {
//        log.info("로그인 실패");
//        Map<String, Object> map = new HashMap<>();
//        map.put("result", 0);
//        return new ResponseEntity(map, HttpStatus.OK);
//    }

}
