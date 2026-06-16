package com.lucasmanoel.bff_habitos.business;

import com.lucasmanoel.bff_habitos.business.in.RegisterUserRequest;
import com.lucasmanoel.bff_habitos.business.in.UsuarioLoginRequest;
import com.lucasmanoel.bff_habitos.business.in.UsuarioRequest;
import com.lucasmanoel.bff_habitos.business.out.LoginResponse;
import com.lucasmanoel.bff_habitos.business.out.RegisterUserResponse;
import com.lucasmanoel.bff_habitos.business.out.UsuarioResponse;
import com.lucasmanoel.bff_habitos.infrastructure.client.UsuarioClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioClient client;

    public RegisterUserResponse cadastraUsuario(RegisterUserRequest request){
        return client.cadastraUsuario(request);
    }

    public UsuarioResponse alteraUsuario(String token, UsuarioRequest request){
        return client.alteraUsuario(token, request);
    }

    public  UsuarioResponse buscaUsuarioPorEmail(String token, String email){
        return client.buscaUsuarioPorEmail(token, email);
    }

    public LoginResponse login (UsuarioLoginRequest request){
        return client.login(request);
    }

    public  void deletaUsuario( String token, String email){
        client.deletaUsuario(token, email);
    }
}
