package gestiocolegipunteros;

import java.util.Vector;
import static gestiocolegipunteros.GestioColegiPunteros.jtaAssignatures;
import static gestiocolegipunteros.GestioColegiPunteros.jtaCursos;

/**
 *
 * @author Bartomeu Mascaró Arbona & Toni Gomila Llompart & Manuel Peña Llull
 */

public class LlistaCursos {

    private NodeCurs primero; //apuntador al primer element de la llista

    //Constructor. Crea una llista buida
    public LlistaCursos() {
        primero = null;
    }
    
    //Operació per afegir un element a la llista
    public void incluir(String nom, String codi, LlistaAssignatures las) {
        NodeCurs elemento;
        elemento = new NodeCurs(nom, codi, las);
        if (primero == null) { //Mira si la llista és buida i insereix
            primero = elemento;

//        } else if (elemento.nom.compareToIgnoreCase(primero.nom) < 0) { //per ordenar
//            elemento.siguiente = primero;
//            primero = elemento;
        } else { //Si la llista no és buida, insereix l’element al final

            NodeCurs sig = primero.siguiente;
            NodeCurs ant = primero;
            while (sig != null) {
//                if (elemento.nom.compareToIgnoreCase(sig.nom) < 0) { //per ordenar
//                    break;
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
    public void imprimir() {
        Vector<String> vector = new Vector<>();
        NodeCurs aux;
        for (aux = primero; aux != null; aux = aux.coger()) {
            System.out.println(aux.getNom());
            jtaCursos.setText("CURSOS ACUTALS:\n\n");
            vector.add("CURS: " + aux.getNom() + "  CODI: " + aux.getCodi() + "\n");
        }
        for (int i = 0; i < vector.size(); i++) {
            jtaCursos.setText(jtaCursos.getText() + vector.get(i));
        }
    }

    public void afegirasignatura(String curso, String nombre, String codigo) {
        
        NodeCurs aux;
        boolean encontrado = false;

        for (aux = primero; (aux != null); aux = aux.coger()) {

            if(!encontrado) {
                if (aux.nom.equals(curso)) { //cerca del curs
                    encontrado = true;
                    LlistaEstudiants les = new LlistaEstudiants();
                    aux.la.incluir(nombre, codigo, les); //guardam assignatura
                    jtaAssignatures.setText(jtaAssignatures.getText() + "S'ha afegit l'assignatura " + nombre + 
                            " (" + codigo + ") al curs " + curso + ".\n\n");
                } else {
                    //JOptionPane.showMessageDialog(null, "El curs introduït no existeix", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public String listarasignaturas(String curso, String codigo) {
        
        NodeCurs aux;
        String s="";
        boolean encontrado = false;

        for (aux = primero; (aux != null ); aux = aux.coger()) {

            if (!encontrado) {
                if (aux.nom.equals(curso) && aux.codi.equals(codigo)) {
                    encontrado = true;
                    s= "\nEl curs " + curso + " conté les assignatures:\n" + aux.la.imprimirAsignaturaAlumnos();
                }
            }
        }
        return s;
    }

    public void matricular(String asignatura, String nombreest, String dni) {

        NodeCurs aux;
        boolean encontrado = false;

        //recorre los cursos
        for (aux = primero; (aux != null); aux = aux.coger()) {
            //busca si la asignatura que le pasa por parametro la encuentra en la lista de asignaturas
            if (!encontrado) {
                if (aux.la.buscarasignatura(asignatura)) {
                    encontrado=true;
                    aux.la.afegirestudiant(asignatura, nombreest, dni);
                }
            }
        }
    }

    public void eliminarasginatura(String nombre) {
        
        NodeCurs auxc;
        boolean encontrado = false;

        //recorre los cursos
        for (auxc=primero; (auxc != null); auxc = auxc.coger()) {
            //busca si la asignatura que le pasa por parametro la encuentra en la lista de asignaturas
            if (!encontrado) {
                if (auxc.la.buscarasignatura(nombre)) {
                    auxc.la.eliminar(nombre);
                    jtaAssignatures.setText(jtaAssignatures.getText() + "S'ha eliminat l'assignatura " + nombre 
                            + " del curs " + auxc.nom + ".\n\n");
                }
            }
        }
    }

    public void eliminarcurso(String curso, String codigo) {
        
        if(primero != null) {
            NodeCurs sig = primero.siguiente;
            NodeCurs ant = primero;
            
            if(curso.equals(ant.nom) && codigo.equals(ant.codi)) {
                primero=sig;
            }
            else {
                while (sig != null){
                    if (curso.equals(sig.nom) && codigo.equals(sig.codi)){
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

    public String veureAssignatura(String asignatura) {
        
        NodeCurs aux;
        boolean encontrado = false;
        String s="";
        //recorre los cursos
        for (aux = primero; (aux != null); aux = aux.coger()) {
            //busca si la asignatura que le pasa por parametro la encuentra en la lista de asignaturas
            if (!encontrado) {
                if (aux.la.buscarasignatura(asignatura)) {
                    s = "L'assignatura " + asignatura + " pertany al curs " + aux.nom + " (" + aux.codi + ") \ni conté "
                            + "els estudiants: \n" + aux.la.imprimirasignaturayalumnos(asignatura);
                }
            }
        }
        return s;
    }

    public String recorrrerasignaturas(String nombre) {
        
        NodeCurs aux;
        NodeAssignatura auxasign;
        boolean encontrado = false;
        String s = "L'estudiant " + nombre + " cursa les assignatures: \n";
        //recorre los cursos
        for (aux = primero; (aux != null); aux = aux.coger()) {
            
            for (auxasign=aux.la.primero; (auxasign != null); auxasign = auxasign.coger()) {
                
                if(auxasign.le.buscarEstudiante(nombre)){
                    s += auxasign.nom + " (" + auxasign.codi + ") del curs " + aux.nom + " (" + aux.codi + ")\n";
                }
            }
        }
        s += "\n";
        
        return s;
    }
}
