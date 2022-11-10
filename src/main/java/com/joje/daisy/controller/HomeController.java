package com.joje.daisy.controller;

import com.joje.daisy.model.vo.ResultVo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(value = "/test")
    public ResponseEntity<?> connected() throws Exception {

        ResultVo resultVo = new ResultVo();
        resultVo.put("Status", "Connected !!");

        return new ResponseEntity<>(resultVo, HttpStatus.OK);
    }

}
