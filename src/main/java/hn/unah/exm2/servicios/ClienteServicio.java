package hn.unah.exm2.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.exm2.modelos.Cliente;
import hn.unah.exm2.modelos.Prestamos;
import hn.unah.exm2.repositorios.ClienteRepositorio;
import hn.unah.exm2.repositorios.PrestamosRepositorio;

@Service
public class ClienteServicio {
    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Autowired 
    private PrestamosRepositorio prestamosRepositorio;

    public Cliente crearCliente(Cliente nvoCliente){

        if (!comprobarExistencia(nvoCliente.getDni())){
            Cliente guardarCliente = nvoCliente;
            List<Prestamos> obtenerPrestamos = nvoCliente.getPrestamos();
            
            for (Prestamos prestamos : obtenerPrestamos) {
                float calcular = calcularCuota(prestamos.getMonto(), prestamos.getPlazo());
                prestamos.setCuota(calcular);
                prestamos.setCliente(guardarCliente);
            }
            guardarCliente.setDni(nvoCliente.getDni());
            guardarCliente.setNombre(nvoCliente.getNombre());
            guardarCliente.setApellido(nvoCliente.getApellido());
            guardarCliente.setTelefono(nvoCliente.getTelefono());
            return this.clienteRepositorio.save(guardarCliente);
        }
        return null;
    } 

    public List<Cliente> obtenerTodos(){
        return this.clienteRepositorio.findAll();
    }

    public boolean comprobarExistencia (String dni){
        return this.clienteRepositorio.existsById(dni);
    }

    public float calcularCuota(float monto, int plazo){
        float interes = 0.09f;
        double cuota = (monto*interes*Math.pow(1+interes, plazo))/Math.pow(1+interes, plazo);
        float total = (float) cuota;
        return total;
    }
    
}
