package modelo.herramientas;

import modelo.herramientas.ConstructorPico;
import modelo.herramientas.Pico;
import modelo.materiales.Madera;
import modelo.materiales.Metal;
import modelo.materiales.Piedra;
import org.junit.Test;

import static modelo.juego.ConstantesJuego.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PicoMaderaTests {
    @Test
    public void testCrearPicoDeMaderaConDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        assertThat(picoMadera.getDurabilidad(), is(100));
    }

    @Test
    public void testCrearPicoDeMaderaConFuerza() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        assertThat(picoMadera.getFuerza() , is(2));
    }

    @Test
    public void testPicoDeMaderaSeUsaContraMaderaReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Madera madera = new Madera();
        picoMadera.usar(madera);
        assertThat(picoMadera.getDurabilidad(), is (98));
    }
    @Test
    public void testPicoDeMaderaSeUsaContraPiedraReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Piedra piedra = new Piedra();
        picoMadera.usar(piedra);
        assertThat(picoMadera.getDurabilidad(), is (98));


    }
    @Test
    public void testPicoDeMaderaSeUsaContraMetalReduceSuDurabilidad() {
        ConstructorPico constructor = new ConstructorPico();
        constructor
                .conMaterial(new Madera())
                .conDurabilidad(DURABILIDAD_PICO_MADERA)
                .conDesgaste(DESGASTE_PICO_MADERA)
                .conFuerza(FUERZA_PICO_MADERA);
        Pico picoMadera = constructor.construir();
        Metal metal = new Metal();
        picoMadera.usar(metal);
        assertThat(picoMadera.getDurabilidad(), is (98));

    }
}
