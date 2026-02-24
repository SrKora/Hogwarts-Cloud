package org.example.hogwarts.controller;

import org.example.hogwarts.service.AsignaturaService;
import org.example.hogwarts.service.impl.AsignaturaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hogwarts/asignaturas")
public class AsignaturaController {
    private final AsignaturaService asignaturaService; // Inject Interface

    @Autowired
    public AsignaturaController(AsignaturaService asignaturaService) {
        this.asignaturaService = asignaturaService;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        asignaturaService.eliminarAsignatura(id);
        return ResponseEntity.noContent().build(); // 204 No Content on success
    }
}