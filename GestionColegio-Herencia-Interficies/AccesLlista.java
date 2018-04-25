/*
Operacions comunes de les classes LlistaCursos i LlistaAssignatures
 */
package gestiocolegi2;

import java.util.ArrayList;

public interface AccesLlista {
    
    void afegir(ArrayList name);
    void eliminar(int index);
    void ordenar();
    ArrayList getLlista();
    int getTamany();
    boolean llistaBuida();
}
