package com.joje.daisy.controller;

import com.joje.daisy.common.security.JwtTokenProvider;
import com.joje.daisy.model.dto.auth.SignonDto;
import com.joje.daisy.model.dto.auth.SignupDto;
import com.joje.daisy.model.dto.auth.TokenDto;
import com.joje.daisy.model.dto.auth.UserDto;
import com.joje.daisy.model.vo.ResultVo;
import com.joje.daisy.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtTokenProvider jwtTokenProvider;
    /**
     * 아이디 중복 체크
     */
    @GetMapping("/duple/{userId}")
    public ResponseEntity<?> idDuplicateCheck(@PathVariable("userId") String userId) throws Exception {
        ResultVo resultVo = new ResultVo();
        resultVo.put("isValid", authService.idDuplicateCheck(userId));
        return new ResponseEntity<>(resultVo, HttpStatus.OK);
    }

    /**
     * 회원 가입
     */
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody SignupDto param) throws  Exception {
        UserDto userDto = authService.signup(param);

        ResultVo resultVo = new ResultVo();
        resultVo.put("user", userDto);

        return new ResponseEntity<>(resultVo, HttpStatus.OK);
    }

    /**
     * 로그인
     */
    @PostMapping("/signin")
    public ResponseEntity<?> signin(@RequestBody SignonDto param) throws Exception {

        TokenDto tokenResponseDto = authService.signin(param);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(JwtTokenProvider.AUTHORIZATION_HEADER, "Bearer " + tokenResponseDto.getAccessToken());

//        결과셋
        ResultVo resultVo = new ResultVo();
        resultVo.put("accessToken", tokenResponseDto.getAccessToken());
        resultVo.put("refreshToken", tokenResponseDto.getRefreshToken());

        return new ResponseEntity<>(resultVo, httpHeaders, HttpStatus.OK);
    }


    @PostMapping("/refresh")
    public ResponseEntity<?> tokenRefresh(@RequestBody TokenDto param) throws Exception {

        TokenDto tokenDto = authService.relayToken(param);

        ResultVo resultVo = new ResultVo();
        resultVo.put("token", tokenDto);

        return new ResponseEntity<>(resultVo, HttpStatus.OK);
    }

    @PostMapping("/signout")
    public ResponseEntity<?> signout(@RequestBody TokenDto param) throws Exception {
        authService.signout(param);
        return new ResponseEntity<>(new ResultVo(), HttpStatus.OK);
    }

}
