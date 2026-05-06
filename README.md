# Recorridos de Arboles Binarios - Estructura de Datos

**Universidad Tecnica de Ambato**  
**Carrera:** Ingenieria de Software  
**Asignatura:** Estructura de Datos  
**Curso:** Tercero B  
**Tema:** Recorridos de arboles binarios: Inorden, Preorden, Postorden y BFS

---

## Objetivo general

Implementar y analizar los principales recorridos de arboles binarios usando C++ y Java, aplicando estructuras de datos dinamicas, recursividad y colas.

## Resultados de aprendizaje

Al finalizar la practica, el estudiante sera capaz de:

1. Explicar la diferencia entre recorridos DFS y BFS.
2. Implementar recorridos Inorden, Preorden y Postorden con recursividad.
3. Implementar BFS usando una cola.
4. Comparar la implementacion en C++ y Java.
5. Aplicar recorridos de arboles a un caso real del proyecto final.

---

## Estructura del proyecto

```
Tarea2.2-Recorridos_Arboles/
|-- src/
|   |-- cpp/
|   |   `-- main.cpp        <- Implementacion C++ con menu interactivo
|   `-- java/
|       `-- Main.java       <- Implementacion Java equivalente
|-- docs/
|   `-- guia_practica.md    <- Guia de clase con conceptos y ejemplos
|-- exercises/
|   `-- ejercicios_grupales.md
|-- moodle/
|   `-- banco_preguntas.md
|-- .gitignore
|-- LICENSE
`-- README.md
```

---

## Arboles implementados

### Arbol 1 - Base (7 nodos)
```
          10
         /  \
        5    15
       / \   / \
      2   7 12  20
```

### Arbol 2 - Extendido (11 nodos)
```
              10
             /  \
            5    15
           / \   / \
          2   7 12  20
         / \      / \
        1   3   18  25
```

### Arbol 3 - Sistema Web (texto, 7 nodos)
```
          Sistema_Web
          /          \
      Usuarios     Inventario
      /     \       /       \
  Registrar Buscar Productos Reportes
```

---

## Reglas de recorrido

| Recorrido  | Orden                           | Implementacion  |
|------------|---------------------------------|-----------------|
| Inorden    | Izquierda -> Raiz -> Derecha    | Recursividad    |
| Preorden   | Raiz -> Izquierda -> Derecha    | Recursividad    |
| Postorden  | Izquierda -> Derecha -> Raiz    | Recursividad    |
| BFS        | Nivel por nivel (cola)          | Cola iterativa  |

---

## Ejercicios del programa

| # | Descripcion                          |
|---|--------------------------------------|
| 1 | Recorridos del arbol original        |
| 2 | Recorridos del arbol extendido       |
| 3 | Contar nodos totales y altura        |
| 4 | Contar nodos hoja e internos         |
| 5 | Caso real: Sistema Web como arbol    |

---

## Ejecucion en C++

```bash
cd src/cpp
g++ main.cpp -o recorridos
./recorridos
```

## Ejecucion en Java

```bash
cd src/java
javac Main.java
java Main
```

---

## Caso de aplicacion real

Se modelo un sistema web universitario como arbol binario. Cada nodo representa un modulo del sistema. Los recorridos sirven para:

- **Preorden** - Inicializar el sistema (carga el modulo raiz primero)
- **Inorden** - Listar modulos en orden alfabetico
- **Postorden** - Validar permisos desde los submodulos hacia arriba
- **BFS** - Construir el menu de navegacion nivel por nivel

---

## Actividad sugerida

1. Clonar el repositorio.
2. Ejecutar el codigo base.
3. Agregar minimo 5 nodos nuevos.
4. Mostrar los cuatro recorridos.
5. Modificar el caso de aplicacion al proyecto final del grupo.
6. Subir evidencias al repositorio GitHub del grupo.

---

## Entregables

- Captura de ejecucion en consola.
- Codigo fuente comentado.
- README del grupo.
- Explicacion del caso real.
- Link del repositorio GitHub.

---

## Rubrica (10 puntos)

| Criterio                              | Puntaje |
|---------------------------------------|---------|
| Implementacion correcta de recorridos | 3 pts   |
| Uso correcto de recursividad y cola   | 2 pts   |
| Codigo comentado y organizado         | 1.5 pts |
| Aplicacion al proyecto final          | 2 pts   |
| Uso de GitHub e IA documentada        | 1.5 pts |
