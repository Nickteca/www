package com.salespointfx.www.view;

import com.salespointfx.www.component.SpringFXMLLoader;
import com.salespointfx.www.model.Sucursal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AbrirCajaView implements Initializable {
    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    @FXML
    private Label labelSubtitulo;

    @FXML
    private Label labelTitulo;

    @FXML
    private TextField textEfectivo;
    
    private Sucursal sa;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelTitulo.setText(this.sa.getNombreSucursal());
    }
    // Método para recibir la sucursal activa
    public void setSucursalActiva(Sucursal sucursalActiva) {
        this.sa = sucursalActiva;
    }
    public Parent load() throws IOException {
        Parent root = springFXMLLoader.load("/fxml/abrircaja.fxml").load();
        return root;
    }
}