package org.example.hogwarts.controller;

import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.service.HogwartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/hogwarts/estudiantes")
public class EstudianteController {

    @Autowired
    private HogwartsService service;

    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAll(){
        List<EstudianteDto> estudiantes = service.listarEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }
}