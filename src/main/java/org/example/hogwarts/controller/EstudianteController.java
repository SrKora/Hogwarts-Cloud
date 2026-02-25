package org.example.hogwarts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.hogwarts.dtos.request.create.EstudianteCreateDto;
import org.example.hogwarts.dtos.request.update.EstudianteUpdateDto;
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

    @Operation(summary = "Obtener todos los estudiantes", description = "Retorna una lista con todos los estudiantes registrados en Hogwarts")
    @ApiResponse(responseCode = "200", description = "Lista de estudiantes obtenida con éxito")
    @GetMapping
    public ResponseEntity<List<EstudianteDto>> getAll() {
        List<EstudianteDto> estudiantes = service.obtenerTodosLosEstudiantes();
        return ResponseEntity.ok(estudiantes);
    }

    @Operation(summary = "Obtener un estudiante por ID", description = "Busca y retorna los detalles de un estudiante específico")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante encontrado"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<EstudianteDto> estudiante(@PathVariable Long id) {
        EstudianteDto estudiante = service.obtenerEstudiantePorId(id);
        return ResponseEntity.ok(estudiante);
    }

    @Operation(summary = "Crear un nuevo estudiante", description = "Registra un nuevo estudiante en la base de datos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Estudiante creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    })
    @PostMapping
    public ResponseEntity<EstudianteDto> createEstudiante(@Valid @RequestBody EstudianteCreateDto createDto) {
        EstudianteDto estudianteCreado = service.crearEstudiante(createDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(estudianteCreado);
    }

    @Operation(summary = "Actualizar un estudiante", description = "Modifica los datos de un estudiante existente")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "No se pudo encontrar el estudiante para actualizar"),
            @ApiResponse(responseCode = "400", description = "Datos de actualización inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDto> actualizarEstudiante(@PathVariable Long id,
            @Valid @RequestBody EstudianteUpdateDto udto) {
        EstudianteDto estudianteActualizado = service.actualizarEstudiante(id, udto);
        return ResponseEntity.ok(estudianteActualizado);
    }

    @Operation(summary = "Eliminar un estudiante", description = "Borra físicamente el registro de un estudiante mediante su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Estudiante eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "No se encontró el estudiante a eliminar")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminiarEstudiante(@PathVariable Long id) {
        service.eliminarEstudiante(id);
        return ResponseEntity.noContent().build();
    }

    @ExceptionHandler(java.util.NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElement(java.util.NoSuchElementException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}