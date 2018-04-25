/*
CLASSE LLISTA ASSIGNATURES
ArrayList d'assignatures amb les seves operacions
*/
package gestiocolegi2;

import java.util.ArrayList;
import java.util.Collections;

public class LlistaAssignatures implements AccesLlista {

    public ArrayList<Assignatura> llistaAssignatures;
    
    //CONSTRUCTOR SIMPLE
    public LlistaAssignatures(){                                    
        this.llistaAssignatures = new ArrayList<Assignatura>();
    }
    //CONSTRUCTOR AMB ASSIGNATURA INICIAL
    public LlistaAssignatures(Assignatura inicial){                 
        this.llistaAssignatures = new ArrayList<Assignatura>();
        llistaAssignatures.add(inicial);
    }

    public void afegir(Assignatura assign){
        llistaAssignatures.add(assign);
    }
    public void eliminar(int index){
        llistaAssignatures.remove(index);
    }
    public ArrayList getLlista(){
        return this.llistaAssignatures;
    }
    public Assignatura getElement(int idx){
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

    @Override
    public void afegir(ArrayList name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
