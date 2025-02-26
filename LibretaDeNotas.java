package genc182502;

import java.util.*;

public class LibretaDeNotas {

    //Creamos un metodo para ingresar datos de los alumnos y sus calificaciones
    public static void main(String[] args) {
        Map<String, List<Integer>> calificaciones = new HashMap<>(); //Inicializamos el Map
        Scanner sc = new Scanner(System.in); //Inicializamos el scanner

        System.out.println("Ingrese la cantidad de alumnos: ");
        int cantidadAlumnos = sc.nextInt();

        while (cantidadAlumnos <= 0) { //Validacion que la cantidad de alumnos es positiva
            System.out.println("Ingrese al menos un alumno. Intente de nuevo: ");
            cantidadAlumnos = sc.nextInt();
        }

        System.out.println("Ingrese la cantidad de notas por alumno: ");
        int cantidadNotas = sc.nextInt();

        while (cantidadNotas <= 0) { //Validacion que la cantidad de notas sea positiva
            System.out.println("Ingrese al menos un nota. Intente de nuevo: ");
            cantidadNotas = sc.nextInt();
        }

        sc.nextLine();

        //Ciclo for para iterar la cantidad de alumno con sus nombres
        for (int i = 0; i < cantidadAlumnos; i++) {
            System.out.println("Ingrese el nombre del alumno " + (i + 1) + ": ");
            String nombre = sc.nextLine();

            //Creamos una lista para almacenar las notas
            List<Integer> notas = new ArrayList<>();
            for (int j = 0; j < cantidadNotas; j++) { //Ciclo for para iterar con la cantidad de notas
                System.out.println("Ingrese la nota " + (j + 1) + " de " + nombre + ": ");
                int nota = sc.nextInt();

                while (nota < 0 || nota > 7.0) { //Valicacion que la nota este en el rango de 0 y 7
                    System.out.println("Nota inválida. Ingrese una nota entre 0 y 7: ");
                    nota = sc.nextInt();
                }

                notas.add(nota); //Agregamos la nota a la lista
            }
            sc.nextLine();
            calificaciones.put(nombre, notas); //Se guardan las notas en el Diccionario/Map
        }

        //Mostrar cada estudiante con sus respectivas notas
        System.out.println("Listado de estudiantes con sus notas:");
            for (Map.Entry<String, List<Integer>> entry : calificaciones.entrySet()) {
                System.out.println("Estudiante: " + entry.getKey() + " - Notas: " + entry.getValue());
            }

        //Menu de opciones
        int opcion;
            do {
                System.out.println("\nMenú de opciones:");
                System.out.println("1. Promedio de notas por estudiante");
                System.out.println("2. Verificar si una nota es aprobatoria o reprobatoria");
                System.out.println("3. Comparar nota con promedio del curso");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

            switch (opcion) {
                case 1:
                    //Calculamos y mostramos el promedio
                    for (String nombre : calificaciones.keySet()) {
                        List<Integer> notas = calificaciones.get(nombre);
                        double suma = 0;
                        for (int n : notas) {
                            suma += n;
                        }
                        double promedio = suma / notas.size();
                        System.out.println(nombre + " - Promedio: " + promedio);
                    }
                    break;

                case 2:
                    // Verificamos si una nota es aprobatoria (nota >= 4)
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String estudiante = sc.nextLine();
                    System.out.print("Ingrese la nota a evaluar: ");
                    int nota = sc.nextInt();
                    if (nota >= 4) {
                        System.out.println("La nota es aprobatoria.");
                    } else {
                        System.out.println("La nota es reprobatoria.");
                    }
                    break;

                case 3:
                    // Calculamos el promedio general del curso
                    double sumaTotal = 0;
                    int totalNotas = 0;
                    for (List<Integer> notas : calificaciones.values()) {
                        for (int n : notas) {
                            sumaTotal += n;
                        }
                        totalNotas += notas.size();
                    }
                    double promedioCurso = totalNotas > 0 ? sumaTotal / totalNotas : 0;
                    System.out.print("Ingrese el nombre del estudiante: ");
                    String estudianteComp = sc.nextLine();
                    System.out.print("Ingrese la nota a comparar: ");
                    int notaComp = sc.nextInt();

                    if (notaComp >= promedioCurso) {
                        System.out.println("La nota está sobre el promedio del curso.");
                    } else {
                        System.out.println("La nota está por debajo del promedio del curso.");
                    }
                    break;
                }
            } while (opcion != 0);

            sc.close();

    }
}






