package simulador.pokemon;

public enum TipoPokemon {
    
    FUEGO,
    AGUA,
    PLANTA,
    VENENO,
    ELECTRICO,
    PSIQUICO,
    ROCA,
    TIERRA,
    NORMAL,
    VOLADOR,
    HADA,
    LUCHA,
    ACERO,
    BICHO,
    HIELO,
    FANTASMA;


    public static double obtenerMultiplicadorDeDaño(TipoPokemon atacante, TipoPokemon defensor) {
       
    switch (atacante) {
    case FUEGO:
                if (defensor == PLANTA || defensor == HIELO || defensor == BICHO || defensor == ACERO) return 2.0;
                if (defensor == FUEGO || defensor == AGUA || defensor == ROCA ) return 0.5;
                break;
    case AGUA:
                if (defensor == FUEGO || defensor == ROCA || defensor == TIERRA) return 2.0;
                if (defensor == AGUA || defensor == PLANTA ) return 0.5;
                break;
    case PLANTA:
                if (defensor == AGUA || defensor == ROCA || defensor == TIERRA) return 2.0;
                if (defensor == FUEGO || defensor == PLANTA || defensor == VENENO || defensor == VOLADOR || defensor == BICHO || defensor == ACERO) return 0.5;
                break;
    case VENENO:
                if (defensor == PLANTA || defensor == HADA) return 2.0;
                if (defensor == VENENO || defensor == TIERRA || defensor == ROCA || defensor == FANTASMA) return 0.5;
                if (defensor == ACERO) return 0.0; 
                break;
    case ELECTRICO:
                if (defensor == AGUA || defensor == VOLADOR) return 2.0;
                if (defensor == ELECTRICO || defensor == PLANTA ) return 0.5;
                if (defensor == TIERRA) return 0.0; 
                break;
    case PSIQUICO:
                if (defensor == LUCHA || defensor == VENENO) return 2.0;
                if (defensor == PSIQUICO || defensor == ACERO) return 0.5;
                if (defensor == FANTASMA) return 0.0; 
                break;
    case ROCA:
                if (defensor == FUEGO || defensor == HIELO || defensor == VOLADOR || defensor == BICHO) return 2.0;
                if (defensor == LUCHA || defensor == TIERRA || defensor == ACERO) return 0.5;
                break;
    case TIERRA:
                if (defensor == FUEGO || defensor == ELECTRICO || defensor == VENENO || defensor == ROCA || defensor == ACERO) return 2.0;
                if (defensor == PLANTA || defensor == BICHO) return 0.5;
                if (defensor == VOLADOR) return 0.0; 
                break;
    case NORMAL:
                if (defensor == ROCA || defensor == ACERO) return 0.5;
                if (defensor == FANTASMA) return 0.0; 
                break;
    case VOLADOR:
                if (defensor == PLANTA || defensor == TIERRA  || defensor == LUCHA || defensor == BICHO) return 2.0; 
                if (defensor == ROCA || defensor == ELECTRICO  || defensor == ACERO) return 0.5; 
                break;
    case HADA:
                if (defensor == PSIQUICO  || defensor == LUCHA ) return 2.0; 
                if (defensor == FUEGO || defensor == VENENO  || defensor == ACERO) return 0.5;
                break;   
    case LUCHA:
                if (defensor == ROCA || defensor == NORMAL || defensor == HIELO  || defensor == ACERO) return 2.0; 
                if (defensor == PSIQUICO || defensor == HADA || defensor == FANTASMA || defensor == VENENO || defensor == VOLADOR || defensor == BICHO) return 0.5; 
                if (defensor == FANTASMA) return 0.0;
                break;  
    case ACERO:
                if (defensor == ROCA || defensor == HADA || defensor == LUCHA || defensor == HIELO) return 2.0; 
                if (defensor == FUEGO || defensor == PSIQUICO || defensor == AGUA || defensor == ELECTRICO  || defensor == ACERO ) return 0.5; 
                break; 
    case BICHO:
                if (defensor == PLANTA || defensor == PSIQUICO ) return 2.0; 
                if (defensor == ACERO || defensor == FANTASMA || defensor == VOLADOR || defensor == FUEGO || defensor == VENENO || defensor == HADA  || defensor == LUCHA) return 0.5; 
                break; 
    case HIELO:
                if (defensor == PLANTA ||defensor == TIERRA ||defensor == VOLADOR ) return 2.0; 
                if (defensor == FUEGO || defensor == AGUA  || defensor == ACERO || defensor == HIELO ) return 0.5;
                break;  
    case FANTASMA:
                if (defensor == FANTASMA || defensor == PSIQUICO  ) return 2.0; 
                if (defensor == VENENO) return 0.5; 
                if (defensor == NORMAL) return 0;
                break;   
    
    
    default:
        return 1.0; 
        }
    return 1.0; 
    }
}

