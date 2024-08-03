package hn.unah.exm2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.exm2.modelos.Cliente;
import hn.unah.exm2.modelos.Prestamos;
import hn.unah.exm2.repositorios.ClienteRepositorio;
import hn.unah.exm2.repositorios.PrestamosRepositorio;

@Service
public class PrestamosServicio {
    @Autowired
    private PrestamosRepositorio prestamosRepositorio;

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired
    private ClienteServicio clienteServicio;

    public Prestamos devolverPorCodigo(long codigo){
        return prestamosRepositorio.findById(codigo).get();
    }

    public Prestamos crearPrestamo(String dni, Prestamos nvoPrestamo){
        Cliente cliente = this.clienteRepositorio.findById(dni).get();
        if(verificarPrestamos(dni)){
            List<Prestamos> prestamos = cliente.getPrestamos();
            float cuota = clienteServicio.calcularCuota(nvoPrestamo.getMonto(), nvoPrestamo.getPlazo());
            nvoPrestamo.setCuota(cuota);
            prestamos.add(nvoPrestamo);
            cliente.setPrestamos(prestamos);
            this.clienteRepositorio.save(cliente);
            return nvoPrestamo;
        }
        return null;
    }

    public boolean verificarPrestamos(String dni){
        Cliente cliente = this.clienteRepositorio.findById(dni).get();
        List<Prestamos> prestamos = cliente.getPrestamos();
        if(prestamos.size()>2){
            return false;
        }
        return true;
    }
}
