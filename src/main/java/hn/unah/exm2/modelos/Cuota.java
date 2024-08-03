package hn.unah.exm2.modelos;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "cuotas")
@Data
public class Cuota {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="codigocuota")
    private Long codigoCuota;

    private int mes;
    private float interes;
    private float capital;
    private float saldo;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigoprestamo")
    private Prestamos prestamos;
}
