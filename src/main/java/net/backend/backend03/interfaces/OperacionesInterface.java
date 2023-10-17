package net.backend.backend03.interfaces;

import java.util.List;

/**
 *
 * @author Daniel Arias
 */
public interface OperacionesInterface<T> {
    public List<T> consultar();

    public Boolean agregar(T miObjeto);

    public Long cantidadRegistros();

    public Boolean eliminar(Long llavePrimaria);

    public Boolean actualizar(T miObjeto);

    public T buscar(Long llavePrimaria);
}
