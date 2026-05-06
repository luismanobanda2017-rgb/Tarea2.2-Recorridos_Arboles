# Ejercicios - Recorridos de Árboles Binarios

**Universidad Técnica de Ambato | Estructura de Datos | Tercero B**

---

## Ejercicio 1 – Dado el árbol, escribe los recorridos

Dado el siguiente árbol binario:

```
          50
         /   \
       30     70
      /  \   /  \
    20   40 60   80
              \
              65
```

Completa la tabla:

| Recorrido  | Resultado esperado |
|------------|--------------------|
| Inorden    | __________________ |
| Preorden   | __________________ |
| Postorden  | __________________ |
| BFS        | __________________ |

**Respuestas:**

- **Inorden:** 20, 30, 40, 50, 60, 65, 70, 80
- **Preorden:** 50, 30, 20, 40, 70, 60, 65, 80
- **Postorden:** 20, 40, 30, 65, 60, 80, 70, 50
- **BFS:** 50 | 30, 70 | 20, 40, 60, 80 | 65

---

## Ejercicio 2 – Reconstruir el árbol

Dado:
- **Preorden:** 10, 5, 3, 7, 15, 12, 20
- **Inorden:** 3, 5, 7, 10, 12, 15, 20

Dibuja el árbol resultante y escribe su recorrido Postorden.

**Árbol:**
```
           10
          /   \
         5    15
        / \   / \
       3   7 12  20
```

**Postorden:** 3, 7, 5, 12, 20, 15, 10

---

## Ejercicio 3 – Implementación grupal (C++ o Java)

Construye un árbol binario de búsqueda con los siguientes datos de **estudiantes** (clave: número de cédula abreviado):

| Cédula (clave) | Nombre           |
|----------------|------------------|
| 500            | Ana Torres       |
| 300            | Luis Pérez       |
| 700            | Sofía Ramírez    |
| 200            | Carlos Moreta    |
| 400            | Valeria Chávez   |
| 600            | Diego Salazar    |
| 800            | Paola Montoya    |

**Tareas:**
1. Implementar el BST con los datos de estudiantes.
2. Mostrar los 4 recorridos (Inorden, Preorden, Postorden, BFS).
3. Agregar 3 estudiantes más al árbol.
4. Mostrar nuevamente los recorridos.
5. Explicar en qué orden aparecen los estudiantes en cada recorrido y por qué.

---

## Ejercicio 4 – Análisis de complejidad

Completa la tabla de complejidad temporal:

| Operación            | Mejor caso | Peor caso |
|----------------------|------------|-----------|
| Insertar en BST      | O(log n)   | O(n)      |
| Inorden              | O(n)       | O(n)      |
| Preorden             | O(n)       | O(n)      |
| Postorden            | O(n)       | O(n)      |
| BFS                  | O(n)       | O(n)      |
| Buscar en BST        | O(log n)   | O(n)      |

**Pregunta de reflexión:** ¿Cuándo el peor caso de inserción en un BST es O(n)? ¿Cómo se soluciona?

> **Respuesta:** Ocurre cuando los datos se insertan en orden ascendente o descendente, generando un árbol degenerado (lista enlazada). Se soluciona con árboles balanceados como AVL o Red-Black Trees.

---

## Ejercicio 5 – Caso de aplicación al proyecto final

Cada grupo debe:

1. **Identificar** una entidad de su proyecto final que pueda organizarse en un árbol binario (productos, clientes, pedidos, categorías, etc.).
2. **Definir** la clave de búsqueda (código, ID, precio, etc.).
3. **Implementar** un BST con mínimo 8 nodos de su entidad.
4. **Aplicar** los 4 recorridos y explicar qué utilidad tiene cada uno en su contexto.
5. **Documentar** el caso en el README del repositorio grupal.

**Ejemplo de aplicación:**  
_Tienda de tecnología → árbol por código de producto → Inorden muestra catálogo ordenado, BFS muestra jerarquía de categorías._

---

## Rúbrica de evaluación

| Criterio                              | Puntaje |
|---------------------------------------|---------|
| Implementación correcta de recorridos | 3 pts   |
| Uso correcto de recursividad y cola   | 2 pts   |
| Código comentado y organizado         | 1.5 pts |
| Aplicación al proyecto final          | 2 pts   |
| Uso de GitHub e IA documentada        | 1.5 pts |
| **Total**                             | **10 pts** |
