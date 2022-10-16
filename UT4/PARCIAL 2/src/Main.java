import java.util.LinkedList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        TArbolBBU ucu  = new TArbolBBU();
        
       String[] alumnos = ManejadorArchivosGenerico.leerArchivo(".\\src\\Datos.csv");
        
        for (int i = 0; i < alumnos.length; i++) {
            String[] datosAlumno = alumnos[i].split(",");
            Alumno alumno = new Alumno(Integer.parseInt(datosAlumno[0]),datosAlumno[1],datosAlumno[2]);
            
            TNodoAlumnoAB nodo = new TNodoAlumnoAB(datosAlumno[0], alumno);
            ucu.insertar(nodo);

            if (nodo == null) {
                alumnos[i] = "0";
            }
        }
                
        String laCarrera = "Medicina";
        
        TArbolBBU porCarrera = ucu.armarIndiceCarrera(laCarrera);
        
        //System.out.println(porCarrera.inOrden());
        
      
        
        // escribir en el archivo "salida.txt" el listado emitido de los alumnos
        // de la carrera indicada, en orden alfabético ascendente
        
        String[] aux = porCarrera.inOrden().split("-");
        String[] alumnos1 = new String[aux.length];
        
        for (int i = 0; i < aux.length; i++) {
            
            alumnos1[i] = aux[i];
        }
        
        ManejadorArchivosGenerico.escribirArchivo(".\\src\\Indice.txt", alumnos1);
    }

   

}

