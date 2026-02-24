package org.example.hogwarts.repositories;

import jakarta.persistence.EntityManager;
import org.example.hogwarts.model.CasaModel;
import org.example.hogwarts.model.EstudianteModel;
import org.example.hogwarts.model.MascotaModel;
import org.example.hogwarts.repository.EstudianteRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@Testcontainers
@TestPropertySource(properties = { "spring.jpa.hibernate.ddl-auto=create-drop" })
@Disabled("Docker not available in environment")
public class EstudianteRepositoryContainersTest {
    @Container
    @ServiceConnection
    static PostgreSQLContainer postgres = new PostgreSQLContainer("postgres:17.6-alpine");

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudiante_DebeEliminarMascotaEnCascada_RealDB() {
        EstudianteModel estudiante = new EstudianteModel();
        estudiante.setNombre("test");
        estudiante.setApellido("test");
        estudiante.setAnyo_curso(10);
        estudiante.setFecha_nacimiento(java.time.LocalDate.now());
        estudiante.setAsignaturas(null);
        estudiante.setCasa(entityManager.find(CasaModel.class, 1L));

        MascotaModel mascota = new MascotaModel();
        mascota.setNombre("test");
        mascota.setEspecie("test");
        mascota.setEstudiante(estudiante);
        estudiante.setMascota(mascota);

        EstudianteModel guardado = estudianteRepo.save(estudiante);
        Long idMascota = guardado.getMascota().getId();

        estudianteRepo.deleteById(guardado.getIdEstudiante());
        estudianteRepo.flush();
        entityManager.clear();

        assertFalse(estudianteRepo.findById(guardado.getIdEstudiante()).isPresent());

        MascotaModel mascotaBorrada = entityManager.find(MascotaModel.class, idMascota);
        assertNull(mascotaBorrada, "La mascota debería haber sido borrada por cascada en Postgres");
    }
}
