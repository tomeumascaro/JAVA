/*
CLASSE LLISTA ASSIGNATURES
ArrayList d'assignatures amb les seves operacions
*/
package gestiocolegi;

import java.util.ArrayList;
import java.util.Collections;

public class LlistaAssignatures {

    private ArrayList<Assignatura> llistaAssignatures;
    
    //CONSTRUCTOR SIMPLE
    public LlistaAssignatures(){                                    
        this.llistaAssignatures = new ArrayList<Assignatura>();
    }
    //CONSTRUCTOR AMB ASSIGNATURA INICIAL
    public LlistaAssignatures(Assignatura inicial){                 
        this.llistaAssignatures = new ArrayList<Assignatura>();
        llistaAssignatures.add(inicial);
    }

    public void afegirAssignatura(Assignatura assign){
        llistaAssignatures.add(assign);
    }
    public void eliminarAssignatura(int index){
        llistaAssignatures.remove(index);
    }
    public ArrayList getLlistaAssignatures(){
        return this.llistaAssignatures;
    }
    public Assignatura getAssignatura(int idx){
        return llistaAssignatures.get(idx);
    }
    public int getTamany(){
        return llistaAssignatures.size();
    }
    public boolean llistaBuida(){
        return llistaAssignatures.isEmpty();
    }
    public void ordenar(){
        Collections.sort(llistaAssignatures, new Assignatura());
    }
}
