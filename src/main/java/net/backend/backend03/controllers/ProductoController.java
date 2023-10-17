package net.backend.backend03.controllers;

import java.util.List;
import net.backend.backend03.entitys.Producto;
import net.backend.backend03.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Daniel Arias
 */
@RestController
@RequestMapping("/api/producto")
@CrossOrigin(origins = "*")
public class ProductoController {

    @Autowired
    private ProductoService serviceProducto;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Producto> obtenerTodos() {
        return serviceProducto.consultar();
    }

    @ResponseStatus(HttpStatus.CREATED)
    // @RequestMapping(value = "/crear", method = RequestMethod.POST, consumes =
    // "application/json")
    @PostMapping(value = "/crear", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Producto> guardar(@RequestBody Producto producto) {
        if (serviceProducto.agregar(producto)) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @ResponseStatus(code = HttpStatus.OK, reason = "Producto eliminado correctamente")
    // @RequestMapping(value = "/eliminar/{id}", method = RequestMethod.DELETE)
    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        serviceProducto.eliminar(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/buscar/{id}")
    public Producto obtenerProducto(@PathVariable Long id) {
        return serviceProducto.buscar(id);
    }

    @ResponseStatus(code = HttpStatus.ACCEPTED, reason = "Producto actualizado correctamente")
    // @RequestMapping(value = "/actualizar", method = RequestMethod.PUT)
    @PutMapping("/actualizar")
    public Boolean actualizar(@RequestBody Producto producto) {
        return serviceProducto.actualizar(producto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/cantidad")
    public Long cantidadRegistros() {
        return serviceProducto.cantidadRegistros();
    }

}
