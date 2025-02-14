package com.salespointfx.www;

import com.salespointfx.www.component.SpringFXMLLoader;
import com.salespointfx.www.model.Sucursal;
import com.salespointfx.www.service.MovimientoCajaService;
import com.salespointfx.www.service.SucursalService;
import com.salespointfx.www.view.AbrirCajaView;
import com.salespointfx.www.view.SeleccionarSucursalView;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private SpringFXMLLoader springFXMLLoader;
    private SeleccionarSucursalView ssv;
    private AbrirCajaView acv;
    private SucursalService ss;
    private MovimientoCajaService mcs;

    @Override
    public void init() throws Exception {
        // Inicializa Spring Boot
        springContext = SpringApplication.run(SalespointFxNetbeans1Application.class);
        // Obtén el bean de SpringFXMLLoader
        springFXMLLoader = springContext.getBean(SpringFXMLLoader.class);
        //CONM ESTE CARGAMOS EL BEAN YA QUE EL @AUTOWIRED NO FUNCIONA
        ss = springContext.getBean(SucursalService.class);
        //CARGAMOS EL CONTROLADOR DE LA VISTA QUE QUEREMOS USAR
        ssv = springContext.getBean(SeleccionarSucursalView.class);
        //CARGAMOS EL VIEW A ACV(COM EL CONTROLADOR PERO ES EL VIEW)
        acv = springContext.getBean(AbrirCajaView.class);
        //
        mcs = springContext.getBean(MovimientoCajaService.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (ss.getsucursalActive().isEmpty()) {
            Parent selectBranchRoot = ssv.load();
            Stage selectBranchStage = new Stage();
            selectBranchStage.setScene(new Scene(selectBranchRoot, 400, 300));
            selectBranchStage.showAndWait(); // Espera a que se seleccione una sucursal
        } else {
            
            //LE MANDAMOS LA SUCURSAL AL  METODO DE EL VIEW
            acv.setSucursalActiva(ss.getsucursalActive().get());
            //ABRIMOS O CARGAMOS LA VISTA
            Parent abrirCaja = acv.load();
            Stage abrirCajaSatge = new Stage();
            abrirCajaSatge.setScene(new Scene(abrirCaja, 512, 400));
            abrirCajaSatge.setResizable(false);
            abrirCajaSatge.showAndWait(); // Espera a que se seleccione una sucursal
        }
    

    ///primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
