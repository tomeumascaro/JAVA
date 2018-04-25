package gestiocolegipunteros;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class NodeCurs {
    
    private NodeCurs primero;
    protected String nom;
    protected String codi;
    protected NodeCurs siguiente;
    protected LlistaAssignatures la;

    public NodeCurs(String n, String c, LlistaAssignatures la) {
        this.codi = c;
        this.nom = n;
        this.la=la;
    }

    public LlistaAssignatures getLa() {
        return la;
    }

    public void setLa(LlistaAssignatures la) {
        this.la = la;
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

    public NodeCurs coger() {
        return siguiente;
    }


    public void poner(NodeCurs siguiente_nodo) {
        siguiente = siguiente_nodo;
    }
    
    @Override
    public String toString() {
        return "Nodo: "+nom+" Codigo: "+codi+" Seg: "+siguiente+" ";
    }
    
}
