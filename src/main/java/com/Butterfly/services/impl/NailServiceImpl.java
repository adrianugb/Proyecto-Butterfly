package com.Butterfly.services.impl;

import com.Butterfly.dao.NailDao;
import com.Butterfly.domain.Nail;
import com.Butterfly.services.NailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NailServiceImpl implements NailService {

    @Autowired
    private NailDao nailDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Nail> getNail(boolean activos) {
        var lista = nailDao.findAll();
        
        if (activos) { // si solo quiero activos
            lista.removeIf(c -> !c.isActivo());
        }
        
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Nail getNail(Nail nail) {
        return nailDao.findById(nail.getIdNail()).orElse(null);
    }

    @Override
    @Transactional
    public void delete(Nail nail) {
        nailDao.delete(nail);
    }

    @Override
    @Transactional
    public void save(Nail nail) {
        nailDao.save(nail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Nail> consulta1(double precioInf, double precioSup) {
        return nailDao.findByPrecioBetweenOrderByDescripcion(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Nail> consulta2(double precioInf, double precioSup) {
        return nailDao.consulta2(precioInf, precioSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Nail> consulta3(double precioInf, double precioSup) {
        return nailDao.consulta3(precioInf, precioSup);
    }
}
