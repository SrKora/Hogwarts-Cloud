package org.example.hogwarts.service.impl;

import org.example.hogwarts.repository.AsignaturaRepository;
import org.example.hogwarts.service.AsignaturaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    private final AsignaturaRepository asignaturaRepo;

    public AsignaturaServiceImpl(AsignaturaRepository asignaturaRepo) {
        this.asignaturaRepo = asignaturaRepo;
    }

    @Override
    @Transactional
    public void eliminarAsignatura(Long id) {
        if (!asignaturaRepo.existsById(id)) {
            throw new NoSuchElementException("No se puede borrar: Asignatura no encontrada");
        }
        asignaturaRepo.deleteById(id);
    }
}