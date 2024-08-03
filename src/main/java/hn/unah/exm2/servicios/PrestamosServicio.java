package hn.unah.exm2.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.exm2.modelos.Prestamos;
import hn.unah.exm2.repositorios.PrestamosRepositorio;

@Service
public class PrestamosServicio {
    @Autowired
    private PrestamosRepositorio prestamosRepositorio;

    public Prestamos devolverPorCodigo(long codigo){
        return prestamosRepositorio.findById(codigo).get();
    }
}
