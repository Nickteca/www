package com.salespointfx.www.viewcontroller;

import com.salespointfx.www.model.Sucursal;
import com.salespointfx.www.service.SucursalService;
import jakarta.annotation.PostConstruct;
import java.awt.event.ActionEvent;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleccionarSucursalController {
    
    @Autowired
    private SucursalService ss;
    
    private ObservableList<Sucursal> sucursales = FXCollections.observableArrayList(); 
   

    public void init() {
        sucursales.addAll(ss.getAllSucursal());
    }
    
    public ObservableList<Sucursal> getSucursales() {
        return sucursales;
    }
    public void sucursalSeleccionada(Sucursal sucursal){
        // Lógica para seleccionar una sucursal (puedes guardarla en un servicio compartido)
        System.out.println("Sucursal seleccionada: " + sucursal.getNombreSucursal());
    }
    
    
}
