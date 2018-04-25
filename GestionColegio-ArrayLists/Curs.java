/*
CLASSE CURSOS
Un curs esta format per: nom, codi i assignatures(LlistaAssignatures)
 */
package gestiocolegi;

import java.util.Comparator;

public class Curs implements Comparator<Curs>{
    
    private String nomCurs;
    private String codiCurs;
    private LlistaAssignatures llistaAssign;
    
    public Curs(){
        
    }
    public Curs(String nomCurs){
        this.nomCurs = nomCurs;
    }
    public Curs(String nomCurs,String codiCurs){
        this.codiCurs = codiCurs;
        this.nomCurs = nomCurs;
        this.llistaAssign = new LlistaAssignatures();
    }
    public Curs(String nomCurs, String codiCurs, LlistaAssignatures llistaAssign) {
        this.nomCurs = nomCurs;
        this.codiCurs = codiCurs;
        this.llistaAssign = llistaAssign;
    }
    
    
    //SETTERS & GETTERS
    
    public String getNomCurs() {
        return nomCurs;
    }
    
    public void setNomCurs(String nomCurs) {
        this.nomCurs = nomCurs;
    }
    
    public String getCodiCurs() {
        return codiCurs;
    }
    
    public void setCodiCurs(String codiCurs) {
        this.codiCurs = codiCurs;
    }
    
    public LlistaAssignatures getLlistaAssign() {
        return llistaAssign;
    }
    
    public void setLlistaAssign(LlistaAssignatures llistaAssign) {
        this.llistaAssign = llistaAssign;
    }
    
    @Override
    public String toString() {
        return nomCurs + " (" + codiCurs + ")";
    }
    @Override
    public int compare(final Curs object1, final Curs object2) {
          return object1.getNomCurs().compareTo(object2.getNomCurs());
      }
}
