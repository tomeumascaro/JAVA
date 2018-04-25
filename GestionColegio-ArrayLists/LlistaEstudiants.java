/*
CLASSE LLISTA ESTUDIANTS
ArrayList d'estudiants amb les seves operacions
*/
package gestiocolegi;

import java.util.ArrayList;
import java.util.Collections;

public class LlistaEstudiants {

    private ArrayList<Estudiant> llistaEstudiants;
    
    //CONSTRUCTOR SIMPLE
    public LlistaEstudiants(){                                    
        this.llistaEstudiants = new ArrayList<Estudiant>();
    }
    //CONSTRUCTOR AMB ASSIGNATURA INICIAL
    public LlistaEstudiants(Estudiant inicial){                 
        this.llistaEstudiants = new ArrayList<Estudiant>();
        llistaEstudiants.add(inicial);
    }

    public void afegirEstudiant(Estudiant estudiant){
        llistaEstudiants.add(estudiant);
    }
    public void eliminarEstudiant(int idx){
        llistaEstudiants.remove(idx);
    }
    public ArrayList getLlistaEstudiants(){
        return this.llistaEstudiants;
    }
    public int getTamany(){
        return llistaEstudiants.size();
    }
    public Estudiant getEstudiant(int idx){
        return llistaEstudiants.get(idx);
    }
    public boolean llistaBuida(){
        return llistaEstudiants.isEmpty();
    }
    public void ordenar(){
        Collections.sort(llistaEstudiants, new Estudiant());
    }
}
