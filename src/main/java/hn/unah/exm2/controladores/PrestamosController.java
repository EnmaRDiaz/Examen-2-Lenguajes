package hn.unah.exm2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.exm2.modelos.Prestamos;
import hn.unah.exm2.servicios.PrestamosServicio;



@RestController
@RequestMapping("/api/prestamos")
public class PrestamosController {
    
    @Autowired
    private PrestamosServicio prestamosServicio;

    @GetMapping("/obtener/{codigoPrestamo}")
    public Prestamos obtenerPrestamo(@PathVariable long codigoPrestamo) {
        return this.prestamosServicio.devolverPorCodigo(codigoPrestamo);
    }
    
    @PostMapping("/crear/{dni}")
    public Prestamos crearPrestamos(@PathVariable String dni,@RequestBody Prestamos prestamos) {        
        return this.prestamosServicio.crearPrestamo(dni, prestamos);
    }
    
}
