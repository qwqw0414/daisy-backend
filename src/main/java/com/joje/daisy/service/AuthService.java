package com.joje.daisy.service;

import com.joje.daisy.model.dto.auth.SignonDto;
import com.joje.daisy.model.dto.auth.SignupDto;
import com.joje.daisy.model.dto.auth.TokenDto;
import com.joje.daisy.model.dto.auth.UserDto;

import javax.transaction.Transactional;

public interface AuthService {
    boolean idDuplicateCheck(String userId);

    @Transactional
    UserDto signup(SignupDto param);

    UserDto getUser(String userId);

    TokenDto signin(SignonDto param);

    @Transactional
    void signout(TokenDto param);

    @Transactional
    TokenDto relayToken(TokenDto param);
}
