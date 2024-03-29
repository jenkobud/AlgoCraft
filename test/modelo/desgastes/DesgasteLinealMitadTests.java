package modelo.desgastes;

import modelo.estados.EstadoMuerto;
import modelo.estados.EstadoVivo;
import modelo.estrategias.DesgasteLinealFactor;
import modelo.exceptions.HerramientaRotaNoPuedeDesgastarseException;
import modelo.exceptions.NoSePuedeDesgastarUnElementoConEstadoMuertoException;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DesgasteLinealMitadTests {
    @Test
    public void testDesgasteLinealMitadDesgastaEstadoVivoSegunMitadDeFuerza(){
        DesgasteLinealFactor desgasteLinealMitad = new DesgasteLinealFactor(0.5);
        EstadoVivo estadoVivo = new EstadoVivo(10);
        Integer durabilidadEstado = estadoVivo.getDurabilidad();
        desgasteLinealMitad.desgastar(2, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 1));
        desgasteLinealMitad.desgastar(4, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 3));
        desgasteLinealMitad.desgastar(4, estadoVivo);
        assertThat(estadoVivo.getDurabilidad(), is(durabilidadEstado - 5));

    }

    @Test
    public void testDesgasteLinealMitadDevuelveEstadoVivoHastaQueNoHayaDurabilidadDeEstado(){
        DesgasteLinealFactor desgasteLinealMitad = new DesgasteLinealFactor(0.5);
        EstadoVivo estadoVivo = new EstadoVivo(8);
        assertThat(desgasteLinealMitad.desgastar(8, estadoVivo), is(estadoVivo));
        assertThat(desgasteLinealMitad.desgastar(4, estadoVivo), is(estadoVivo));
        assertNotEquals(estadoVivo, desgasteLinealMitad.desgastar(8, estadoVivo));
    }

    @Test (expected = NoSePuedeDesgastarUnElementoConEstadoMuertoException.class)
    public void testDesgasteLinealMitadLanzaExcepcionAlDesgastarEstadoMuerto(){
        DesgasteLinealFactor desgasteLinealMitad = new DesgasteLinealFactor(0.5);
        EstadoMuerto estadoMuerto = new EstadoMuerto();
        desgasteLinealMitad.desgastar(1, estadoMuerto);
    }
}
