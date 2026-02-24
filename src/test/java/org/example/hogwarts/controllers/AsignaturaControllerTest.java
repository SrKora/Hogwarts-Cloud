package org.example.hogwarts.controllers;
import org.example.hogwarts.controller.AsignaturaController;
import org.example.hogwarts.service.AsignaturaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.dao.DataIntegrityViolationException; // O la excepción que uses
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.Mockito.doThrow;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@WebMvcTest(AsignaturaController.class)
public class AsignaturaControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockitoBean
    private AsignaturaService asignaturaService;
    @Test
    void eliminarAsignatura_ConEstudiantes_DebeFallar() throws Exception {
        // Simulamos que el servicio lanza una excepción porque hay alumnos
        doThrow(new DataIntegrityViolationException("No se puede eliminar asignatura con estudiantes"))
                .when(asignaturaService).eliminarAsignatura(1L);
        mockMvc.perform(delete("/hogwarts/asignaturas/1"))
                .andExpect(status().isConflict());
    }
}