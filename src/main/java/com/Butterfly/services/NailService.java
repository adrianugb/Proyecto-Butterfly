package com.Butterfly.services;

import com.Butterfly.domain.Nail;
import java.util.List;

public interface NailService {
    
    // Se recuperan los registros de la tabla nails en un 
    // ArrayList de objetos Nail.
    // Todos o sólo los activos
    
    public List<Nail> getNail(boolean activos);
    
    public Nail getNail(Nail nail);
    
    public void delete(Nail nail);
    
    public void save(Nail nail);
    
    // Se utiliza la consulta1... consulta ampliada
    public List<Nail> consulta1(double precioInf, double precioSup);
    
    // Se utiliza la consulta2... consulta JPQL
    public List<Nail> consulta2(double precioInf, double precioSup);
    
    // Se utiliza la consulta3... consulta SQL
    public List<Nail> consulta3(double precioInf, double precioSup);
}
