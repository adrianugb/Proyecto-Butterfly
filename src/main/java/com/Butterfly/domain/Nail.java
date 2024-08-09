package com.Butterfly.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data
@Entity
@Table(name="nail")  // Cambiado de "producto" a "nail"
public class Nail implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_nail")  // Cambiado de "id_producto" a "id_nail"
    private Long idNail;  // Cambiado de "idProducto" a "idNail"
    
    private String descripcion;
    private String detalle;
    private double precio;
    private int existencias;
    private String rutaImagen;
    private boolean activo;
    
    @ManyToOne
    @JoinColumn(name="id_tipo")  // Cambiado de "id_categoria" a "id_tipo"
    private Tipo tipo;  // Cambiado de "Categoria" a "Tipo"
}
