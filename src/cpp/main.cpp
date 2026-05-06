/*
 * ================================================================
 *  Universidad Tecnica de Ambato
 *  Carrera  : Ingenieria de Software
 *  Materia  : Estructura de Datos   |   Curso: Tercero B
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

#include <iostream>
#include <queue>
#include <string>
#include <sstream>
#include <vector>
#include <iomanip>
using namespace std;

// ================================================================
//  ESTRUCTURAS DE NODOS
// ================================================================

struct Nodo {
    int dato;
    Nodo* izquierda;
    Nodo* derecha;
    Nodo(int valor) {
        dato      = valor;
        izquierda = nullptr;
        derecha   = nullptr;
    }
};

struct NodoTexto {
    string dato;
    NodoTexto* izquierda;
    NodoTexto* derecha;
    NodoTexto(string valor) {
        dato      = valor;
        izquierda = nullptr;
        derecha   = nullptr;
    }
};

// ================================================================
//  RECORRIDOS -- ARBOL DE ENTEROS
//  Todos los recorridos DFS usan recursividad.
//  La diferencia esta en el MOMENTO en que se visita la raiz.
// ================================================================

// PREORDEN: Raiz -> Izquierda -> Derecha
void preorden(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    resultado.push(raiz->dato);
    preorden(raiz->izquierda, resultado);
    preorden(raiz->derecha, resultado);
}

// INORDEN: Izquierda -> Raiz -> Derecha
// En un BST produce los valores en orden ascendente.
void inorden(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    inorden(raiz->izquierda, resultado);
    resultado.push(raiz->dato);
    inorden(raiz->derecha, resultado);
}

// POSTORDEN: Izquierda -> Derecha -> Raiz
void postorden(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    postorden(raiz->izquierda, resultado);
    postorden(raiz->derecha, resultado);
    resultado.push(raiz->dato);
}

// BFS: Recorrido por niveles usando una cola (sin recursividad)
void bfs(Nodo* raiz, queue<int>& resultado) {
    if (raiz == nullptr) return;
    queue<Nodo*> cola;
    cola.push(raiz);
    while (!cola.empty()) {
        Nodo* actual = cola.front();
        cola.pop();
        resultado.push(actual->dato);
        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha   != nullptr) cola.push(actual->derecha);
    }
}

// ================================================================
//  RECORRIDOS -- ARBOL DE TEXTO
// ================================================================

void preordenTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;
    resultado.push(raiz->dato);
    preordenTexto(raiz->izquierda, resultado);
    preordenTexto(raiz->derecha, resultado);
}

void inordenTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;
    inordenTexto(raiz->izquierda, resultado);
    resultado.push(raiz->dato);
    inordenTexto(raiz->derecha, resultado);
}

void postordenTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;
    postordenTexto(raiz->izquierda, resultado);
    postordenTexto(raiz->derecha, resultado);
    resultado.push(raiz->dato);
}

void bfsTexto(NodoTexto* raiz, queue<string>& resultado) {
    if (raiz == nullptr) return;
    queue<NodoTexto*> cola;
    cola.push(raiz);
    while (!cola.empty()) {
        NodoTexto* actual = cola.front();
        cola.pop();
        resultado.push(actual->dato);
        if (actual->izquierda != nullptr) cola.push(actual->izquierda);
        if (actual->derecha   != nullptr) cola.push(actual->derecha);
    }
}

// ================================================================
//  FUNCIONES DE CONTEO Y ALTURA
// ================================================================

int contarNodos(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    return 1 + contarNodos(raiz->izquierda) + contarNodos(raiz->derecha);
}

int contarHojas(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    if (raiz->izquierda == nullptr && raiz->derecha == nullptr) return 1;
    return contarHojas(raiz->izquierda) + contarHojas(raiz->derecha);
}

int calcularAltura(Nodo* raiz) {
    if (raiz == nullptr) return 0;
    int altIzq = calcularAltura(raiz->izquierda);
    int altDer = calcularAltura(raiz->derecha);
    return 1 + (altIzq > altDer ? altIzq : altDer);
}

// ================================================================
//  FUNCIONES DE VALIDACION
// ================================================================

bool validarRecorridoNumerico(queue<int> recorridoReal, vector<int> ingresado) {
    if (recorridoReal.size() != ingresado.size()) return false;
    queue<int> temp = recorridoReal;
    for (int i = 0; i < (int)ingresado.size(); i++) {
        if (temp.front() != ingresado[i]) return false;
        temp.pop();
    }
    return true;
}

bool validarRecorridoTexto(queue<string> recorridoReal, vector<string> ingresado) {
    if (recorridoReal.size() != ingresado.size()) return false;
    queue<string> temp = recorridoReal;
    for (int i = 0; i < (int)ingresado.size(); i++) {
        if (temp.front() != ingresado[i]) return false;
        temp.pop();
    }
    return true;
}

// ================================================================
//  FUNCIONES AUXILIARES
// ================================================================

string sepLine(char c, int n) {
    return string(n, c);
}

string queueToString(queue<int> q) {
    stringstream ss;
    while (!q.empty()) {
        ss << q.front();
        q.pop();
        if (!q.empty()) ss << " -> ";
    }
    return ss.str();
}

string queueTextoToString(queue<string> q) {
    stringstream ss;
    while (!q.empty()) {
        ss << q.front();
        q.pop();
        if (!q.empty()) ss << " -> ";
    }
    return ss.str();
}

vector<int> splitToInt(string texto) {
    vector<int> resultado;
    stringstream ss(texto);
    int num;
    while (ss >> num) resultado.push_back(num);
    return resultado;
}

vector<string> splitToString(string texto) {
    vector<string> resultado;
    stringstream ss(texto);
    string palabra;
    while (ss >> palabra) resultado.push_back(palabra);
    return resultado;
}

// ================================================================
//  VARIABLES GLOBALES (colas con los recorridos calculados)
// ================================================================
queue<int>    preordenEj1,    inordenEj1,    postordenEj1,    bfsEj1;
queue<int>    preordenEj2,    inordenEj2,    postordenEj2,    bfsEj2;
queue<string> preordenTextoQ, inordenTextoQ, postordenTextoQ, bfsTextoQ;

// ================================================================
//  PROTOTIPOS
// ================================================================
void menuEjercicio1();
void menuEjercicio2();
void menuEjercicio3();
void menuEjercicio4();
void menuEjercicio5();
void pedirYValidarNumerico(queue<int> recorrido, string nombre, string esperado);
void pedirYValidarTexto(queue<string> recorrido, string nombre, string esperado);

// ================================================================
//  MAIN
// ================================================================
int main() {

    cout << sepLine('=', 65) << endl;
    cout << "    RECORRIDOS DE ARBOLES BINARIOS" << endl;
    cout << "    Universidad Tecnica de Ambato - Estructura de Datos" << endl;
    cout << sepLine('=', 65) << endl;

    // ----------------------------------------------------------
    //  ARBOL 1: 7 nodos
    //
    //            10
    //           /  \
    //          5    15
    //         / \   / \
    //        2   7 12  20
    // ----------------------------------------------------------
    Nodo* raizEj1 = new Nodo(10);
    raizEj1->izquierda            = new Nodo(5);
    raizEj1->derecha              = new Nodo(15);
    raizEj1->izquierda->izquierda = new Nodo(2);
    raizEj1->izquierda->derecha   = new Nodo(7);
    raizEj1->derecha->izquierda   = new Nodo(12);
    raizEj1->derecha->derecha     = new Nodo(20);

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
    Nodo* raizEj2 = new Nodo(10);
    raizEj2->izquierda                         = new Nodo(5);
    raizEj2->derecha                           = new Nodo(15);
    raizEj2->izquierda->izquierda              = new Nodo(2);
    raizEj2->izquierda->derecha                = new Nodo(7);
    raizEj2->derecha->izquierda                = new Nodo(12);
    raizEj2->derecha->derecha                  = new Nodo(20);
    raizEj2->izquierda->izquierda->izquierda   = new Nodo(1);
    raizEj2->izquierda->izquierda->derecha     = new Nodo(3);
    raizEj2->derecha->derecha->izquierda       = new Nodo(18);
    raizEj2->derecha->derecha->derecha         = new Nodo(25);

    // ----------------------------------------------------------
    //  ARBOL 3: Modulos del sistema web
    //
    //            Sistema_Web
    //            /          \
    //       Usuarios      Inventario
    //       /      \        /      \
    //  Registrar  Buscar Productos Reportes
    // ----------------------------------------------------------
    NodoTexto* sistema                    = new NodoTexto("Sistema_Web");
    sistema->izquierda                    = new NodoTexto("Usuarios");
    sistema->derecha                      = new NodoTexto("Inventario");
    sistema->izquierda->izquierda         = new NodoTexto("Registrar");
    sistema->izquierda->derecha           = new NodoTexto("Buscar");
    sistema->derecha->izquierda           = new NodoTexto("Productos");
    sistema->derecha->derecha             = new NodoTexto("Reportes");

    // Calcular todos los recorridos al inicio
    preorden (raizEj1, preordenEj1);
    inorden  (raizEj1, inordenEj1);
    postorden(raizEj1, postordenEj1);
    bfs      (raizEj1, bfsEj1);

    preorden (raizEj2, preordenEj2);
    inorden  (raizEj2, inordenEj2);
    postorden(raizEj2, postordenEj2);
    bfs      (raizEj2, bfsEj2);

    preordenTexto (sistema, preordenTextoQ);
    inordenTexto  (sistema, inordenTextoQ);
    postordenTexto(sistema, postordenTextoQ);
    bfsTexto      (sistema, bfsTextoQ);

    // Menu principal
    int opcion;
    do {
        cout << "\n" << sepLine('-', 65) << endl;
        cout << "                   MENU PRINCIPAL" << endl;
        cout << sepLine('-', 65) << endl;
        cout << "  1. Ejercicio 1 - Arbol original     (10,5,15,2,7,12,20)" << endl;
        cout << "  2. Ejercicio 2 - Arbol extendido    (+1,3,18,25)" << endl;
        cout << "  3. Ejercicio 3 - Contar nodos totales" << endl;
        cout << "  4. Ejercicio 4 - Contar nodos hoja" << endl;
        cout << "  5. Ejercicio 5 - Caso real: Sistema Web" << endl;
        cout << "  0. Salir" << endl;
        cout << sepLine('-', 65) << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cin.ignore();

        switch (opcion) {
            case 1: menuEjercicio1(); break;
            case 2: menuEjercicio2(); break;
            case 3: menuEjercicio3(); break;
            case 4: menuEjercicio4(); break;
            case 5: menuEjercicio5(); break;
            case 0: cout << "\nPrograma finalizado.\n"; break;
            default: cout << "\nOpcion no valida.\n";
        }
    } while (opcion != 0);

    return 0;
}

// ================================================================
//  EJERCICIO 1 -- Arbol original (7 nodos)
// ================================================================
void menuEjercicio1() {
    int opcion;
    do {
        cout << "\n" << sepLine('-', 50) << endl;
        cout << "  Ejercicio 1 - Arbol: 10,5,15,2,7,12,20" << endl;
        cout << sepLine('-', 50) << endl;
        cout << "  1. Validar Preorden" << endl;
        cout << "  2. Validar Inorden" << endl;
        cout << "  3. Validar Postorden" << endl;
        cout << "  4. Validar BFS (niveles)" << endl;
        cout << "  5. Ver todos los recorridos correctos" << endl;
        cout << "  0. Volver" << endl;
        cout << sepLine('-', 50) << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cin.ignore();

        switch (opcion) {
            case 1:
                pedirYValidarNumerico(preordenEj1,  "PREORDEN",  "10 5 2 7 15 12 20");
                break;
            case 2:
                pedirYValidarNumerico(inordenEj1,   "INORDEN",   "2 5 7 10 12 15 20");
                break;
            case 3:
                pedirYValidarNumerico(postordenEj1, "POSTORDEN", "2 7 5 12 20 15 10");
                break;
            case 4:
                pedirYValidarNumerico(bfsEj1,       "BFS",       "10 5 15 2 7 12 20");
                break;
            case 5:
                cout << "\n  Recorridos del arbol original:\n";
                cout << "  Preorden  : " << queueToString(preordenEj1)  << endl;
                cout << "  Inorden   : " << queueToString(inordenEj1)   << endl;
                cout << "  Postorden : " << queueToString(postordenEj1) << endl;
                cout << "  BFS       : " << queueToString(bfsEj1)       << endl;
                break;
            case 0: break;
            default: cout << "\nOpcion no valida.\n";
        }
    } while (opcion != 0);
}

// ================================================================
//  EJERCICIO 2 -- Arbol extendido (11 nodos)
// ================================================================
void menuEjercicio2() {
    int opcion;
    do {
        cout << "\n" << sepLine('-', 55) << endl;
        cout << "  Ejercicio 2 - Arbol extendido: +1, 3, 18, 25" << endl;
        cout << sepLine('-', 55) << endl;
        cout << "  1. Validar Preorden" << endl;
        cout << "  2. Validar Inorden" << endl;
        cout << "  3. Validar Postorden" << endl;
        cout << "  4. Validar BFS (niveles)" << endl;
        cout << "  5. Ver todos los recorridos correctos" << endl;
        cout << "  0. Volver" << endl;
        cout << sepLine('-', 55) << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cin.ignore();

        switch (opcion) {
            case 1:
                pedirYValidarNumerico(preordenEj2,  "PREORDEN",  "10 5 2 1 3 7 15 12 20 18 25");
                break;
            case 2:
                pedirYValidarNumerico(inordenEj2,   "INORDEN",   "1 2 3 5 7 10 12 15 18 20 25");
                break;
            case 3:
                pedirYValidarNumerico(postordenEj2, "POSTORDEN", "1 3 2 7 5 12 18 25 20 15 10");
                break;
            case 4:
                pedirYValidarNumerico(bfsEj2,       "BFS",       "10 5 15 2 7 12 20 1 3 18 25");
                break;
            case 5:
                cout << "\n  Recorridos del arbol extendido:\n";
                cout << "  Preorden  : " << queueToString(preordenEj2)  << endl;
                cout << "  Inorden   : " << queueToString(inordenEj2)   << endl;
                cout << "  Postorden : " << queueToString(postordenEj2) << endl;
                cout << "  BFS       : " << queueToString(bfsEj2)       << endl;
                break;
            case 0: break;
            default: cout << "\nOpcion no valida.\n";
        }
    } while (opcion != 0);
}

// ================================================================
//  EJERCICIO 3 -- Contar nodos totales
// ================================================================
void menuEjercicio3() {
    Nodo* raiz = new Nodo(10);
    raiz->izquierda                       = new Nodo(5);
    raiz->derecha                         = new Nodo(15);
    raiz->izquierda->izquierda            = new Nodo(2);
    raiz->izquierda->derecha              = new Nodo(7);
    raiz->derecha->izquierda              = new Nodo(12);
    raiz->derecha->derecha                = new Nodo(20);
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha   = new Nodo(3);
    raiz->derecha->derecha->izquierda     = new Nodo(18);
    raiz->derecha->derecha->derecha       = new Nodo(25);

    int total  = contarNodos(raiz);
    int altura = calcularAltura(raiz);

    cout << "\n" << sepLine('-', 50) << endl;
    cout << "  Ejercicio 3 - Conteo de nodos" << endl;
    cout << sepLine('-', 50) << endl;
    cout << "  Total de nodos : " << total  << endl;
    cout << "  Altura del arbol: " << altura << " niveles" << endl;
    cout << "\n  La funcion contarNodos recorre el arbol en postorden," << endl;
    cout << "  sumando 1 por cada nodo hasta llegar a nullptr." << endl;
    cout << "\nPresione ENTER para continuar...";
    cin.get();
}

// ================================================================
//  EJERCICIO 4 -- Contar hojas
// ================================================================
void menuEjercicio4() {
    Nodo* raiz = new Nodo(10);
    raiz->izquierda                       = new Nodo(5);
    raiz->derecha                         = new Nodo(15);
    raiz->izquierda->izquierda            = new Nodo(2);
    raiz->izquierda->derecha              = new Nodo(7);
    raiz->derecha->izquierda              = new Nodo(12);
    raiz->derecha->derecha                = new Nodo(20);
    raiz->izquierda->izquierda->izquierda = new Nodo(1);
    raiz->izquierda->izquierda->derecha   = new Nodo(3);
    raiz->derecha->derecha->izquierda     = new Nodo(18);
    raiz->derecha->derecha->derecha       = new Nodo(25);

    int hojas    = contarHojas(raiz);
    int total    = contarNodos(raiz);
    int internos = total - hojas;

    cout << "\n" << sepLine('-', 50) << endl;
    cout << "  Ejercicio 4 - Nodos hoja" << endl;
    cout << sepLine('-', 50) << endl;
    cout << "  Nodos totales  : " << total    << endl;
    cout << "  Nodos hoja     : " << hojas    << endl;
    cout << "  Nodos internos : " << internos << endl;
    cout << "\n  Un nodo es hoja si no tiene hijos izquierdo ni derecho." << endl;
    cout << "  Hojas del arbol: 1, 3, 7, 12, 18, 25" << endl;
    cout << "\nPresione ENTER para continuar...";
    cin.get();
}

// ================================================================
//  EJERCICIO 5 -- Caso real: Sistema Web
// ================================================================
void menuEjercicio5() {
    int opcion;
    do {
        cout << "\n" << sepLine('-', 58) << endl;
        cout << "  Ejercicio 5 - Caso real: Sistema Web" << endl;
        cout << sepLine('-', 58) << endl;
        cout << "  Estructura del arbol:" << endl;
        cout << "         Sistema_Web" << endl;
        cout << "         /          \\" << endl;
        cout << "     Usuarios     Inventario" << endl;
        cout << "     /     \\      /        \\" << endl;
        cout << " Registrar Buscar Productos Reportes" << endl;
        cout << sepLine('-', 58) << endl;
        cout << "  1. Validar Preorden  (carga del sistema)" << endl;
        cout << "  2. Validar Inorden   (orden alfabetico)" << endl;
        cout << "  3. Validar Postorden (validacion de permisos)" << endl;
        cout << "  4. Validar BFS       (menu por niveles)" << endl;
        cout << "  5. Ver recorridos correctos" << endl;
        cout << "  6. Explicacion por recorrido" << endl;
        cout << "  0. Volver" << endl;
        cout << sepLine('-', 58) << endl;
        cout << "Opcion: ";
        cin >> opcion;
        cin.ignore();

        switch (opcion) {
            case 1:
                pedirYValidarTexto(preordenTextoQ,  "PREORDEN",
                    "Sistema_Web Usuarios Registrar Buscar Inventario Productos Reportes");
                break;
            case 2:
                pedirYValidarTexto(inordenTextoQ,   "INORDEN",
                    "Registrar Usuarios Buscar Sistema_Web Productos Inventario Reportes");
                break;
            case 3:
                pedirYValidarTexto(postordenTextoQ, "POSTORDEN",
                    "Registrar Buscar Usuarios Productos Reportes Inventario Sistema_Web");
                break;
            case 4:
                pedirYValidarTexto(bfsTextoQ,       "BFS",
                    "Sistema_Web Usuarios Inventario Registrar Buscar Productos Reportes");
                break;
            case 5:
                cout << "\n  Recorridos del Sistema Web:\n";
                cout << "  Preorden  : " << queueTextoToString(preordenTextoQ)  << endl;
                cout << "  Inorden   : " << queueTextoToString(inordenTextoQ)   << endl;
                cout << "  Postorden : " << queueTextoToString(postordenTextoQ) << endl;
                cout << "  BFS       : " << queueTextoToString(bfsTextoQ)       << endl;
                break;
            case 6:
                cout << "\n  Aplicacion de recorridos al Sistema Web:\n\n";
                cout << "  PREORDEN  -> Carga el modulo raiz primero (Sistema_Web)" << endl;
                cout << "               luego los submodulos. Util para inicializar.\n" << endl;
                cout << "  INORDEN   -> Lista los modulos en orden alfabetico." << endl;
                cout << "               Util para generar reportes ordenados.\n" << endl;
                cout << "  POSTORDEN -> Valida submodulos antes del padre." << endl;
                cout << "               Util para verificar permisos de acceso.\n" << endl;
                cout << "  BFS       -> Muestra el menu nivel por nivel." << endl;
                cout << "               Util para construir la interfaz de usuario." << endl;
                break;
            case 0: break;
            default: cout << "\nOpcion no valida.\n";
        }
    } while (opcion != 0);
}

// ================================================================
//  VALIDACION INTERACTIVA -- NUMEROS
// ================================================================
void pedirYValidarNumerico(queue<int> recorrido, string nombre, string esperado) {
    cout << "\n  Validando: " << nombre << endl;
    cout << "  Ingrese los numeros separados por espacios:\n";
    cout << "  (Pista: " << esperado << ")\n";
    cout << "  > ";
    string linea;
    getline(cin, linea);
    vector<int> ingresado = splitToInt(linea);
    if (validarRecorridoNumerico(recorrido, ingresado)) {
        cout << "\n  [OK] Correcto! El recorrido " << nombre << " es exacto." << endl;
    } else {
        cout << "\n  [X]  Incorrecto. Esperado: " << esperado << endl;
    }
}

// ================================================================
//  VALIDACION INTERACTIVA -- TEXTO
// ================================================================
void pedirYValidarTexto(queue<string> recorrido, string nombre, string esperado) {
    cout << "\n  Validando: " << nombre << endl;
    cout << "  Ingrese los modulos separados por espacios:\n";
    cout << "  (Pista: " << esperado << ")\n";
    cout << "  > ";
    string linea;
    getline(cin, linea);
    vector<string> ingresado = splitToString(linea);
    if (validarRecorridoTexto(recorrido, ingresado)) {
        cout << "\n  [OK] Correcto! El recorrido " << nombre << " es exacto." << endl;
    } else {
        cout << "\n  [X]  Incorrecto. Esperado: " << esperado << endl;
    }
}
