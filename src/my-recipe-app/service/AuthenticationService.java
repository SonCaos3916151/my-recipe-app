package com.soncao.myrecipeapp.service;

import com.soncao.myrecipeapp.auth.AuthenticationRequest;
import com.soncao.myrecipeapp.auth.AuthenticationResponse;
import com.soncao.myrecipeapp.auth.RegisterRequest;
import com.soncao.myrecipeapp.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface AuthenticationService {
    AuthenticationResponse register(RegisterRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);

    void saveUserToken(User user, String jwtToken);

    void revokeAllUserTokens(User user);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
