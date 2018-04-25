package gestiocolegipunteros;

import java.util.Vector;
import static gestiocolegipunteros.GestioColegiPunteros.jtaEstudiants;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class LlistaAssignatures {
    
    public NodeAssignatura primero; //apuntador al primer element de la llista

    //Constructor. Crea una llista buida
    public LlistaAssignatures() {
        primero = null;
    }

    //Operació per afegir un element a la llista
    public void incluir(String nom, String codi, LlistaEstudiants lest) {
        NodeAssignatura elemento;
        elemento = new NodeAssignatura(nom, codi, lest);

        if (primero == null) { //Mira si la llista és buida i insereix
            primero = elemento;

//        }  else if (elemento.nom.compareToIgnoreCase(primero.nom) <0) {
//            elemento.siguiente=primero;
//            primero=elemento;
        }
        else { //Si la llista no és buida, insereix l’element al final
       
            NodeAssignatura sig = primero.siguiente;
            NodeAssignatura ant = primero;
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

    //Operació per imprimir tots els nodes de la llista
//    public void imprimir() {
//        System.out.println("SOC A IMPRIMIR PRINCIPI");
//        Vector<String> vector2 = new Vector<>();
//        NodoAsignatura aux;
//        for (aux = primero; aux != null; aux = aux.coger()) { //NO VA BÉ ?¿?¿
//            System.out.println("SOC A IMPRIMIR BUCLE1 PRINCIPI");
//            System.out.println(aux.getNom());
//            jtaAssignatures.setText("ASSIGNATURES ACUTALS:\n\n");
//            vector2.add("ASSIGNATURA: " + aux.getNom() + "  CODI: " + aux.getCodi() + "\n");
//            System.out.println("SOC A IMPRIMIR BUCLE1 FINAL");
//        }
//        for (int i = 0; i < vector2.size(); i++) { //NO VA BÉ ?¿?¿
//            jtaAssignatures.setText(jtaAssignatures.getText() + vector2.get(i) + "\n");
//            System.out.println("SOC A IMPRIMIR BUCLE2");
//        }
//        System.out.println("SOC A IMPRIMIR FINAL");
//    }
//    
//    public String imprimirAsignatures() {
//        String s = null;
//        NodoAsignatura aux;
//        for (aux = primero; aux != null; aux = aux.coger()) {
//            System.out.println(aux.getNom());
//            jtaAssignatures.setText("\nASSIGNATURES ACTUALS\n\n");
//            s = "ASSIGNATURA: " + aux.getNom() + "  CODI: " + aux.getCodi();
//        }
//        return s;
//    }
    
    
    public void afegirestudiant(String asign, String nombre, String dni) {
        NodeAssignatura aux;
        boolean encontrado=false;
        
        for (aux = primero; (aux != null ) ; aux = aux.coger()) { 
            if(!encontrado) { //cercam assignatura
                if (aux.nom.equals(asign)) {
                    encontrado=true;
                    aux.le.incluir(nombre, dni);
                    //aux.le.imprimir();
                    jtaEstudiants.setText(jtaEstudiants.getText() + "S'ha afegit l'estudiant " + nombre + " (" + dni +
                            ") a l'assignatura " + asign + ".\n\n");
                }
            }
        }
    }
    
    public boolean buscarasignatura(String a) {
        
        NodeAssignatura aux;
        boolean encontrado=false;
        
        for (aux = primero; (aux != null) ; aux = aux.coger()) {
            if (!encontrado) {
                if (a.equals(aux.nom)) {
                    encontrado = true;
                }

            }
        }
        
        return encontrado;
    }
    
    public String imprimirasignaturayalumnos (String text){
        
        NodeAssignatura aux;
        String s="";
        
        for (aux = primero; aux != null; aux = aux.coger()) {
            if (aux.nom.equals(text)) {
                s += aux.le.devuelveEstudiantes() + "\n";
            }
        }
        
        return s;
    }
    
    public String imprimirAsignaturaAlumnos(){
        
        NodeAssignatura aux;
        String s="";
        
        for (aux = primero; aux != null; aux = aux.coger()) {
//            s+=aux.nom+":\n";
//            s+=aux.le.devuelveEstudiantes()+"\n\n";
            s += aux.nom + ", amb els estudiants:\n" + aux.le.devuelveEstudiantes() + "\n";
        }
        
        return s;
    }


    public void eliminar(String nombre) {
        
        if(primero != null) {
            NodeAssignatura sig = primero.siguiente;
            NodeAssignatura ant = primero;
            if(nombre.equals(ant.nom)) {
                primero=sig;
            } else {
                while (sig != null){
                    if (nombre.equals(sig.nom)){
                            break;
                    }
                    ant = sig;
                    sig = sig.siguiente;
                }

                if(sig==null) {
                    primero=null;
                }
                else {
                    ant.siguiente=sig.siguiente;
                }
            }
        }
    }
    
    
//    public String devolverAsignaturas() {
//        
//        NodoAsignatura aux;
//        String s="";
//        
//        for (aux = primero; aux != null; aux = aux.coger()) {
//            s+=aux.getNom();
//        }
//        
//        return s;
//    }
//    
//    
//    public String devolverUnaAsignatura(String est) {
//        
//        NodoAsignatura aux;
//        boolean encontrado=false;
//        String s="";
//        
//        for (aux = primero; (aux != null) ; aux = aux.coger()) {
//        
//            if (!encontrado) {
//                if (aux.le.buscarEstudiante(est)) {
//                    encontrado = true;
//                    s=aux.nom;
//                }
//            }
//        }
//        
//        return s;
//    }
    
}
