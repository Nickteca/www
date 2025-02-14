package com.salespointfx.www.jpainterface;

import com.salespointfx.www.model.Sucursal;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SucursalInterface extends JpaRepository<Sucursal, Short>{
    Optional<Sucursal> findByEstatusSucursalTrue();
}
