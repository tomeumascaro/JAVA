/*
CLASSE LLISTA CURSOS
ArrayList de cursos amb les seves operacions
*/
package gestiocolegi2;

import java.util.ArrayList;
import java.util.Collections;

public class LlistaCursos implements AccesLlista {
    
    private String[] noms;
    private ArrayList<Curs> llistaCursos;
    
    //CONSTRUCTOR SIMPLE
    public LlistaCursos(){                                    
        this.llistaCursos = new ArrayList<Curs>();
    }
    //CONSTRUCTOR AMB ASSIGNATURA INICIAL
    public LlistaCursos(Curs inicial){                 
        this.llistaCursos = new ArrayList<Curs>();
        llistaCursos.add(inicial);
    }

    public void afegir(Curs curs){
        llistaCursos.add(curs);
    }
    public void eliminar(int index){
        llistaCursos.remove(index);
    }
    public ArrayList getLlista(){
        return this.llistaCursos;
    }
    public void ordenar(){
        Collections.sort(llistaCursos, new Curs());
    }
    public Curs getElement(int index){
        return llistaCursos.get(index);
    }
    public int getTamany(){
        return llistaCursos.size();
    }
    public boolean llistaBuida(){
        return llistaCursos.isEmpty();
    }

    @Override
    public void afegir(ArrayList name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
