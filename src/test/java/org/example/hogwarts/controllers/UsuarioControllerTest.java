package org.example.hogwarts.controllers;

import org.example.hogwarts.controller.EstudianteController;
import org.example.hogwarts.dtos.request.create.EstudianteCreateDto;
import org.example.hogwarts.dtos.request.create.MascotaCreateDto;
import org.example.hogwarts.dtos.response.EstudianteDto;
import org.example.hogwarts.service.EstudianteService;
import org.example.hogwarts.service.impl.EstudianteServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@WebMvcTest(EstudianteController.class)
public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EstudianteServiceImpl service;

    @Autowired
    private ObjectMapper objectMapper;

    private EstudianteCreateDto estudianteCreateDto;
    private EstudianteDto estudianteDto;
    @Autowired
    private EstudianteService estudianteService;

    @BeforeEach
    void setUp() {
        MascotaCreateDto mascotaDto = new MascotaCreateDto();
        mascotaDto.setNombre("controller_test");
        mascotaDto.setEspecie("controller_test");

        estudianteCreateDto = new EstudianteCreateDto();
        estudianteCreateDto.setNombre("controller_test");
        estudianteCreateDto.setApellido("controller_test");
        estudianteCreateDto.setAnyoCurso(10);
        estudianteCreateDto.setFechaNacimiento(java.time.LocalDate.now().minusYears(1));
        estudianteCreateDto.setCasaId(1);
        estudianteCreateDto.setMascota(mascotaDto);

        estudianteDto = new EstudianteDto();
        estudianteDto.setId(1L);
        estudianteDto.setNombre("controller_test");
    }

    @Test
    void crearEstudianteYMascota_Exito() throws Exception {
        when(service.crearEstudiante(any(EstudianteCreateDto.class))).thenReturn(estudianteDto);

        mockMvc.perform(post("/hogwarts/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estudianteCreateDto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.nombre").value("controller_test"));
        verify(estudianteService).crearEstudiante(any(EstudianteCreateDto.class));
    }

    @Test
    void crearEstudiante_Invalido() throws Exception {
        estudianteCreateDto.setNombre(""); // Invalid name to trigger 400

        mockMvc.perform(post("/hogwarts/estudiantes")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(estudianteCreateDto)))
                .andExpect(status().isBadRequest());

        verify(estudianteService, never()).crearEstudiante(any());
    }

    @Test
    void eliminarEstudiante_DebeRetornar204() throws Exception {
        mockMvc.perform(delete("/hogwarts/estudiantes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void crearEstudiante_AnyoCursoInvalido() throws Exception {
        estudianteCreateDto.setAnyoCurso(10); // Valor inválido

        mockMvc.perform(post("/hogwarts/estudiantes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(estudianteCreateDto)))
                .andExpect(status().isBadRequest()); // Esperamos 400

        verify(estudianteService, never()).crearEstudiante(any());
    }
}
