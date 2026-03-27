package profesiones;

// --- 3.2. PROFESIONES (clase concreta) ---

import habilidades.Atacante;
import entidades.Personaje;

public class Mago extends Personaje implements Atacante {
    
    public Mago(String nombre, int nivel) {
        super(nombre, nivel);
    }

    @Override
    public void gritoBatalla() {
        System.out.println(getNombre() + " grita: ¡Fuego y destrucción!");
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(getNombre() + " lanza una bola de fuego a " + objetivo.getNombre());
        if (this.nivel > 5) {
            objetivo.recibirDano(30);
        } else {
            objetivo.recibirDano(10);
        }
    }
}