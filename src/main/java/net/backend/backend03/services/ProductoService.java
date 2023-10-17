package net.backend.backend03.services;

import java.util.List;
import java.util.Optional;

import net.backend.backend03.entitys.Producto;
import net.backend.backend03.interfaces.OperacionesInterface;
import net.backend.backend03.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Daniel Arias
 */
@Service("ProductoService")
public class ProductoService implements OperacionesInterface<Producto> {

    @Autowired
    private ProductoRepository repositoryProducto;

    @Override
    public List<Producto> consultar() {
        return repositoryProducto.obtenerTodos();
    }

    @Override
    public Boolean agregar(Producto miObjeto) {
        Producto producto = repositoryProducto.save(miObjeto);
        return producto != null;
    }

    @Override
    public Long cantidadRegistros() {
        return repositoryProducto.count();
    }

    @Override
    public Boolean eliminar(Long llavePrimaria) {
        repositoryProducto.deleteById(llavePrimaria);
        return !repositoryProducto.existsById(llavePrimaria);
    }

    @Override
    public Boolean actualizar(Producto miObjeto) {
        Optional<Producto> productoTemporal = repositoryProducto.findById(miObjeto.getId());
        if (productoTemporal.isPresent()) {
            repositoryProducto.save(miObjeto);
            return true;
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Te quedo algo mal en el JSON");
        }
    }

    @Override
    public Producto buscar(Long llavePrimaria) {
        return repositoryProducto.findById(llavePrimaria).get();
    }
}
