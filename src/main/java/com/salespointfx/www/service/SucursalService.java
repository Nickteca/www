package com.salespointfx.www.service;

import com.salespointfx.www.jpainterface.SucursalInterface;
import com.salespointfx.www.model.Sucursal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SucursalService {
    @Autowired
    private SucursalInterface si;
    
    public List<Sucursal> getAllSucursal(){
        return si.findAll();
    }
}
