/*
 * ================================================================
 *  Universidad Tecnica de Ambato
 *  Carrera  : Ingenieria de Software
 *  Materia  : Estructura de Datos  |  Curso: Tercero B
 *  Tema     : Recorridos de Arboles Binarios
 *  Autores  : Grupo de trabajo
 * ================================================================
 *
 *  Caso de aplicacion real:
 *  Se modela un sistema web universitario como un arbol binario.
 *  Cada nodo representa un modulo del sistema (Usuarios,
 *  Inventario, Reportes, etc.). Los recorridos permiten simular
 *  como el sistema carga, valida y navega sus modulos.
 *
 *  Arboles implementados:
 *    - Arbol 1 (numeros): 7 nodos  -> ejercicios basicos
 *    - Arbol 2 (numeros): 11 nodos -> arbol extendido
 *    - Arbol 3 (texto)  : modulos del sistema web
 * ================================================================
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// ================================================================
//  NODO NUMERICO
// ================================================================
class Nodo {
    int dato;
    Nodo izquierda, derecha;

    public Nodo(int valor) {
        this.dato      = valor;
        this.izquierda = null;
        this.derecha   = null;
    }
}

// ================================================================
//  NODO DE TEXTO
// ================================================================
class NodoTexto {
    String dato;
    NodoTexto izquierda, derecha;

    public NodoTexto(String valor) {
        this.dato      = valor;
        this.izquierda = null;
        this.derecha   = null;
    }
}

// ================================================================
//  RECORRIDOS -- ARBOL NUMERICO
//  Todos los DFS usan recursividad.
//  La diferencia esta en el MOMENTO en que se visita la raiz.
// ================================================================
class RecorridosInt {

    // PREORDEN: Raiz -> Izquierda -> Derecha
    public static void preorden(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        resultado.add(raiz.dato);             // visitar raiz primero
        preorden(raiz.izquierda, resultado);
        preorden(raiz.derecha,   resultado);
    }

    // INORDEN: Izquierda -> Raiz -> Derecha
    // En un BST produce los valores en orden ascendente
    public static void inorden(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        inorden(raiz.izquierda, resultado);
        resultado.add(raiz.dato);             // visitar raiz en medio
        inorden(raiz.derecha,   resultado);
    }

    // POSTORDEN: Izquierda -> Derecha -> Raiz
    public static void postorden(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        postorden(raiz.izquierda, resultado);
        postorden(raiz.derecha,   resultado);
        resultado.add(raiz.dato);             // visitar raiz al final
    }

    // BFS: Recorrido por niveles usando una cola (sin recursividad)
    public static void bfs(Nodo raiz, Queue<Integer> resultado) {
        if (raiz == null) return;
        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            Nodo actual = cola.poll();
            resultado.add(actual.dato);
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha   != null) cola.add(actual.derecha);
        }
    }
}

// ================================================================
//  RECORRIDOS -- ARBOL DE TEXTO
// ================================================================
class RecorridosStr {

    public static void preorden(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;
        resultado.add(raiz.dato);
        preorden(raiz.izquierda, resultado);
        preorden(raiz.derecha,   resultado);
    }

    public static void inorden(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;
        inorden(raiz.izquierda, resultado);
        resultado.add(raiz.dato);
        inorden(raiz.derecha,   resultado);
    }

    public static void postorden(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;
        postorden(raiz.izquierda, resultado);
        postorden(raiz.derecha,   resultado);
        resultado.add(raiz.dato);
    }

    public static void bfs(NodoTexto raiz, Queue<String> resultado) {
        if (raiz == null) return;
        Queue<NodoTexto> cola = new LinkedList<>();
        cola.add(raiz);
        while (!cola.isEmpty()) {
            NodoTexto actual = cola.poll();
            resultado.add(actual.dato);
            if (actual.izquierda != null) cola.add(actual.izquierda);
            if (actual.derecha   != null) cola.add(actual.derecha);
        }
    }
}

// ================================================================
//  ESTADISTICAS DEL ARBOL
// ================================================================
class Estadisticas {

    public static int contarNodos(Nodo raiz) {
        if (raiz == null) return 0;
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    public static int contarHojas(Nodo raiz) {
        if (raiz == null) return 0;
        if (raiz.izquierda == null && raiz.derecha == null) return 1;
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    public static int calcularAltura(Nodo raiz) {
        if (raiz == null) return 0;
        int altIzq = calcularAltura(raiz.izquierda);
        int altDer = calcularAltura(raiz.derecha);
        return 1 + Math.max(altIzq, altDer);
    }
}

// ================================================================
//  FUNCIONES DE VALIDACION
// ================================================================
class Validacion {

    public static boolean validarInt(Queue<Integer> recorridoReal, List<Integer> ingresado) {
        if (recorridoReal.size() != ingresado.size()) return false;
        Queue<Integer> temp = new LinkedList<>(recorridoReal);
        for (int val : ingresado) {
            if (temp.poll() != val) return false;
        }
        return true;
    }

    public static boolean validarStr(Queue<String> recorridoReal, List<String> ingresado) {
        if (recorridoReal.size() != ingresado.size()) return false;
        Queue<String> temp = new LinkedList<>(recorridoReal);
        for (String w : ingresado) {
            if (!temp.poll().equals(w)) return false;
        }
        return true;
    }
}

// ================================================================
//  CLASE PRINCIPAL
// ================================================================
public class Main {

    // Colas globales con los recorridos calculados
    static Queue<Integer> preEj1  = new LinkedList<>(), inEj1   = new LinkedList<>();
    static Queue<Integer> postEj1 = new LinkedList<>(), bfsEj1  = new LinkedList<>();

    static Queue<Integer> preEj2  = new LinkedList<>(), inEj2   = new LinkedList<>();
    static Queue<Integer> postEj2 = new LinkedList<>(), bfsEj2  = new LinkedList<>();

    static Queue<String>  preTexto  = new LinkedList<>(), inTexto   = new LinkedList<>();
    static Queue<String>  postTexto = new LinkedList<>(), bfsTexto  = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);

    // ── Utilidades de consola ──────────────────────────────
    static void sepLine(char c, int n) {
        for (int i = 0; i < n; i++) System.out.print(c);
        System.out.println();
    }

    static String queueIntStr(Queue<Integer> q) {
        StringBuilder sb = new StringBuilder();
        Queue<Integer> temp = new LinkedList<>(q);
        while (!temp.isEmpty()) {
            sb.append(temp.poll());
            if (!temp.isEmpty()) sb.append(" -> ");
        }
        return sb.toString();
    }

    static String queueStrStr(Queue<String> q) {
        StringBuilder sb = new StringBuilder();
        Queue<String> temp = new LinkedList<>(q);
        while (!temp.isEmpty()) {
            sb.append(temp.poll());
            if (!temp.isEmpty()) sb.append(" -> ");
        }
        return sb.toString();
    }

    static List<Integer> parseInts(String linea) {
        List<Integer> lista = new ArrayList<>();
        for (String tok : linea.trim().split("\\s+")) {
            try { lista.add(Integer.parseInt(tok)); } catch (Exception ignored) {}
        }
        return lista;
    }

    static List<String> parseWords(String linea) {
        List<String> lista = new ArrayList<>();
        for (String tok : linea.trim().split("\\s+")) {
            if (!tok.isEmpty()) lista.add(tok);
        }
        return lista;
    }

    // ── Validacion interactiva numerica ────────────────────
    static void pedirYValidarInt(Queue<Integer> real, String nombre, String pista) {
        System.out.println("\n  Validando: " + nombre);
        System.out.println("  Ingrese los numeros separados por espacios:");
        System.out.println("  (Pista: " + pista + ")");
        System.out.print("  > ");
        String linea = sc.nextLine();
        List<Integer> ingresado = parseInts(linea);
        if (Validacion.validarInt(real, ingresado))
            System.out.println("\n  [OK] Correcto! El recorrido " + nombre + " es exacto.");
        else
            System.out.println("\n  [X]  Incorrecto. Esperado: " + pista);
    }

    // ── Validacion interactiva de texto ────────────────────
    static void pedirYValidarStr(Queue<String> real, String nombre, String pista) {
        System.out.println("\n  Validando: " + nombre);
        System.out.println("  Ingrese los modulos separados por espacios:");
        System.out.println("  (Pista: " + pista + ")");
        System.out.print("  > ");
        String linea = sc.nextLine();
        List<String> ingresado = parseWords(linea);
        if (Validacion.validarStr(real, ingresado))
            System.out.println("\n  [OK] Correcto! El recorrido " + nombre + " es exacto.");
        else
            System.out.println("\n  [X]  Incorrecto. Esperado: " + pista);
    }

    // ================================================================
    //  MAIN
    // ================================================================
    public static void main(String[] args) {

        sepLine('=', 65);
        System.out.println("    RECORRIDOS DE ARBOLES BINARIOS");
        System.out.println("    Universidad Tecnica de Ambato - Estructura de Datos");
        sepLine('=', 65);

        // ----------------------------------------------------------
        //  ARBOL 1: 7 nodos
        //
        //            10
        //           /  \
        //          5    15
        //         / \   / \
        //        2   7 12  20
        // ----------------------------------------------------------
        Nodo raizEj1 = new Nodo(10);
        raizEj1.izquierda            = new Nodo(5);
        raizEj1.derecha              = new Nodo(15);
        raizEj1.izquierda.izquierda  = new Nodo(2);
        raizEj1.izquierda.derecha    = new Nodo(7);
        raizEj1.derecha.izquierda    = new Nodo(12);
        raizEj1.derecha.derecha      = new Nodo(20);

        // ----------------------------------------------------------
        //  ARBOL 2: 11 nodos (arbol extendido, se agregan 4 nodos)
        //
        //              10
        //             /  \
        //            5    15
        //           / \   / \
        //          2   7 12  20
        //         / \      / \
        //        1   3   18  25
        // ----------------------------------------------------------
        Nodo raizEj2 = new Nodo(10);
        raizEj2.izquierda                        = new Nodo(5);
        raizEj2.derecha                          = new Nodo(15);
        raizEj2.izquierda.izquierda              = new Nodo(2);
        raizEj2.izquierda.derecha                = new Nodo(7);
        raizEj2.derecha.izquierda                = new Nodo(12);
        raizEj2.derecha.derecha                  = new Nodo(20);
        raizEj2.izquierda.izquierda.izquierda    = new Nodo(1);
        raizEj2.izquierda.izquierda.derecha      = new Nodo(3);
        raizEj2.derecha.derecha.izquierda        = new Nodo(18);
        raizEj2.derecha.derecha.derecha          = new Nodo(25);

        // ----------------------------------------------------------
        //  ARBOL 3: Modulos del sistema web
        //
        //            Sistema_Web
        //            /          \
        //       Usuarios      Inventario
        //       /      \        /      \
        //  Registrar  Buscar Productos Reportes
        // ----------------------------------------------------------
        NodoTexto sistema                   = new NodoTexto("Sistema_Web");
        sistema.izquierda                   = new NodoTexto("Usuarios");
        sistema.derecha                     = new NodoTexto("Inventario");
        sistema.izquierda.izquierda         = new NodoTexto("Registrar");
        sistema.izquierda.derecha           = new NodoTexto("Buscar");
        sistema.derecha.izquierda           = new NodoTexto("Productos");
        sistema.derecha.derecha             = new NodoTexto("Reportes");

        // Calcular todos los recorridos al inicio
        RecorridosInt.preorden (raizEj1, preEj1);
        RecorridosInt.inorden  (raizEj1, inEj1);
        RecorridosInt.postorden(raizEj1, postEj1);
        RecorridosInt.bfs      (raizEj1, bfsEj1);

        RecorridosInt.preorden (raizEj2, preEj2);
        RecorridosInt.inorden  (raizEj2, inEj2);
        RecorridosInt.postorden(raizEj2, postEj2);
        RecorridosInt.bfs      (raizEj2, bfsEj2);

        RecorridosStr.preorden (sistema, preTexto);
        RecorridosStr.inorden  (sistema, inTexto);
        RecorridosStr.postorden(sistema, postTexto);
        RecorridosStr.bfs      (sistema, bfsTexto);

        // Menu principal
        int opcion;
        do {
            System.out.println();
            sepLine('-', 65);
            System.out.println("                   MENU PRINCIPAL");
            sepLine('-', 65);
            System.out.println("  1. Ejercicio 1 - Arbol original     (10,5,15,2,7,12,20)");
            System.out.println("  2. Ejercicio 2 - Arbol extendido    (+1,3,18,25)");
            System.out.println("  3. Ejercicio 3 - Contar nodos totales");
            System.out.println("  4. Ejercicio 4 - Contar nodos hoja");
            System.out.println("  5. Ejercicio 5 - Caso real: Sistema Web");
            System.out.println("  0. Salir");
            sepLine('-', 65);
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine().trim());

            switch (opcion) {
                case 1: menuEjercicio1(); break;
                case 2: menuEjercicio2(); break;
                case 3: menuEjercicio3(raizEj2); break;
                case 4: menuEjercicio4(raizEj2); break;
                case 5: menuEjercicio5(); break;
                case 0: System.out.println("\nPrograma finalizado."); break;
                default: System.out.println("\nOpcion no valida.");
            }
        } while (opcion != 0);
    }

    // ================================================================
    //  EJERCICIO 1 -- Arbol original (7 nodos)
    // ================================================================
    static void menuEjercicio1() {
        int opcion;
        do {
            System.out.println();
            sepLine('-', 50);
            System.out.println("  Ejercicio 1 - Arbol: 10,5,15,2,7,12,20");
            sepLine('-', 50);
            System.out.println("  1. Validar Preorden");
            System.out.println("  2. Validar Inorden");
            System.out.println("  3. Validar Postorden");
            System.out.println("  4. Validar BFS (niveles)");
            System.out.println("  5. Ver todos los recorridos correctos");
            System.out.println("  0. Volver");
            sepLine('-', 50);
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine().trim());

            switch (opcion) {
                case 1: pedirYValidarInt(preEj1,  "PREORDEN",  "10 5 2 7 15 12 20"); break;
                case 2: pedirYValidarInt(inEj1,   "INORDEN",   "2 5 7 10 12 15 20"); break;
                case 3: pedirYValidarInt(postEj1, "POSTORDEN", "2 7 5 12 20 15 10"); break;
                case 4: pedirYValidarInt(bfsEj1,  "BFS",       "10 5 15 2 7 12 20"); break;
                case 5:
                    System.out.println("\n  Recorridos del arbol original:");
                    System.out.println("  Preorden  : " + queueIntStr(preEj1));
                    System.out.println("  Inorden   : " + queueIntStr(inEj1));
                    System.out.println("  Postorden : " + queueIntStr(postEj1));
                    System.out.println("  BFS       : " + queueIntStr(bfsEj1));
                    break;
                case 0: break;
                default: System.out.println("\nOpcion no valida.");
            }
        } while (opcion != 0);
    }

    // ================================================================
    //  EJERCICIO 2 -- Arbol extendido (11 nodos)
    // ================================================================
    static void menuEjercicio2() {
        int opcion;
        do {
            System.out.println();
            sepLine('-', 55);
            System.out.println("  Ejercicio 2 - Arbol extendido: +1, 3, 18, 25");
            sepLine('-', 55);
            System.out.println("  1. Validar Preorden");
            System.out.println("  2. Validar Inorden");
            System.out.println("  3. Validar Postorden");
            System.out.println("  4. Validar BFS (niveles)");
            System.out.println("  5. Ver todos los recorridos correctos");
            System.out.println("  0. Volver");
            sepLine('-', 55);
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine().trim());

            switch (opcion) {
                case 1: pedirYValidarInt(preEj2,  "PREORDEN",  "10 5 2 1 3 7 15 12 20 18 25"); break;
                case 2: pedirYValidarInt(inEj2,   "INORDEN",   "1 2 3 5 7 10 12 15 18 20 25"); break;
                case 3: pedirYValidarInt(postEj2, "POSTORDEN", "1 3 2 7 5 12 18 25 20 15 10"); break;
                case 4: pedirYValidarInt(bfsEj2,  "BFS",       "10 5 15 2 7 12 20 1 3 18 25"); break;
                case 5:
                    System.out.println("\n  Recorridos del arbol extendido:");
                    System.out.println("  Preorden  : " + queueIntStr(preEj2));
                    System.out.println("  Inorden   : " + queueIntStr(inEj2));
                    System.out.println("  Postorden : " + queueIntStr(postEj2));
                    System.out.println("  BFS       : " + queueIntStr(bfsEj2));
                    break;
                case 0: break;
                default: System.out.println("\nOpcion no valida.");
            }
        } while (opcion != 0);
    }

    // ================================================================
    //  EJERCICIO 3 -- Contar nodos totales y altura
    // ================================================================
    static void menuEjercicio3(Nodo raiz) {
        int total  = Estadisticas.contarNodos(raiz);
        int altura = Estadisticas.calcularAltura(raiz);

        System.out.println();
        sepLine('-', 50);
        System.out.println("  Ejercicio 3 - Conteo de nodos");
        sepLine('-', 50);
        System.out.println("  Total de nodos  : " + total);
        System.out.println("  Altura del arbol: " + altura + " niveles");
        System.out.println();
        System.out.println("  La funcion contarNodos recorre el arbol en postorden,");
        System.out.println("  sumando 1 por cada nodo hasta llegar a null.");
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();
    }

    // ================================================================
    //  EJERCICIO 4 -- Contar hojas e internos
    // ================================================================
    static void menuEjercicio4(Nodo raiz) {
        int total    = Estadisticas.contarNodos(raiz);
        int hojas    = Estadisticas.contarHojas(raiz);
        int internos = total - hojas;

        System.out.println();
        sepLine('-', 50);
        System.out.println("  Ejercicio 4 - Nodos hoja");
        sepLine('-', 50);
        System.out.println("  Nodos totales  : " + total);
        System.out.println("  Nodos hoja     : " + hojas);
        System.out.println("  Nodos internos : " + internos);
        System.out.println();
        System.out.println("  Un nodo es hoja si no tiene hijos izquierdo ni derecho.");
        System.out.println("  Hojas del arbol: 1, 3, 7, 12, 18, 25");
        System.out.println("\nPresione ENTER para continuar...");
        sc.nextLine();
    }

    // ================================================================
    //  EJERCICIO 5 -- Caso real: Sistema Web
    // ================================================================
    static void menuEjercicio5() {
        int opcion;
        do {
            System.out.println();
            sepLine('-', 58);
            System.out.println("  Ejercicio 5 - Caso real: Sistema Web");
            sepLine('-', 58);
            System.out.println("  Estructura del arbol:");
            System.out.println("         Sistema_Web");
            System.out.println("         /          \\");
            System.out.println("     Usuarios     Inventario");
            System.out.println("     /     \\      /        \\");
            System.out.println(" Registrar Buscar Productos Reportes");
            sepLine('-', 58);
            System.out.println("  1. Validar Preorden  (carga del sistema)");
            System.out.println("  2. Validar Inorden   (orden alfabetico)");
            System.out.println("  3. Validar Postorden (validacion de permisos)");
            System.out.println("  4. Validar BFS       (menu por niveles)");
            System.out.println("  5. Ver recorridos correctos");
            System.out.println("  6. Explicacion por recorrido");
            System.out.println("  0. Volver");
            sepLine('-', 58);
            System.out.print("Opcion: ");
            opcion = Integer.parseInt(sc.nextLine().trim());

            switch (opcion) {
                case 1:
                    pedirYValidarStr(preTexto,  "PREORDEN",
                        "Sistema_Web Usuarios Registrar Buscar Inventario Productos Reportes");
                    break;
                case 2:
                    pedirYValidarStr(inTexto,   "INORDEN",
                        "Registrar Usuarios Buscar Sistema_Web Productos Inventario Reportes");
                    break;
                case 3:
                    pedirYValidarStr(postTexto, "POSTORDEN",
                        "Registrar Buscar Usuarios Productos Reportes Inventario Sistema_Web");
                    break;
                case 4:
                    pedirYValidarStr(bfsTexto,  "BFS",
                        "Sistema_Web Usuarios Inventario Registrar Buscar Productos Reportes");
                    break;
                case 5:
                    System.out.println("\n  Recorridos del Sistema Web:");
                    System.out.println("  Preorden  : " + queueStrStr(preTexto));
                    System.out.println("  Inorden   : " + queueStrStr(inTexto));
                    System.out.println("  Postorden : " + queueStrStr(postTexto));
                    System.out.println("  BFS       : " + queueStrStr(bfsTexto));
                    break;
                case 6:
                    System.out.println("\n  Aplicacion de recorridos al Sistema Web:\n");
                    System.out.println("  PREORDEN  -> Carga el modulo raiz primero (Sistema_Web)");
                    System.out.println("               luego los submodulos. Util para inicializar.\n");
                    System.out.println("  INORDEN   -> Lista los modulos en orden alfabetico.");
                    System.out.println("               Util para generar reportes ordenados.\n");
                    System.out.println("  POSTORDEN -> Valida submodulos antes del padre.");
                    System.out.println("               Util para verificar permisos de acceso.\n");
                    System.out.println("  BFS       -> Muestra el menu nivel por nivel.");
                    System.out.println("               Util para construir la interfaz de usuario.");
                    break;
                case 0: break;
                default: System.out.println("\nOpcion no valida.");
            }
        } while (opcion != 0);
    }
}
