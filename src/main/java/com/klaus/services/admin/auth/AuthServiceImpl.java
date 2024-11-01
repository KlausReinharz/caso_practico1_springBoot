package com.klaus.services.admin.auth;

import com.klaus.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{

    private final UserRepository userRepository;
/*
    public Optional<Integer> obtenerIntentosFallidos(String userName){
        return this.userRepository.ObtenerIntentosFallidos(userName);
    }

    public boolean estaBloqueado(String userName){
        Optional<Byte> bloqueado = this.userRepository.estaBloqueado(userName);
        return bloqueado.orElse((byte)0)==1;
    }

    public void incrementarIntentosFallidos(String userName){
        this.userRepository.incrementarIntentosFallidos(userName);
    }

    public void bloquearUsuario(String userName){
        this.userRepository.bloquearUsuario(userName);
    }

 */



}
