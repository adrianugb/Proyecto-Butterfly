package com.Butterfly.services;

import com.Butterfly.domain.Tipo;
import java.util.List;

public interface TipoService {
    
    
    public List<Tipo> getTipo(boolean activos);
    
    public Tipo getTipo(Tipo tipo);
    
    public void delete(Tipo tipo);
    
    public void save(Tipo tipo);
    
}
