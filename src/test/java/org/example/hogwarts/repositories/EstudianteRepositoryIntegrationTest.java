package org.example.hogwarts.repositories;

import jakarta.persistence.EntityManager;
import org.example.hogwarts.model.CasaModel;
import org.example.hogwarts.model.EstudianteModel;
import org.example.hogwarts.model.MascotaModel;
import org.example.hogwarts.repository.EstudianteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
class EstudianteRepositoryIntegrationTest {
    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private EntityManager entityManager;

    @Test
    void eliminarEstudiante_DebeEliminarMascotaEnCascada() {
        EstudianteModel estudiante = new EstudianteModel();
        estudiante.setNombre("test_adfsads");
        estudiante.setApellido("test_adfsads");
        estudiante.setAnyo_curso(10);
        estudiante.setFecha_nacimiento(java.time.LocalDate.now());
        estudiante.setAsignaturas(null);
        estudiante.setCasa(entityManager.find(CasaModel.class, 1L));

        MascotaModel mascota = new MascotaModel();
        mascota.setNombre("test_adfsads");
        mascota.setEspecie("test_adfsads");
        mascota.setEstudiante(estudiante);
        estudiante.setMascota(mascota);

        EstudianteModel guardado = estudianteRepo.save(estudiante);
        Long idMascota = guardado.getMascota().getId();

        estudianteRepo.deleteById(guardado.getIdEstudiante());
        estudianteRepo.flush();
        entityManager.clear();

        assertFalse(estudianteRepo.findById(guardado.getIdEstudiante()).isPresent());

        MascotaModel mascotaBorrada = entityManager.find(MascotaModel.class, idMascota);
        assertNull(mascotaBorrada, "La mascota debería haber sido borrada por cascada de JPA");
    }
}
