package com.example.demo.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UsuarioEntity;
import com.example.demo.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {

}
