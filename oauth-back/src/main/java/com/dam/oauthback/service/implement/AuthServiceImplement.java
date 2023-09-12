package com.dam.oauthback.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dam.oauthback.dto.request.auth.SignUpRequestDto;
import com.dam.oauthback.dto.response.ResponseDto;
import com.dam.oauthback.dto.response.auth.SignUpResponseDto;
import com.dam.oauthback.entity.UserEntity;
import com.dam.oauthback.repository.UserRepository;
import com.dam.oauthback.service.AuthService;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class AuthServiceImplement implements AuthService {

    private final UserRepository UserRepository;

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {  
        
        String id = dto.getId();

        try {

            boolean hasId = UserRepository.existsById(id);
            if(hasId) return SignUpResponseDto.existedId();

            UserEntity userEntity = new UserEntity(dto);
            UserRepository.save(userEntity);

        } catch(Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }

        return SignUpResponseDto.success();
    }
    
}
