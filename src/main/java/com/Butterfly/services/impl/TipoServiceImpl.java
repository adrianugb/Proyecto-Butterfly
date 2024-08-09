package com.Butterfly.services.impl;

import com.Butterfly.dao.TipoDao;
import com.Butterfly.domain.Tipo;
import com.Butterfly.services.TipoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoServiceImpl implements TipoService {

    @Autowired
    private TipoDao tipoDao;
    
    @Override
    public List<Tipo> getTipo(boolean activos) {
        var lista = tipoDao.findAll();
        
        if (activos) { // si solo quiero activos
            lista.removeIf(t -> !t.isActivo());
        }
        
        return lista;
    }

    @Override
    public Tipo getTipo(Tipo tipo) {
        return tipoDao.findById(tipo.getIdTipo()).orElse(null);
    }

    @Override
    public void delete(Tipo tipo) {
        tipoDao.delete(tipo);
    }

    @Override
    public void save(Tipo tipo) {
        tipoDao.save(tipo);
    }
}
