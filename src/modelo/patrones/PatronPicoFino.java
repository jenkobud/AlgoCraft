package modelo.patrones;

import modelo.mapa.Ubicacion;
import modelo.materiales.Material;
import static modelo.juego.ConstantesJuego.MATERIAL_MANGO;
import static modelo.juego.ConstantesJuego.MATERIAL_PUNTA_PICO_FINO;

public class PatronPicoFino extends Patron {
    public PatronPicoFino(Material material) {
        this.inicializarPatron(material);
    }

    public void inicializarPatron(Material material) {
        this.colocarMango(MATERIAL_MANGO);
        this.colocarCabeza(material);
        this.colocarPunta(MATERIAL_PUNTA_PICO_FINO);
    }

    public void colocarCabeza(Material material) {
        Ubicacion ubicacionA = new Ubicacion(1, 1);
        Ubicacion ubicacionB = new Ubicacion(2, 1);
        Ubicacion ubicacionC = new Ubicacion(3, 1);
        this.tablero.ubicarEnCasillero(material, ubicacionA);
        this.tablero.ubicarEnCasillero(material, ubicacionB);
        this.tablero.ubicarEnCasillero(material, ubicacionC);
    }
    public void colocarPunta(Material material) {
        Ubicacion ubicacion = new Ubicacion(1, 2);
        this.tablero.ubicarEnCasillero(material, ubicacion);
    }
}
