package gestiocolegipunteros;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class LlistaEstudiants {
    
    private NodeEstudiant primero; //apuntador al primer element de la llista

    //Constructor. Crea una llista buida
    public LlistaEstudiants() {
        primero = null;
    }
    
    //Operació per afegir un element a la llista
    public void incluir(String nom, String codi) {
        NodeEstudiant elemento;
        elemento = new NodeEstudiant(nom, codi);
        if (primero == null) { //Mira si la llista és buida i insereix
            primero = elemento;

//        }  else if (elemento.nom.compareToIgnoreCase(primero.nom) <0) {
//            elemento.siguiente=primero;
//            primero=elemento;
        }
        else { //Si la llista no és buida, insereix l’element al final
       
            NodeEstudiant sig = primero.siguiente;
            NodeEstudiant ant = primero;
            while (sig != null)
            {
//                if (elemento.nom.compareToIgnoreCase(sig.nom) < 0){
//                        break;
//                }
                ant = sig;
                sig = sig.siguiente;
            }
            // insert between before & after
            elemento.siguiente = ant.siguiente;
            ant.siguiente = elemento;
            
        }
    }
    
    public boolean buscarEstudiante(String text) {
        
        NodeEstudiant aux;
        boolean encontrado=false;
        
        for (aux = primero; (aux != null) ; aux = aux.coger()) {
        
            if (!encontrado) {
                if (text.equals(aux.nom)) {
                    encontrado = true;
                }
            }
        }
        
        return encontrado;
    }
    
    //Operació per imprimir tots els nodes de la llista
//    public void imprimir() {
//        
//        NodoEstudiante aux;
//        
//        for (aux = primero; aux != null; aux = aux.coger()) {
//            System.out.println(aux.getNom());
//        }
//    }
    
    public String devuelveEstudiantes(){
        
        String s="";
        NodeEstudiant aux;
        
        for (aux = primero; aux != null; aux = aux.coger()) {
            //System.out.println(aux.getNom());
            s+=aux.nom + "\n";
        }
        
        return s;
    }
    
}
