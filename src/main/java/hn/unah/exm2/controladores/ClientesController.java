package hn.unah.exm2.controladores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.exm2.modelos.Cliente;
import hn.unah.exm2.servicios.ClienteServicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/examen2")
public class ClientesController {
    
    @Autowired
    private ClienteServicio clientesService;

    @PostMapping("/crear")
    public Cliente crearCliente(@RequestBody Cliente nvoCliente) {
        
        return this.clientesService.crearCliente(nvoCliente);
    }

    @GetMapping("/obtener/todos")
    public List<Cliente> obtenerTodos() {
        return this.clientesService.obtenerTodos();
    }
    
    
}
