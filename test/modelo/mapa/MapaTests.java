package modelo.mapa;

import modelo.exceptions.NoSePuedeUbicarPorqueEstaOcupadoException;
import modelo.exceptions.NoSePuedeEliminarPorqueEstaVacioException;
import modelo.juego.ObjetoUbicable;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class MapaTests {
    @Test (expected = NoSePuedeUbicarPorqueEstaOcupadoException.class)
    public void testMapaUbicarEnUnCasilleroOcupadoLanzaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        Ubicacion ubicacion = new Ubicacion(4,4);
        mapa.ubicarEnCasillero(new ObjetoUbicable(null), ubicacion);
        mapa.ubicarEnCasillero(new ObjetoUbicable(null), ubicacion);

    }

    @Test (expected = NoSePuedeEliminarPorqueEstaVacioException.class)
    public void testMapaEliminarDeCasilleroVacioLAnzaExcepcion(){
        Mapa mapa = new Mapa(10,10);
        mapa.eliminarDeCasillero(new Ubicacion(4,4));
    }

    @Test
    public void testMapaVacioEsIgualAMapaVacioConElMismoTamanioEsTrue(){
        Mapa mapa = new Mapa(10,10);
        Mapa otroMapa = new Mapa(10,10);
        assertTrue(mapa.esIgualA(otroMapa));
    }

    @Test
    public void testMapaVacioEsIgualAMapaVacioConTamanioDiferenteEsFalse(){
        Mapa mapa = new Mapa(10,10);
        Mapa otroMapa = new Mapa(8,10);
        assertFalse(mapa.esIgualA(otroMapa));
    }
/*
    @Test
    public void testMapaEsIgualAMapaVacioConMismoTamanioEsFalse(){
        Mapa mapa = new Mapa(10,10);
        mapa.ubicarEnCasilleroAleatorio(new ObjetoUbicable());
        Mapa otroMapa = new Mapa(10,10);
        assertFalse(mapa.esIgualA(otroMapa));
    }

    @Test
    public void testMapaEsIgualAMapaVacioConTamanioDiferenteEsFalse(){
        Mapa mapa = new Mapa(10,10);
        mapa.ubicarEnCasilleroAleatorio(new ObjetoUbicable());
        Mapa otroMapa = new Mapa(8,10);
        assertFalse(mapa.esIgualA(otroMapa));
    }
*/
    @Test
    public void testMapaEsIgualAMapaConDiferentesCasillerosOcupadosConMismoTamanioEsFalse(){
        Mapa mapa = new Mapa(10,10);
        mapa.ubicarEnCasillero(new ObjetoUbicable(null), new Ubicacion(4,4));
        Mapa otroMapa = new Mapa(10,10);
        otroMapa.ubicarEnCasillero(new ObjetoUbicable(null), new Ubicacion(4,3));
        assertFalse(mapa.esIgualA(otroMapa));
    }

}
