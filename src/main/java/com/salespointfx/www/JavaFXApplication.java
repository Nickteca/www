package com.salespointfx.www;

import com.salespointfx.www.component.SpringFXMLLoader;
import com.salespointfx.www.view.SeleccionarSucursalView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFXApplication extends Application {

    private ConfigurableApplicationContext springContext;
    private SpringFXMLLoader springFXMLLoader;
    private SeleccionarSucursalView ssv;

    @Override
    public void init() throws Exception {
        // Inicializa Spring Boot
        springContext = SpringApplication.run(SalespointFxNetbeans1Application.class);
        // Obtén el bean de SpringFXMLLoader
        springFXMLLoader = springContext.getBean(SpringFXMLLoader.class);
        //cargamos este chow aqui
        ssv = springContext.getBean(SeleccionarSucursalView.class);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent selectBranchRoot = ssv.load();
        Stage selectBranchStage = new Stage();
        selectBranchStage.setScene(new Scene(selectBranchRoot, 400, 300));
        selectBranchStage.showAndWait(); // Espera a que se seleccione una sucursal
    

    ///primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
