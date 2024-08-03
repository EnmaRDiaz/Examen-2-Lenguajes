package hn.unah.exm2.modelos;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="prestamos")
@Data
public class Prestamos {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codigoprestamo")
    private Long codigoPrestamo;
    @Column(name="fechaapertura")
    private LocalDate fechaApertura;
    private float monto;
    private float cuota;
    private int plazo;
    private float interes;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="dni")
    private Cliente cliente;
//hola
    @JsonIgnore
    @OneToMany(mappedBy = "prestamos")
    private List<Cuota> cuotas;

}
