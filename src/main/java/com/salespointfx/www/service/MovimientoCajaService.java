package com.salespointfx.www.service;

import com.salespointfx.www.jpainterface.MovimientoCajaInterface;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoCajaService {
    @Autowired
    private MovimientoCajaInterface mci;
    
    public void getMovimientoCajaActive(){
    }
}
