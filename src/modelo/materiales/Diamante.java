package modelo.materiales;

import modelo.juego.Ubicable;
import modelo.estados.EstadoVivo;
import modelo.herramientas.PicoFino;

import java.util.Objects;
import java.util.Optional;

public class Diamante extends Material {

    public static final int DURABILIDAD_DIAMANTE = 100;
    public Diamante() {
        this.estado = new EstadoVivo(DURABILIDAD_DIAMANTE);
    }

/*    @Override
    public void desgastar(PicoFino pico) {
        int fuerza = pico.getFuerza();
        this.reducirDurabilidad(fuerza);
    }*/

    @Override
    public Optional<Desgastable> desgastarContra(Desgastable desgastable){ return desgastable.desgastarContra(this);}
    @Override
    public Optional<Desgastable> desgastarContra(PicoFino pico){ return pico.desgastarContra(this); }


    public boolean esIgualAUbicable(Ubicable ubicable) {/*
        if(this.getClass() != ubicable.getClass()) return false;
        Diamante diamante = (Diamante) ubicable;
        if(this.getDurabilidad() != diamante.getDurabilidad()) return false;
        return true;
        */
        return (this.getClass() == ubicable.getClass());

    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getClass());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this.getClass() != obj.getClass()) return false;
        /*Diamante diamante = (Diamante) obj;
        if (this.getDurabilidad() != diamante.getDurabilidad()) return false;*/
        return true;
    }
}