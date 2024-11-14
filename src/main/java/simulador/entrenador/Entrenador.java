package simulador.entrenador;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.pokemon.Pokemon;

public class Entrenador {
    private String nombre;
    private List<Pokemon> listapokemon;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.listapokemon = new ArrayList<>();
    }

    public void agregarPokemon(Pokemon pokemon) {
        this.listapokemon.add(pokemon);
        System.out.println(pokemon.getNombre() + " ha sido añadido al equipo de " + nombre + ".");
    }

    public void entrenarPokemon(Pokemon pokemon) {
        if (listapokemon.contains(pokemon)) {
            pokemon.entrenar();
            System.out.println(nombre + " entrenó a " + pokemon.getNombre() + ".");
        } else {
            System.out.println("El Pokémon " + pokemon.getNombre() + " no pertenece al equipo de " + nombre + ".");
        }
    }

    public void mostrarPokemones() {
        if (listapokemon.isEmpty()) {
            System.out.println(nombre + " no tiene Pokémones en su equipo.");
        } else {
            System.out.println("Pokémones de " + nombre + ":");
            for (Pokemon p : listapokemon) {
                System.out.println("- " + p.getNombre() + " (Tipo: " + p.getTipo() + ", Salud: " + p.getSalud() + ", Ataque: " + p.getPuntosDeAtaque() + ")");
            }
        }
    }

    public Pokemon prepararBatalla() {
        if (listapokemon.isEmpty()) {
            System.out.println("No hay Pokémones disponibles para la batalla.");
            return null;
        }

        mostrarPokemones();

        System.out.println("Selecciona el número del Pokémon para la batalla:");
        Scanner scanner = new Scanner(System.in);
        
        int index = -1;
        while (true) {
            try {
                index = scanner.nextInt();
                if (index >= 1 && index <= listapokemon.size()) {
                    break;
                } else {
                    System.out.println("Selección inválida. Por favor, selecciona un número válido.");
                }
            } catch (Exception e) {
                System.out.println("Entrada no válida. Por favor, ingresa un número.");
                scanner.next(); 
            }
        }

        Pokemon pokemonSeleccionado = listapokemon.get(index - 1);
        System.out.println("¡" + nombre + " ha seleccionado a " + pokemonSeleccionado.getNombre() + " para la batalla!");
        return pokemonSeleccionado;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pokemon> getPokemones() {
        return listapokemon;
    }
}
