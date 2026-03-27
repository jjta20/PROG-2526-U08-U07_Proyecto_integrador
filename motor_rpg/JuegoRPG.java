package motor_rpg;

// --- 4. MOTOR DEL JUEGO (main) ---

import profesiones.Mago;
import profesiones.Guerrero;
import profesiones.Clerigo;
import entidades.Personaje;

public class JuegoRPG {
    public static void main(String[] args) {
        System.out.println("=== INICIANDO SIMULADOR RPG ===\n");

        Guerrero g1 = new Guerrero("Arthur", 10);
        Mago m1 = new Mago("Merlín", 6);
        Clerigo c1 = new Clerigo("Elara", 8);

        // Polimorfismo con Arrays
        Personaje[] batallon = {g1, m1, c1};

        System.out.println("--- GRITOS DE BATALLA ---");
        // Se recorre el array y se aprovecha el polimorfismo de la clase abstracta
        for (Personaje p : batallon) {
            p.gritoBatalla();
        }

        System.out.println("\n--- SIMULACIÓN DE COMBATE ---");
        // Guerrero ataca Mago
        g1.atacar(m1);
        
        // Clérigo cura Mago
        c1.curar(m1);
        
        // Método default heredado de la interfaz Paladin
        c1.proteger();
        
        System.out.println("\n=== FIN DE LA SIMULACIÓN ===");
    }
}