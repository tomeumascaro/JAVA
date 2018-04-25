/*
CLASSE CURSOS
Un curs esta format per: nom, codi i assignatures(LlistaAssignatures)
 */
package gestiocolegi2;

import java.util.Comparator;

public class Curs implements AccesElements , Comparator<Curs> {
    
    private String nomCurs;
    private String codiCurs;
    private LlistaAssignatures llistaAssign;
    private String tipoCurs;
    private String modalitat; //Per Batxillerat, modalitat = 1r/2n //Per FP, modalitat = Meca/Elect/Infor
    
    public Curs(){
        
    }
    
    public Curs(String nomCurs){
        this.nomCurs = nomCurs;
    }
    
    public Curs(String nomCurs,String codiCurs, String tipoCurs, String modalitat){
        this.codiCurs = codiCurs;
        this.nomCurs = nomCurs;
        this.llistaAssign = new LlistaAssignatures();
        this.tipoCurs = tipoCurs;
        this.modalitat = modalitat;
    }
    
    public Curs(String nomCurs, String codiCurs, LlistaAssignatures llistaAssign, String tipoCurs, String modalitat) {
        this.nomCurs = nomCurs;
        this.codiCurs = codiCurs;
        this.llistaAssign = llistaAssign;
        this.tipoCurs = tipoCurs;
        this.modalitat = modalitat;
    }
    
    
    //SETTERS & GETTERS
    
    public String getNom() {
        return nomCurs + " (" + codiCurs + ") de " + tipoCurs + " (" + modalitat + ")";
    }
    
    public void setNom(String nomCurs) {
        this.nomCurs = nomCurs;
    }
    
    public String getCodi() {
        return codiCurs;
    }
    
    public void setCodi(String codiCurs) {
        this.codiCurs = codiCurs;
    }
    
    public LlistaAssignatures getLlistaAssign() {
        return llistaAssign;
    }
    
    public void setLlistaAssign(LlistaAssignatures llistaAssign) {
        this.llistaAssign = llistaAssign;
    }
    
    public String getTipo() {
        return tipoCurs;
    }
    
    public void setTipo(String tipoCurs) {
        this.tipoCurs = tipoCurs;
    }
    
    public String getModalitat() {
        return modalitat;
    }
    
    public void setModalitat(String modalitat) {
        this.modalitat = modalitat;
    }
    
    @Override
    public String toString() {
        return nomCurs + " (" + codiCurs + ") " + "(" + tipoCurs + " - " + modalitat + ")";
    }
    @Override
    public int compare(final Curs object1, final Curs object2) {
          return object1.getNom().compareTo(object2.getNom());
      }
}
