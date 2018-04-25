/*
CLASSE ASSIGNATURES
Una assignatura esta formada per: Nom i codi
 */
package gestiocolegi2;

import java.util.Comparator;

public class Assignatura implements AccesElements , Comparator<Assignatura>{
    
    private String nomAssign;
    private String codiAssign;
    private LlistaEstudiants llistaEstud;
    private Curs cursPertenyent; //Curs al que pertany l'assignatura
    private String tipusAssign; //Obligatòria/Optativa
    private String caract;//Si és Obligatòria: nº Credits //Si és Optativa: Pràctica/Teòrica
    
    public Assignatura(){
        
    }
    public Assignatura(String nomAssign){
        this.nomAssign = nomAssign;
    }
    public Assignatura(String nomAssign, String codiAssign, String tipusAssign, String caract){
        this.nomAssign = nomAssign;
        this.codiAssign = codiAssign;
        this.llistaEstud = new LlistaEstudiants();
        this.tipusAssign = tipusAssign;
        this.caract = caract;
    }
    public Assignatura(String nomAssign, String codiAssign, LlistaEstudiants llistaEstud, String tipusAssign, String caract) {
        this.nomAssign = nomAssign;
        this.codiAssign = codiAssign;
        this.llistaEstud = llistaEstud;
        this.tipusAssign = tipusAssign;
        this.caract = caract;
    }
    
    
    //SETTERS & GETTERS
    
    public String getNom() {
        return nomAssign + " (" + tipusAssign + " - " + caract + ")";
    }
    
    public void setNom(String nomAssign) {
        this.nomAssign = nomAssign;
    }
    
    public String getCodi() {
        return codiAssign;
    }
    
    public void setCodi(String codiAssign) {
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
    
    public String getTipo() {
        return tipusAssign;
    }
    
    public void setTipo(String tipusAssign) {
        this.tipusAssign = tipusAssign;
    }
    
    public String getCaractAssign() {
        return caract;
    }
    
    public void setCaractAssign(String caract) {
        this.caract = caract;
    }
    
    public String getInfo() { //Pel botó de veure assignatures Obligatòries/Optatives
        return nomAssign + " (" + codiAssign + ") (" + caract + ") del curs " + cursPertenyent;
    }
    
    @Override
    public String toString() {
        return nomAssign + " ("+ codiAssign + ")" + " (" + tipusAssign + " - " + caract + ") ";
    }
    @Override
    public int compare(final Assignatura object1, final Assignatura object2) {
          return object1.getNom().compareTo(object2.getNom());
      }
    
    
}
