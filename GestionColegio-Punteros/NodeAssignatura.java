package gestiocolegipunteros;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class NodeAssignatura {
    
    private NodeAssignatura primero;
    protected String nom;
    protected String codi;
    protected NodeAssignatura siguiente;
    protected LlistaEstudiants le;

    public NodeAssignatura(String n, String c, LlistaEstudiants lest) {
        this.codi = c;
        this.nom = n;
        this.le=lest;
    }

    public LlistaEstudiants getLa() {
        return le;
    }

    public void setLa(LlistaEstudiants lest) {
        this.le = lest;
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

    public NodeAssignatura coger() {
        return siguiente;
    }

    public void poner(NodeAssignatura siguiente_nodo) {
        siguiente = siguiente_nodo;
    }
    
    @Override
    public String toString() {
        return "Nodo: "+nom+" Codigo: "+codi+" Seg: "+siguiente+" ";
    }    
    
}

    
    

