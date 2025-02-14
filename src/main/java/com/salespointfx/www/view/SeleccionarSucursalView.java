package com.salespointfx.www.view;

import com.salespointfx.www.component.SpringFXMLLoader;
import com.salespointfx.www.model.Sucursal;
import com.salespointfx.www.viewcontroller.SeleccionarSucursalController;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleccionarSucursalView implements Initializable {

    @Autowired
    private SeleccionarSucursalController ssc;

    @Autowired
    private SpringFXMLLoader springFXMLLoader;

    @FXML
    private Button btnSeleccionarSucursal;

    @FXML
    private ListView<Sucursal> listViewsucursales;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listViewsucursales.setItems(ssc.getSucursales());
        ssc.init();
    }

    public Parent load() throws IOException {
        Parent root = springFXMLLoader.load("/fxml/seleccionarsucursal.fxml").load();
        return root;
    }

    @FXML
    void seleccionarSucursal(ActionEvent event) {
        System.out.println(event.getSource());
        Sucursal sucursalSeleccionada = listViewsucursales.getSelectionModel().getSelectedItem();
        if (sucursalSeleccionada != null) {
            ssc.sucursalSeleccionada(sucursalSeleccionada);
            Stage stage = (Stage) btnSeleccionarSucursal.getScene().getWindow();
            stage.close();
        }
    }

}
