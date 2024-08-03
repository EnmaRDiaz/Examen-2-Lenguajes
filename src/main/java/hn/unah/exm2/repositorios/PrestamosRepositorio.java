package hn.unah.exm2.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hn.unah.exm2.modelos.Prestamos;

@Repository
public interface PrestamosRepositorio extends JpaRepository<Prestamos, Long>{
    
}
