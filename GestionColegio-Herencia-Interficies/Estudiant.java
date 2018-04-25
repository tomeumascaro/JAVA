/*
CLASSE ESTUDIANTS
Un estudiant esta format per: Nom i codi (DNI)
 */
package gestiocolegi2;

import java.util.ArrayList;
import java.util.Comparator;

public class Estudiant implements Comparator<Estudiant>{
    
    private String nomEstud;
    private String codiEstud;
    private Assignatura assignaturaPertenyent;
    private ArrayList<Assignatura> assignaturesMatriculat;
  
    public Estudiant(){
        
    }
    public Estudiant(String nomEstud, String codiEstud) {
        this.nomEstud = nomEstud;
        this.codiEstud = codiEstud;
        assignaturesMatriculat = new ArrayList<Assignatura>();
    }
    
    
    //SETTERS & GETTERS
    
    public String getNomEstudiant() {
        return nomEstud;
    }
    
    public void setNomEstud(String nomEstud) {
        this.nomEstud = nomEstud;
    }
    
    public String getCodiEstud() {
        return codiEstud;
    }
    
    public void setCodiEstud(String codiEstud) {
        this.codiEstud = codiEstud;
    }
    
    public void afegirAssignaturaPertenyent(Assignatura assignatura){
        assignaturesMatriculat.add(assignatura);
    }
    
    public ArrayList<Assignatura> getAssignaturesMatriculat(){
        return this.assignaturesMatriculat;
    }
    
    public Assignatura getAssignaturaPertenyent(){
        return assignaturaPertenyent;
    }
    @Override
    public String toString() {
        return nomEstud + " (" + codiEstud + ")";
    }
    @Override
    public int compare(final Estudiant object1, final Estudiant object2) {
          return object1.getNomEstudiant().compareTo(object2.getNomEstudiant());
      }
    
}