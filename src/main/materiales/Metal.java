package main.materiales;

import main.EstadoVivo;
import main.herramientas.PicoPiedra;

public class Metal extends Material {

    private static final int DURABILIDAD_METAL = 50;
    public Metal() {
        this.estado = new EstadoVivo(DURABILIDAD_METAL);
    }

    @Override
    public void desgastar(PicoPiedra pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }
}
