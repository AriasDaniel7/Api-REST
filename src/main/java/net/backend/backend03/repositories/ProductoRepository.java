package net.backend.backend03.repositories;

import net.backend.backend03.entitys.Producto;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Daniel Arias
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
    
    @Query("SELECT p FROM Producto p")
    public List<Producto> obtenerTodos();
}
