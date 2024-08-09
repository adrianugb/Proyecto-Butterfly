package com.Butterfly.dao;

import com.Butterfly.domain.Nail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NailDao
        extends JpaRepository<Nail, Long> {
 
    // Se define una consulta ampliada considerando los atributos
    public List<Nail> findByPrecioBetweenOrderByDescripcion(
            double precioInf, double precioSup);
 
    // Se define la misma consulta pero en sintaxis JPQL
    @Query(value = "SELECT a FROM Nail a "
            + "WHERE a.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Nail> consulta2(double precioInf, double precioSup);
 
    // Se define la misma consulta pero en sintaxis SQL
    @Query(nativeQuery = true, value= "SELECT * FROM Nail a "
            + "WHERE a.precio BETWEEN :precioInf AND :precioSup "
            + "ORDER BY a.descripcion ASC")
    public List<Nail> consulta3(double precioInf, double precioSup);
 
}
