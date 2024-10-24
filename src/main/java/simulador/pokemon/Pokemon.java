package simulador.pokemon;


public class Pokemon {

    private String nombre;
    private int salud;
    private int PuntosDeAtaque;
    private TipoPokemon tipo;
    private String estado;

    public Pokemon(String nombre, int salud, int PuntosDeAtaque, TipoPokemon tipo, String estado) {
        this.nombre = nombre;
        this.salud = salud;
        this.PuntosDeAtaque = PuntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }

    public void atacar(Pokemon oponente) {
        System.out.println(this.nombre + " ataca a " + oponente.getNombre() + " causando " + this.PuntosDeAtaque + " puntos de daño!");

        // Reducir la salud del oponente en función del ataque
        oponente.recibirDaño(this.PuntosDeAtaque, this.tipo);
    }

    public void recibirDaño(int daño, TipoPokemon tipoAtacante) {
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(tipoAtacante, this.tipo);
        int valorADisminuir = (int) (daño * multiplicador);

        System.out.println(this.nombre + " recibió un ataque del tipo " + tipoAtacante + " y restó " + valorADisminuir + " puntos de vida");
        this.salud -= valorADisminuir;

        // Evitar que la salud sea negativa
        if (this.salud <= 0) {
            this.salud = 0;
            System.out.println(this.nombre + " ha sido derrotado.");
        } else {
            System.out.println("Salud restante de " + this.nombre + ": " + this.salud);
        }
    }

    public void entrenar() {
        System.out.println(this.nombre + " entrenó exitosamente.");
        this.PuntosDeAtaque += 2;
        this.salud += 2;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntosDeAtaque() {
        return PuntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setSalud(int nuevaSalud) {
        this.salud = nuevaSalud;
    }
}

