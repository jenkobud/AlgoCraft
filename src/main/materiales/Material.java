package main.materiales;

import main.Estado;
import main.EstadoVivo;

public abstract class Material implements Desgastable {

    protected Estado estado;

    protected void reducirDurabilidad(int fuerza) {
        estado = estado.desgastar(fuerza);
    }

    public int getDurabilidad() {
        return this.estado.getDurabilidad();
    }
}
