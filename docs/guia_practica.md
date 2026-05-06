# Guía Práctica – Recorridos de Árboles Binarios

**Universidad Técnica de Ambato**  
**Carrera:** Ingeniería de Software | **Asignatura:** Estructura de Datos | **Curso:** Tercero B

---

## 1. Conceptos clave

### ¿Qué es un árbol binario?

Un **árbol binario** es una estructura de datos no lineal donde cada nodo tiene como máximo **dos hijos**: izquierdo y derecho. Se usa para representar jerarquías, tomar decisiones y organizar datos para búsqueda eficiente.

```
         [Raíz]
        /       \
   [Hijo-I]   [Hijo-D]
    /    \       /    \
[H-II] [H-ID] [H-DI] [H-DD]
```

### ¿Qué es un BST (Binary Search Tree)?

En un **árbol binario de búsqueda**, para cada nodo se cumple:
- Todo valor del subárbol **izquierdo** es **menor** que el nodo.
- Todo valor del subárbol **derecho** es **mayor** que el nodo.

Esto garantiza búsquedas en O(log n) en el caso promedio.

---

## 2. Los cuatro recorridos

### DFS – Búsqueda en profundidad (usa recursividad o pila)

| Recorrido  | Orden de visita                  | Uso típico                         |
|------------|----------------------------------|------------------------------------|
| Inorden    | Izquierda → Raíz → Derecha       | Listar en orden ascendente (BST)   |
| Preorden   | Raíz → Izquierda → Derecha       | Copiar / serializar el árbol       |
| Postorden  | Izquierda → Derecha → Raíz       | Liberar memoria / calcular totales |

### BFS – Búsqueda en amplitud (usa una cola)

| Recorrido | Orden de visita        | Uso típico                          |
|-----------|------------------------|-------------------------------------|
| BFS       | Nivel por nivel        | Ver jerarquía, camino más corto     |

---

## 3. Ejemplo paso a paso

Árbol de ejemplo con los valores: 50, 30, 70, 20, 40, 60, 80

```
          50
         /  \
       30    70
      / \   / \
    20  40 60  80
```

**Inorden:** 20 → 30 → 40 → **50** → 60 → 70 → 80  
**Preorden:** **50** → 30 → 20 → 40 → 70 → 60 → 80  
**Postorden:** 20 → 40 → 30 → 60 → 80 → 70 → **50**  
**BFS (por niveles):** 50 | 30, 70 | 20, 40, 60, 80

---

## 4. Implementación en pseudocódigo

```
// INORDEN
inorden(nodo):
    si nodo es null → retornar
    inorden(nodo.izquierda)
    visitar(nodo)
    inorden(nodo.derecha)

// PREORDEN
preorden(nodo):
    si nodo es null → retornar
    visitar(nodo)
    preorden(nodo.izquierda)
    preorden(nodo.derecha)

// POSTORDEN
postorden(nodo):
    si nodo es null → retornar
    postorden(nodo.izquierda)
    postorden(nodo.derecha)
    visitar(nodo)

// BFS
bfs(raiz):
    cola.agregar(raiz)
    mientras cola no esté vacía:
        nodo = cola.sacar()
        visitar(nodo)
        si nodo.izquierda ≠ null → cola.agregar(nodo.izquierda)
        si nodo.derecha ≠ null   → cola.agregar(nodo.derecha)
```

---

## 5. Diferencia DFS vs BFS

| Característica     | DFS (Inorden/Pre/Post) | BFS                     |
|--------------------|------------------------|-------------------------|
| Estructura usada   | Pila (implícita)       | Cola (explícita)        |
| Orden de visita    | Profundidad primero    | Amplitud primero        |
| Memoria usada      | O(h) — altura          | O(w) — ancho máximo     |
| Uso común          | Buscar, ordenar, copiar| Niveles, camino más corto|

---

## 6. Complejidad

| Operación     | Tiempo    | Espacio   |
|---------------|-----------|-----------|
| Todos los recorridos | O(n) | O(h) DFS / O(w) BFS |
| Inserción BST (promedio) | O(log n) | O(1) |
| Inserción BST (peor caso) | O(n) | O(1) |

Donde **n** = número de nodos, **h** = altura del árbol, **w** = ancho máximo.

---

## 7. Instrucciones de ejecución

### C++
```bash
cd src/cpp
g++ main.cpp -o recorridos
./recorridos
```

### Java
```bash
cd src/java
javac Main.java
java Main
```

---

## 8. Actividad de clase

1. Clonar el repositorio.
2. Compilar y ejecutar el código base en C++ o Java.
3. Agregar mínimo 5 nodos nuevos al árbol.
4. Verificar que los 4 recorridos se actualizan correctamente.
5. Adaptar el caso de aplicación a su proyecto final del grupo.
6. Documentar el uso de IA (si se usó) en el README del grupo.
7. Subir evidencias (capturas de pantalla + código) al repositorio GitHub del grupo.
