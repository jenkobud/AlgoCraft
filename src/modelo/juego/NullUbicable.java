package modelo.juego;

import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
import modelo.mapa.Ubicacion;

public class NullUbicable extends Ubicable {

    public NullUbicable(Ubicacion ubicacion) {
        super(ubicacion);
    }

    @Override
    public Ubicable guardarUbicable(Ubicable otroUbicable) {
        return otroUbicable;
    }

    @Override
    public Ubicable eliminarUbicable() {
        throw new NoSePuedeEliminarPorqueEstaVacioException("El casillero se encuentra vacío");
    }
}
