package gestiocolegipunteros;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class NodeEstudiant {
    
    private NodeEstudiant primero;
    protected String nom;
    protected String codi;
    protected NodeEstudiant siguiente;

    public NodeEstudiant(String n, String c) {
        this.codi = c;
        this.nom = n;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public NodeEstudiant coger() {
        return siguiente;
    }

    public void poner(NodeEstudiant siguiente_nodo) {
        siguiente = siguiente_nodo;
    }
    
    @Override
    public String toString() {
        return "Nodo: "+nom+" Codigo: "+codi+" Seg: "+siguiente+" ";
    }
 
}
    
    
