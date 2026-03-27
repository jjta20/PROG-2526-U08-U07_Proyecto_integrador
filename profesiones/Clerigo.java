package profesiones;

// --- 3.3. PROFESIONES (clase concreta) ---

import habilidades.Paladin;
import entidades.Personaje;

public class Clerigo extends Personaje implements Paladin {
    
    public Clerigo(String nombre, int nivel) {
        super(nombre, nivel);
    }

    @Override
    public void gritoBatalla() {
        System.out.println(getNombre() + " grita: ¡La luz me guía!");
    }

    @Override
    public void atacar(Personaje objetivo) {
        System.out.println(getNombre() + " golpea con su maza a " + objetivo.getNombre());
        objetivo.recibirDano(10);
    }

    @Override
    public void curar(Personaje objetivo) {
        System.out.println(getNombre() + " lanza un hechizo sanador sobre " + objetivo.getNombre());
        objetivo.recibirCura(20);
    }
}