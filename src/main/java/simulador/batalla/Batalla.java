package simulador.batalla;

import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;

public class Batalla 
{
   
    
    public void iniciarBatalla(Entrenador entrenador1, Entrenador entrenador2) 
    {
        System.out.println("¡Batalla entre entrenadores " + entrenador1.getNombre() + " y " + entrenador2.getNombre() + " está por comenzar!");
        System.out.println("------------------------------------------------");

        
        Pokemon pokemonDeEntrenador1 = entrenador1.prepararBatalla();
        Pokemon pokemonDeEntrenador2 = entrenador2.prepararBatalla();

        
        if (pokemonDeEntrenador1 == null || pokemonDeEntrenador2 == null) {
            System.out.println("La batalla no puede continuar ya que uno de los entrenadores no seleccionó un Pokémon válido.");
            return;
        }

        System.out.println("¡La batalla entre " + pokemonDeEntrenador1.getNombre() + " y " + pokemonDeEntrenador2.getNombre() + " ha comenzado!");
        System.out.println("------------------------------------------------");

        
        mostrarEstado(pokemonDeEntrenador1);
        mostrarEstado(pokemonDeEntrenador2);

        
        while (pokemonDeEntrenador1.getSalud() > 0 && pokemonDeEntrenador2.getSalud() > 0) {
            
            realizarAtaque(pokemonDeEntrenador1, pokemonDeEntrenador2);
            if (pokemonDeEntrenador2.getSalud() <= 0) {
                System.out.println(pokemonDeEntrenador2.getNombre() + " ha sido derrotado.");
                System.out.println("¡" + pokemonDeEntrenador1.getNombre() + " gana la batalla para " + entrenador1.getNombre() + "!");
                break;
            }

            
            realizarAtaque(pokemonDeEntrenador2, pokemonDeEntrenador1);
            if (pokemonDeEntrenador1.getSalud() <= 0) {
                System.out.println(pokemonDeEntrenador1.getNombre() + " ha sido derrotado.");
                System.out.println("¡" + pokemonDeEntrenador2.getNombre() + " gana la batalla para " + entrenador2.getNombre() + "!");
                break;
            }
        }

        System.out.println("------------------------------------------------");
        System.out.println("La batalla ha terminado.");
    }

    // Método para mostrar el estado de un Pokémon (Nombre, Tipo, Salud y Ataque)
    private void mostrarEstado(Pokemon pokemon) {
        System.out.println(pokemon.getNombre() + " (Tipo: " + pokemon.getTipo() + ") - Salud: " + pokemon.getSalud() + ", Ataque: " + pokemon.getPuntosDeAtaque());
    }

    // Método para que un Pokémon realice un ataque a otro
// Método para que un Pokémon realice un ataque a otro
// Método para que un Pokémon realice un ataque a otro
private void realizarAtaque(Pokemon atacante, Pokemon defensor) {
    System.out.println(atacante.getNombre() + " ha atacado a " + defensor.getNombre() + "!");
    
    // El atacante realiza su ataque y causa daño al defensor
    atacante.atacar(defensor);
    
    // Mostrar el estado del defensor después del ataque
    System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + " causando " + atacante.getPuntosDeAtaque() + " puntos de daño!");
    System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getSalud() + " puntos de salud.");

    // Mostrar el estado actualizado de ambos Pokémon
    System.out.println("Estado actual después del ataque:");
    mostrarEstado(atacante);
    mostrarEstado(defensor);
}

    
}
