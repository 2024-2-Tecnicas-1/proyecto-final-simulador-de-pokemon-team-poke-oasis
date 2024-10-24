package simulador;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;
import simulador.batalla.Batalla;
public class Principal
{
    private static List<Entrenador> entrenadores = new ArrayList<>();
    private static List<Pokemon> pokemones = new ArrayList<>();
    
    
    public static void main(String[] args) 
    {
     
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        while (!salir) 
        {
            System.out.println("\nSimulador de Batallas Pokémon");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) 
            {
                case 1:
                    gestionarEntrenadores(scanner);
                    break;
                case 2:
                    gestionarPokemones(scanner);
                    break;
                case 3:
                    iniciarBatalla(scanner); 
                    break;
                case 4:
                    salir = true;
                    System.out.println("¡Gracias por usar el simulador de batallas Pokémon!");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
            }
        }
    }

    // Submenú para gestionar entrenadores
    private static void gestionarEntrenadores(Scanner scanner)
    {
        boolean volver = false;
        while (!volver)
        {
            System.out.println("\nGestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) 
            {
                case 1:
                    registrarNuevoEntrenador(scanner);
                    break;
                case 2:
                    verListaDeEntrenadores();
                    break;
                case 3:
                    seleccionarEntrenador(scanner);
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del submenú.");
            }
        }
    }
        // Registrar un nuevo entrenador
    private static void registrarNuevoEntrenador(Scanner scanner) 
    {
        System.out.print("Ingresa el nombre del nuevo entrenador: ");
        String nombre = scanner.nextLine();
        Entrenador nuevoEntrenador = new Entrenador(nombre);
        entrenadores.add(nuevoEntrenador);
        System.out.println("Entrenador " + nombre + " registrado exitosamente.");
    }
    
        // Mostrar la lista de entrenadores
    private static void verListaDeEntrenadores() 
    {
        if (entrenadores.isEmpty()) 
        {
            System.out.println("No hay entrenadores registrados.");
        } 
        else 
        {
            System.out.println("Lista de Entrenadores:");
            for (int i = 0; i < entrenadores.size(); i++) 
            {
                System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
            }
        }
    }
    
       // Seleccionar un entrenador y gestionar su equipo
    private static void seleccionarEntrenador(Scanner scanner) 
    {
        verListaDeEntrenadores();
        System.out.print("Selecciona un entrenador por su número: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (index < 1 || index > entrenadores.size())
        {
            System.out.println("Selección no válida.");
            return;
        }

        Entrenador entrenadorSeleccionado = entrenadores.get(index - 1);
        gestionarEquipoEntrenador(scanner, entrenadorSeleccionado);
    }
    
        // Submenú para gestionar el equipo de un entrenador específico
    private static void gestionarEquipoEntrenador(Scanner scanner, Entrenador entrenador)
    {
        boolean volver = false;
        while (!volver) 
        {
            System.out.println("\n" + entrenador.getNombre() + " - Gestionar Equipo");
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a Gestionar Entrenadores");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) 
            {
                case 1:
                    entrenador.mostrarPokemones();
                    break;
                case 2:
                    agregarPokemonAEntrenador(scanner, entrenador);
                    break;
                case 3:
                    entrenarPokemon(scanner, entrenador);
                    break;
                case 4:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción del submenú.");
            }
        }
    }
    
       // Agregar un Pokémon al equipo del entrenador
    private static void agregarPokemonAEntrenador(Scanner scanner, Entrenador entrenador)
    {
        if (pokemones.isEmpty()) 
        {
            System.out.println("No hay Pokémones disponibles para agregar.");
            return;
        }

        System.out.println("Pokémones disponibles:");
        for (int i = 0; i < pokemones.size(); i++)
        {
            System.out.println((i + 1) + ". " + pokemones.get(i).getNombre());
        }

        System.out.print("Selecciona un Pokémon para agregar: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (index < 1 || index > pokemones.size())
        {
            System.out.println("Selección no válida.");
        }
        else 
        {
            Pokemon pokemonSeleccionado = pokemones.get(index - 1);
            if (entrenador.getPokemones().contains(pokemonSeleccionado)) 
            {
                System.out.println("El Pokémon " + pokemonSeleccionado.getNombre() + " ya está en el equipo de " + entrenador.getNombre() + ".");
            } 
            else 
            {
                entrenador.agregarPokemon(pokemonSeleccionado);
            }
        }
    }
    
    
        private static void entrenarPokemon(Scanner scanner, Entrenador entrenador) 
    {
        if (entrenador.getPokemones().isEmpty())
        {
            System.out.println("El entrenador " + entrenador.getNombre() + " no tiene Pokémones para entrenar.");
            return;
        }

        entrenador.mostrarPokemones(); // Muestra el equipo de Pokémon del entrenador.

        System.out.print("Selecciona el número del Pokémon que deseas entrenar: ");
        int index = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (index < 1 || index > entrenador.getPokemones().size()) 
        {
            System.out.println("Selección no válida. No se puede entrenar el Pokémon seleccionado.");
            return;
        }

        Pokemon pokemonSeleccionado = entrenador.getPokemones().get(index - 1); // Obtiene el Pokémon seleccionado.
        entrenador.entrenarPokemon(pokemonSeleccionado); // Entrena al Pokémon seleccionado.
    }
        
        
     private static void gestionarPokemones(Scanner scanner) 
     {
        int opcion;

        do 
        {
            System.out.println("\nGestionar Pokémones");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();

            switch (opcion)
                {
                    case 1:
                        verListaPokemones();
                        break;
                    case 2:
                        registrarPokemon(scanner);
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
        } while (opcion != 3); 
     }
     
     
    private static void verListaPokemones()
    {
        if (pokemones.isEmpty())
        {
        System.out.println("No hay Pokémones registrados.");
        } 
    else
        {
            System.out.println("Lista de Pokémones:");
            for (int i = 0; i < pokemones.size(); i++) 
            {
                Pokemon p = pokemones.get(i);
                System.out.println((i + 1) + ". " + p.getNombre() + " (Tipo: " + p.getTipo() + ", Salud: " + p.getSalud() + ", Ataque: " + p.getPuntosDeAtaque() + ")");
            }
        }
           
    }
         
        private static void registrarPokemon(Scanner scanner) 
        {
            System.out.println("\nRegistrar nuevo Pokémon");

            // Solicitar nombre del Pokémon
            System.out.print("Ingresa el nombre del Pokémon: ");
            String nombre = scanner.nextLine();
            scanner.nextLine();
            // Solicitar salud del Pokémon
            System.out.print("Ingresa la salud del Pokémon: ");
            int salud = scanner.nextInt();

            // Solicitar puntos de ataque del Pokémon
            System.out.print("Ingresa los puntos de ataque del Pokémon: ");
            int puntosDeAtaque = scanner.nextInt();

            // Elegir el tipo de Pokémon de una lista
            System.out.println("Selecciona el tipo del Pokémon:");
            for (int i = 0; i < TipoPokemon.values().length; i++) 
                {
                    System.out.println((i + 1) + ". " + TipoPokemon.values()[i]);
                }

            int tipoIndex;
            do 
                {
                    System.out.print("Elige el número correspondiente al tipo: ");
                    tipoIndex = scanner.nextInt() - 1;
                } 
            while (tipoIndex < 0 || tipoIndex >= TipoPokemon.values().length);
            scanner.nextLine(); // Consumir la línea después del entero

            TipoPokemon tipo = TipoPokemon.values()[tipoIndex];

            // Crear el nuevo Pokémon
            Pokemon nuevoPokemon = new Pokemon(nombre, salud, puntosDeAtaque, tipo, "Normal");
            pokemones.add(nuevoPokemon);

            System.out.println("¡Pokémon " + nombre + " registrado exitosamente con el tipo " + tipo + "!");
        }
         
         
    // Método para iniciar la batalla
private static void iniciarBatalla(Scanner scanner) {
    if (entrenadores.size() < 2) {
        System.out.println("No hay suficientes entrenadores para iniciar una batalla. Registra más entrenadores.");
        return;
    }

    // Variables para almacenar los entrenadores y Pokémon seleccionados
    Entrenador entrenador1 = null;
    Entrenador entrenador2 = null;
    Pokemon pokemon1 = null;
    Pokemon pokemon2 = null;

    boolean volver = false;
    while (!volver) {
        System.out.println("\nIniciar Batalla");
        System.out.println("1. Elegir entrenador 1");
        System.out.println("2. Elegir entrenador 2");
        System.out.println("3. Seleccionar Pokémon de entrenador 1");
        System.out.println("4. Seleccionar Pokémon de entrenador 2");
        System.out.println("5. Comenzar batalla");
        System.out.println("6. Volver al menú principal");
        System.out.print("Elige una opción: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        switch (opcion) {
            case 1:
                System.out.println("Selecciona el Entrenador 1:");
                entrenador1 = seleccionarrEntrenador(scanner);
                break;
            case 2:
                System.out.println("Selecciona el Entrenador 2:");
                entrenador2 = seleccionarrEntrenador(scanner);
                break;
            case 3:
                if (entrenador1 != null) {
                    pokemon1 = seleccionarPokemon(entrenador1, scanner);
                } else {
                    System.out.println("Primero debes elegir el Entrenador 1.");
                }
                break;
            case 4:
                if (entrenador2 != null) {
                    pokemon2 = seleccionarPokemon(entrenador2, scanner);
                } else {
                    System.out.println("Primero debes elegir el Entrenador 2.");
                }
                break;
            case 5:
                if (pokemon1 != null && pokemon2 != null) {
                    batalla(pokemon1, pokemon2);
                } else {
                    System.out.println("Ambos Pokémon deben ser seleccionados antes de comenzar la batalla.");
                }
                break;
            case 6:
                volver = true;
                break;
            default:
                System.out.println("Opción no válida. Por favor, selecciona una opción del menú.");
        }
    }
}


    // Método para seleccionar un entrenador
    private static Entrenador seleccionarrEntrenador(Scanner scanner) {
    if (entrenadores.isEmpty()) {
        System.out.println("No hay entrenadores disponibles.");
        return null;
    }

    System.out.println("Selecciona un entrenador:");
    for (int i = 0; i < entrenadores.size(); i++) {
        System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
    }
    System.out.print("Elige un entrenador (número): ");
    
    int seleccion = scanner.nextInt();
    scanner.nextLine(); // Consumir la nueva línea

    if (seleccion > 0 && seleccion <= entrenadores.size()) {
        Entrenador entrenadorSeleccionado = entrenadores.get(seleccion - 1);
        System.out.println("Has seleccionado a " + entrenadorSeleccionado.getNombre() + ".");
        return entrenadorSeleccionado;
    } else {
        System.out.println("Selección inválida.");
        return null;
    }
}


    // Método para seleccionar Pokémon de un entrenador
    private static Pokemon seleccionarPokemon(Entrenador entrenador, Scanner scanner) {
        List<Pokemon> equipo = entrenador.getPokemones();
        if (equipo.isEmpty()) {
            System.out.println("El equipo de " + entrenador.getNombre() + " está vacío.");
            return null;
        }

        System.out.println("Selecciona un Pokémon de " + entrenador.getNombre() + ":");
        for (int i = 0; i < equipo.size(); i++) {
            System.out.println((i + 1) + ". " + equipo.get(i).getNombre());
        }
        System.out.print("Elige un Pokémon (número): ");
        int seleccion = scanner.nextInt();
        scanner.nextLine(); // Consumir la nueva línea

        if (seleccion > 0 && seleccion <= equipo.size()) {
            return equipo.get(seleccion - 1);
        } else {
            System.out.println("Selección inválida.");
            return null;
        }
    }

    // Método para realizar la batalla entre dos Pokémon
// Método para realizar la batalla entre dos Pokémon
// Método para realizar la batalla entre dos Pokémon
private static void batalla(Pokemon pokemon1, Pokemon pokemon2) {
    // Crear una instancia de Batalla
    Batalla batalla = new Batalla();

    // Crear dos entrenadores temporales para la batalla
    Entrenador entrenador1 = new Entrenador("Entrenador 1");
    Entrenador entrenador2 = new Entrenador("Entrenador 2");

    // Agregar los Pokémon seleccionados a los entrenadores
    entrenador1.agregarPokemon(pokemon1);
    entrenador2.agregarPokemon(pokemon2);

    // Iniciar la batalla usando la clase Batalla
    batalla.iniciarBatalla(entrenador1, entrenador2);
}


// Método para mostrar el estado actual de los Pokémon después de un ataque
private static void mostrarEstadoPokemon(Pokemon pokemon1, Pokemon pokemon2) {
    System.out.println("\nEstado actual después del ataque:");
    System.out.println(pokemon1.getNombre() + " - Salud: " + pokemon1.getSalud() + ", Ataque: " + pokemon1.getPuntosDeAtaque());
    System.out.println(pokemon2.getNombre() + " - Salud: " + pokemon2.getSalud() + ", Ataque: " + pokemon2.getPuntosDeAtaque());
}


}

