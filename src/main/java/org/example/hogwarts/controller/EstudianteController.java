package org.example.hogwarts.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dtos.request.create.EstudianteCreateDto;
import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.service.impl.EstudianteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/hogwarts/estudiantes")
public class EstudianteController {

    @Autowired
    private EstudianteServiceImpl service;

    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAll(){
        List<EstudianteDto> estudiantes = service.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }
    @PostMapping
    public ResponseEntity<EstudianteDto> createEstudiante(@Valid @RequestBody EstudianteCreateDto createDto){
        EstudianteDto estudianteCreado = service.crearEstudiante(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }
}