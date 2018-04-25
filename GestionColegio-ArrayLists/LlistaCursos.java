/*
CLASSE LLISTA CURSOS
ArrayList de cursos amb les seves operacions
*/
package gestiocolegi;

import java.util.ArrayList;
import java.util.Collections;

public class LlistaCursos {
    
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

    public void afegirCurs(Curs curs){
        llistaCursos.add(curs);
    }
    public void eliminarCursos(int index){
        llistaCursos.remove(index);
    }
    public ArrayList getLlistaCursos(){
        return this.llistaCursos;
    }
    public void ordenar(){
        Collections.sort(llistaCursos, new Curs());
    }
    public Curs getCurs(int index){
        return llistaCursos.get(index);
    }
    public int getTamany(){
        return llistaCursos.size();
    }
    public boolean llistaBuida(){
        return llistaCursos.isEmpty();
    }
}
