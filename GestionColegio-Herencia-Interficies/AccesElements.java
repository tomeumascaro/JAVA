/*
Operacions comunes de les classes Curs i Assignatura
 */
package gestiocolegi2;

public interface AccesElements {
    
    void setNom(String nom);
    void setCodi(String codi);
    void setTipo(String tipo);
    String getNom();
    String getCodi();
    String getTipo();
    @Override
    String toString();
}
