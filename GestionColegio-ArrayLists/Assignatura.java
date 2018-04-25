/*
CLASSE ASSIGNATURES
Una assignatura esta formada per: Nom i codi
 */
package gestiocolegi;

import java.util.Comparator;

public class Assignatura implements Comparator<Assignatura>{
    
    private String nomAssign;
    private String codiAssign;
    private LlistaEstudiants llistaEstud;
    private Curs cursPertenyent; //Curs al que pertany l'assignatura
    
    public Assignatura(){
        
    }
    public Assignatura(String nomAssign){
        this.nomAssign = nomAssign;
    }
    public Assignatura(String nomAssign, String codiAssign){
        this.nomAssign = nomAssign;
        this.codiAssign = codiAssign;
        this.llistaEstud = new LlistaEstudiants();
    }
    public Assignatura(String nomAssign, String codiAssign, LlistaEstudiants llistaEstud) {
        this.nomAssign = nomAssign;
        this.codiAssign = codiAssign;
        this.llistaEstud = llistaEstud;
    }
    
    
    //SETTERS & GETTERS
    
    public String getNomAssignatura() {
        return nomAssign;
    }
    
    public void setNomAssign(String nomAssign) {
        this.nomAssign = nomAssign;
    }
    
    public String getCodiAssign() {
        return codiAssign;
    }
    
    public void setCodiAssign(String codiAssign) {
        this.codiAssign = codiAssign;
    }
    
    public LlistaEstudiants getLlistaEstud() {
        return llistaEstud;
    }
    
    public void setLlistaEstud(LlistaEstudiants llistaEstud) {
        this.llistaEstud = llistaEstud;
    }
    
    public void setCursPertenyent(Curs curs){
        this.cursPertenyent = curs;
    }
    
    public Curs getCursPertenyent(){
        return cursPertenyent;
    }
    @Override
    public String toString() {
        return nomAssign + " ("+ codiAssign + ")";
    }
    @Override
    public int compare(final Assignatura object1, final Assignatura object2) {
          return object1.getNomAssignatura().compareTo(object2.getNomAssignatura());
      }
    
}
