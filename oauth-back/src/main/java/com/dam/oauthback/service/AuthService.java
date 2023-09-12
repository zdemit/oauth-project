package com.dam.oauthback.service;

import org.springframework.http.ResponseEntity;

import com.dam.oauthback.dto.request.auth.SignUpRequestDto;
import com.dam.oauthback.dto.response.auth.SignUpResponseDto;

public interface AuthService {

    ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);
}
