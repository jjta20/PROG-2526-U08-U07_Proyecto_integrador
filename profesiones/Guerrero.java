package profesiones;

// --- 3.1. PROFESIONES (clase concreta) ---

import habilidades.Atacante;
import entidades.Personaje;

public class Guerrero extends Personaje implements Atacante {
    
    public Guerrero(String nombre, int nivel) {
        super(nombre, nivel); // Deben recordar usar super()
    }

    @Override
    public void gritoBatalla() {
        System.out.println(getNombre() + " grita: ¡Por la alianza!");
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(getNombre() + " ataca ferozmente a " + objetivo.getNombre());
        objetivo.recibirDano(20);
    }
}