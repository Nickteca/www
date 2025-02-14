package com.salespointfx.www.jpainterface;

import com.salespointfx.www.model.MovimientoCaja;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoCajaInterface extends JpaRepository<MovimientoCaja, Integer>{
    Optional<MovimientoCaja> findBySucursalIdSucursalAndTipoMovimientoCaja="A"();
}
