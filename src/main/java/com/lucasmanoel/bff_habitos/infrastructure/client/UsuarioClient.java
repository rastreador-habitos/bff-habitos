package com.lucasmanoel.bff_habitos.infrastructure.client;

import com.lucasmanoel.bff_habitos.business.in.RegisterUserRequest;
import com.lucasmanoel.bff_habitos.business.in.UsuarioLoginRequest;
import com.lucasmanoel.bff_habitos.business.in.UsuarioRequest;
import com.lucasmanoel.bff_habitos.business.out.LoginResponse;
import com.lucasmanoel.bff_habitos.business.out.RegisterUserResponse;
import com.lucasmanoel.bff_habitos.business.out.UsuarioResponse;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "usuario", url = "${usuario.url}")
public interface UsuarioClient {

    @PostMapping
    RegisterUserResponse cadastraUsuario(@RequestBody RegisterUserRequest request);

    @PutMapping
    UsuarioResponse alteraUsuario(@RequestHeader("Authorization") String token,@Valid @RequestBody UsuarioRequest request);

    @GetMapping
    UsuarioResponse buscaUsuarioPorEmail(@RequestHeader("Authorization") String token, @RequestParam String email);

    @PostMapping("/login")
    LoginResponse login (@RequestBody UsuarioLoginRequest request);

    @DeleteMapping("/{habitosID}")
    void deletaUsuario(@RequestHeader("Authorization") String token, @PathVariable String email);


}
