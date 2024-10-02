package rec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
    	Random random = new Random();
        // Crear cursos
        List<Curso> cursos = new ArrayList<>();
        cursos.add(new Curso(1, 30, 3));
        cursos.add(new Curso(2, 45, 12));
        cursos.add(new Curso(3, 28, 56));
        cursos.add(new Curso(4, 35, 73));
        cursos.add(new Curso(5, 22, 48));
        cursos.add(new Curso(6, 38, 9));
        cursos.add(new Curso(7, 17, 35));
        cursos.add(new Curso(8, 26, 88));
        cursos.add(new Curso(9, 40, 15));
        cursos.add(new Curso(10, 12, 66));
        cursos.add(new Curso(11, 10, 29));
        cursos.add(new Curso(12, 5, 47));
        cursos.add(new Curso(13, 18, 92));
        cursos.add(new Curso(14, 27, 36));
        cursos.add(new Curso(15, 50, 80));
        cursos.add(new Curso(16, 5, 24));
        cursos.add(new Curso(17, 36, 57));
        cursos.add(new Curso(18, 30, 11));
        cursos.add(new Curso(19, 50, 3));
        cursos.add(new Curso(20, 15, 99));
        cursos.add(new Curso(21, 35, 50));
        cursos.add(new Curso(22, 8, 77));
        cursos.add(new Curso(23, 25, 23));
        cursos.add(new Curso(24, 42, 96));


        // Crear historial de calificaciones
        Map<Integer, List<AlumnoCurso>> historialCalificaciones = new HashMap<>();
        Map<Integer, List<AlumnoCurso>> historialCalificaciones2 = new HashMap<>();
        Map<Integer, List<AlumnoCurso>> historialCalificaciones3 = new HashMap<>();
        
        List<AlumnoCurso> calificacionesAlumno1 = new ArrayList<>();
        List<AlumnoCurso> calificacionesAlumno2 = new ArrayList<>();
        List<AlumnoCurso> calificacionesAlumno3 = new ArrayList<>();
        
        
        //Calificaciones 0.0. - 10.0
        calificacionesAlumno1.add(new AlumnoCurso(1, 1, 9.5));
        calificacionesAlumno1.add(new AlumnoCurso(1, 2, 3.0));
        calificacionesAlumno1.add(new AlumnoCurso(1, 6, 5.0));
        calificacionesAlumno1.add(new AlumnoCurso(1, 7, 1.0));
        calificacionesAlumno1.add(new AlumnoCurso(1, 10, 4.5));
        calificacionesAlumno1.add(new AlumnoCurso(1, 11, 3.3));

        calificacionesAlumno2.add(new AlumnoCurso(2, 1, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 2, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 7, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 4, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 9, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 12, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 13, random.nextDouble() * 10));
        calificacionesAlumno2.add(new AlumnoCurso(2, 14, random.nextDouble() * 10));

        calificacionesAlumno3.add(new AlumnoCurso(3, 3, random.nextDouble() * 10));
        calificacionesAlumno3.add(new AlumnoCurso(3, 24, random.nextDouble() * 10));
        calificacionesAlumno3.add(new AlumnoCurso(3, 20, random.nextDouble() * 10));
        calificacionesAlumno3.add(new AlumnoCurso(3, 18, random.nextDouble() * 10));
        calificacionesAlumno3.add(new AlumnoCurso(3, 1, random.nextDouble() * 10));
        calificacionesAlumno3.add(new AlumnoCurso(3, 14, random.nextDouble() * 10));

        
        historialCalificaciones.put(1, calificacionesAlumno1);
        historialCalificaciones2.put(2, calificacionesAlumno2);
        historialCalificaciones3.put(3, calificacionesAlumno3);

        // Crear sistema de recomendación
        SistemaRecomendacion sistema = new SistemaRecomendacion(cursos, historialCalificaciones);
        SistemaRecomendacion sistema2 = new SistemaRecomendacion(cursos, historialCalificaciones2);
        SistemaRecomendacion sistema3 = new SistemaRecomendacion(cursos, historialCalificaciones3);
        
        // Obtener recomendaciones para el alumno 1
        System.out.println("Para el uno");
        List<Curso> recomendaciones = sistema.recomendarCursos(1);
        System.out.println("Para el dos");
        List<Curso> recomendaciones2 = sistema2.recomendarCursos(2);
        List<Curso> recomendaciones3 = sistema3.recomendarCursos(3);
        if(recomendaciones.isEmpty() || recomendaciones2.isEmpty()) {
        	System.out.println("Nada que mostrar hijo");
        } else {
        	System.out.println("Recomendaciones para el alumno 1:" + recomendaciones.size());
            for (Curso c : recomendaciones) {
                System.out.println("Curso ID: " + c.getId() + ", Duración: " + c.getDuracion() + ", Dificultad: " + c.getDificultad());
            }
            
            System.out.println("Recomendaciones para el alumno 2:" + recomendaciones2.size());
            for (Curso c : recomendaciones2) {
                System.out.println("Curso ID: " + c.getId() + ", Duración: " + c.getDuracion() + ", Dificultad: " + c.getDificultad());
            }
            
            System.out.println("Recomendaciones para el alumno 3:" + recomendaciones3.size());
            for (Curso c : recomendaciones3) {
                System.out.println("Curso ID: " + c.getId() + ", Duración: " + c.getDuracion() + ", Dificultad: " + c.getDificultad());
            }
            
        }
    }
}

