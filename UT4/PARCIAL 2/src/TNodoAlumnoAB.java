
import java.util.LinkedList;

public class TNodoAlumnoAB implements INodoAlumnoAB {

    private final Comparable etiqueta;
    private TNodoAlumnoAB hijoIzq;
    private TNodoAlumnoAB hijoDer;
    private final Alumno datos;

    /**
     * @param unaEtiqueta
     * @param unosDatos
     */
    public TNodoAlumnoAB(Comparable unaEtiqueta, Alumno unosDatos) {

        etiqueta = unaEtiqueta;
        datos = unosDatos;
        hijoIzq = null;
        hijoDer = null;
    }

    public Alumno getDatos() {
        return datos;
    }

    public TNodoAlumnoAB getHijoIzq() {
        return hijoIzq;
    }

    public TNodoAlumnoAB getHijoDer() {
        return hijoDer;

    }

    public Comparable getEtiqueta() {
        return etiqueta;
    }

    /**
     * @param unaEtiqueta
     * @return
     */
    @Override
    public TNodoAlumnoAB buscar(Comparable unaEtiqueta) {

        if (unaEtiqueta.equals(etiqueta)) {
            return this;
        } else if (unaEtiqueta.compareTo(etiqueta) < 0) {
            if (hijoIzq != null) {
                return hijoIzq.buscar(unaEtiqueta);
            } else {
                return null;
            }
        } else if (hijoDer != null) {
            return hijoDer.buscar(unaEtiqueta);
        } else {
            return null;
        }
    }

    /**
     * @return recorrida en inorden del subArbol que cuelga del elemento actual
     */
    @Override
    public String inOrden() {
        StringBuilder tempStr = new StringBuilder();
        if (hijoIzq != null) {
            tempStr.append(getHijoIzq().inOrden());
            tempStr.append(TArbolBBU.SEPARADOR_ELEMENTOS_IMPRESOS);
        }
        tempStr.append(imprimir());
        if (hijoDer != null) {
            tempStr.append(TArbolBBU.SEPARADOR_ELEMENTOS_IMPRESOS);
            tempStr.append(getHijoDer().inOrden());
        }

        return tempStr.toString();
    }

    @Override
    public void inOrden(LinkedList<Comparable> unaLista) {
        if (hijoIzq != null) {
            hijoIzq.inOrden(unaLista);

        }
        unaLista.add(this.getEtiqueta());
        if (hijoDer != null) {
            hijoDer.inOrden(unaLista);
        }

    }

    /**
     * @return
     */
    public String imprimir() {
        return (etiqueta.toString());
    }

    public void setHijoIzq(TNodoAlumnoAB elemento) {
        this.hijoIzq = elemento;

    }

    public void setHijoDer(TNodoAlumnoAB elemento) {
        this.hijoDer = elemento;
    }

    @Override
    public boolean insertar(TNodoAlumnoAB elemento) {
        if (etiqueta.equals(elemento.getEtiqueta())) {
            return false;
        }
        if (elemento.getEtiqueta().compareTo(etiqueta) < 0) {
            if (hijoIzq == null) {
                hijoIzq = elemento;
            } else {
                hijoIzq.insertar(elemento);
            }
        } else {
            if (hijoDer == null) {
                hijoDer = elemento;
            } else {
                hijoDer.insertar(elemento);
            }
        }
        return true;
    }

    @Override
    public void indizar(TArbolBBU indice, Comparable laCarrera) {
        String carrera = this.getDatos().getCarrera();
        
        if (carrera.equals(laCarrera)) {
            TNodoAlumnoAB alumno = new TNodoAlumnoAB(this.getDatos().getApellido(), this.getDatos());
            indice.insertar(alumno);
        }
        if (this.getHijoDer() != null) {
            hijoDer.indizar(indice, laCarrera);
        }
        if (this.getHijoIzq() != null) {
            hijoIzq.indizar(indice, laCarrera);
        }
    }
}