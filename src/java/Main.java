/*
 * ============================================================
 *  Universidad Técnica de Ambato
 *  Carrera: Ingeniería de Software
 *  Asignatura: Estructura de Datos
 *  Tema: Recorridos de Árboles Binarios - Java
 *  Recorridos: Inorden, Preorden, Postorden y BFS
 * ============================================================
 *
 *  Caso de aplicación real: Sistema de gestión de inventario
 *  de una tienda de tecnología. Los productos se organizan en
 *  un árbol binario de búsqueda por código de producto.
 * ============================================================
 */

import java.util.LinkedList;
import java.util.Queue;

// ── Clase Nodo ───────────────────────────────────────────────
class Nodo {
    int codigo;
    String nombre;
    double precio;
    Nodo izquierda, derecha;

    public Nodo(int codigo, String nombre, double precio) {
        this.codigo    = codigo;
        this.nombre    = nombre;
        this.precio    = precio;
        this.izquierda = null;
        this.derecha   = null;
    }
}

// ── Clase ArbolBinario ───────────────────────────────────────
class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // ── Inserción recursiva ──────────────────────────────────
    private Nodo insertar(Nodo nodo, int cod, String nom, double prec) {
        if (nodo == null)
            return new Nodo(cod, nom, prec);

        if (cod < nodo.codigo)
            nodo.izquierda = insertar(nodo.izquierda, cod, nom, prec);
        else if (cod > nodo.codigo)
            nodo.derecha = insertar(nodo.derecha, cod, nom, prec);
        else
            System.out.println("  [!] Código " + cod + " ya existe.");

        return nodo;
    }

    public void insertar(int cod, String nom, double prec) {
        raiz = insertar(raiz, cod, nom, prec);
    }

    // ── Formato de fila ──────────────────────────────────────
    private String fila(Nodo n) {
        return String.format("  [%4d]  %-22s $%.2f", n.codigo, n.nombre, n.precio);
    }

    // ── INORDEN: Izquierda → Raíz → Derecha ─────────────────
    private void inorden(Nodo nodo) {
        if (nodo == null) return;
        inorden(nodo.izquierda);
        System.out.println(fila(nodo));
        inorden(nodo.derecha);
    }

    public void mostrarInorden() {
        System.out.println("\n  Codigo   Nombre                  Precio");
        System.out.println("  " + "-".repeat(44));
        inorden(raiz);
    }

    // ── PREORDEN: Raíz → Izquierda → Derecha ────────────────
    private void preorden(Nodo nodo) {
        if (nodo == null) return;
        System.out.println(fila(nodo));
        preorden(nodo.izquierda);
        preorden(nodo.derecha);
    }

    public void mostrarPreorden() {
        System.out.println("\n  Codigo   Nombre                  Precio");
        System.out.println("  " + "-".repeat(44));
        preorden(raiz);
    }

    // ── POSTORDEN: Izquierda → Derecha → Raíz ───────────────
    private void postorden(Nodo nodo) {
        if (nodo == null) return;
        postorden(nodo.izquierda);
        postorden(nodo.derecha);
        System.out.println(fila(nodo));
    }

    public void mostrarPostorden() {
        System.out.println("\n  Codigo   Nombre                  Precio");
        System.out.println("  " + "-".repeat(44));
        postorden(raiz);
    }

    // ── BFS: Recorrido por niveles usando Queue ──────────────
    public void mostrarBFS() {
        if (raiz == null) {
            System.out.println("  El árbol está vacío.");
            return;
        }

        System.out.println("\n  Codigo   Nombre                  Precio");
        System.out.println("  " + "-".repeat(44));

        Queue<Nodo> cola = new LinkedList<>();
        cola.add(raiz);
        int nivel = 0;

        while (!cola.isEmpty()) {
            int tam = cola.size(); // cantidad de nodos en el nivel actual
            System.out.println("  -- Nivel " + nivel + " --");

            for (int i = 0; i < tam; i++) {
                Nodo actual = cola.poll();
                System.out.println(fila(actual));

                if (actual.izquierda != null) cola.add(actual.izquierda);
                if (actual.derecha   != null) cola.add(actual.derecha);
            }
            nivel++;
        }
    }
}

// ── Clase principal ──────────────────────────────────────────
public class Main {

    static void encabezado(String titulo) {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  " + titulo);
        System.out.println("=".repeat(50));
    }

    public static void main(String[] args) {

        System.out.println();
        System.out.println("  ╔══════════════════════════════════════════════╗");
        System.out.println("  ║   Recorridos de Árboles Binarios - Java      ║");
        System.out.println("  ║   Caso: Inventario de Tienda de Tecnología   ║");
        System.out.println("  ║   Universidad Técnica de Ambato              ║");
        System.out.println("  ╚══════════════════════════════════════════════╝");

        ArbolBinario inventario = new ArbolBinario();

        // ── Insertar productos (mínimo 10 nodos) ─────────────
        System.out.println("\n  Cargando inventario...");
        inventario.insertar(500, "Laptop HP 15\"",       899.99);
        inventario.insertar(300, "Teclado Mecánico",      75.50);
        inventario.insertar(700, "Monitor 27\" 4K",      450.00);
        inventario.insertar(200, "Mouse Inalámbrico",     29.99);
        inventario.insertar(400, "Audífonos Bluetooth",   89.00);
        inventario.insertar(600, "Webcam 1080p",          59.99);
        inventario.insertar(800, "SSD 1TB NVMe",         110.00);
        inventario.insertar(150, "Hub USB-C 7 puertos",   45.00);
        inventario.insertar(350, "Pad Mouse XL",          18.00);
        inventario.insertar(650, "Micrófono Condensador", 95.00);
        inventario.insertar(750, "Tarjeta Gráfica RTX", 1200.00);
        inventario.insertar(550, "RAM DDR5 32GB",        145.00);
        System.out.println("  12 productos cargados correctamente.");

        // ── Recorrido 1: INORDEN ─────────────────────────────
        encabezado("1. INORDEN (Izquierda -> Raiz -> Derecha)");
        System.out.println("  Uso: Lista productos en orden ascendente por codigo.");
        System.out.println("  Ideal para mostrar el catalogo ordenado.");
        inventario.mostrarInorden();

        // ── Recorrido 2: PREORDEN ────────────────────────────
        encabezado("2. PREORDEN (Raiz -> Izquierda -> Derecha)");
        System.out.println("  Uso: Copia la estructura del arbol.");
        System.out.println("  Ideal para serializar o clonar el arbol.");
        inventario.mostrarPreorden();

        // ── Recorrido 3: POSTORDEN ───────────────────────────
        encabezado("3. POSTORDEN (Izquierda -> Derecha -> Raiz)");
        System.out.println("  Uso: Procesa hijos antes que el padre.");
        System.out.println("  Ideal para calcular totales o liberar memoria.");
        inventario.mostrarPostorden();

        // ── Recorrido 4: BFS ─────────────────────────────────
        encabezado("4. BFS - Recorrido por Niveles (Cola)");
        System.out.println("  Uso: Explora el arbol nivel por nivel.");
        System.out.println("  Ideal para ver la jerarquia de categorias.");
        inventario.mostrarBFS();

        // ── Resumen final ─────────────────────────────────────
        System.out.println("\n" + "=".repeat(50));
        System.out.println("  RESUMEN DE RECORRIDOS");
        System.out.println("=".repeat(50));
        System.out.println("  Inorden   -> Productos en orden de codigo");
        System.out.println("  Preorden  -> Estructura completa del arbol");
        System.out.println("  Postorden -> Procesamiento desde hojas");
        System.out.println("  BFS       -> Vista por niveles / jerarquia");
        System.out.println("=".repeat(50));
        System.out.println();
    }
}