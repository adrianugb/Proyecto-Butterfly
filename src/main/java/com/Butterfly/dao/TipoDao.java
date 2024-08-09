package com.Butterfly.dao;

import com.Butterfly.domain.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoDao 
        extends JpaRepository<Tipo,Long>{
    
    
}
