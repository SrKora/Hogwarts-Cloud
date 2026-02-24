package org.example.hogwarts.services;

import org.example.hogwarts.model.EstudianteModel;
import org.example.hogwarts.model.MascotaModel;
import org.example.hogwarts.repository.EstudianteRepository;
import org.example.hogwarts.service.impl.EstudianteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EstudianteServiceTest {
    @Mock
    private EstudianteRepository estudianteRepo;

    @InjectMocks
    private EstudianteServiceImpl service;

    private EstudianteModel estudianteTest;

    @BeforeEach
    void setUp() {
        estudianteTest = new EstudianteModel();
        estudianteTest.setIdEstudiante(1L);
        estudianteTest.setNombre("test");
        estudianteTest.setApellido("test");
        estudianteTest.setAnyo_curso(10);
        estudianteTest.setFecha_nacimiento(java.time.LocalDate.now());
        estudianteTest.setMascota(null);
        estudianteTest.setAsignaturas(null);
        estudianteTest.setCasa(null);
    }

    @Test
    void eliminarEstudiante_Exito_SinMascota() {
        Long id = 1L;

        when(estudianteRepo.existsById(id)).thenReturn(true);

        service.eliminarEstudiante(id);

        verify(estudianteRepo).deleteById(id);
    }
}