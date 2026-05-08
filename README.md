# Recorridos de Arboles Binarios - Estructura de Datos

**Universidad Tecnica de Ambato**  
**Carrera:** Ingenieria de Software  
**Asignatura:** Estructura de Datos  
**Curso:** Tercero B  
**Tema:** Recorridos de arboles binarios: Inorden, Preorden, Postorden y BFS  

---

## Objetivo general

Implementar y analizar los principales recorridos de arboles binarios usando C++ y Java, aplicando estructuras de datos dinamicas, recursividad y colas.

## Objetivos especificos

- Implementar los recorridos Inorden, Preorden, Postorden y BFS en arboles binarios usando recursividad en C++ y Java, comprendiendo el orden de visita de cada uno.
- Aplicar el recorrido BFS mediante el uso de una cola para explorar el arbol nivel por nivel, diferenciando su comportamiento frente a los recorridos DFS.
- Adaptar los recorridos de arboles binarios a un caso real de inventario de tienda tecnologica, demostrando su utilidad practica en la organizacion y busqueda de datos.

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
|-- capturas/               <- Capturas de ejecucion en consola
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

## Capturas de ejecucion

Las capturas de pantalla de cada ejercicio ejecutado en consola se encuentran en la carpeta `/capturas/`:

| Archivo | Descripcion |
|---|---|
| `00_menuprincipal.png` | Menu principal del programa |
| `01_recorridosdel arboloriginal.png` | Recorridos arbol original (7 nodos) |
| `02_recorridosdelarbolextendido.png` | Recorridos arbol extendido (11 nodos) |
| `03_contarnodostotalesyaltura.png` | Conteo de nodos totales y altura |
| `04_contarnodoshojaeinternos.png` | Conteo de hojas e internos |
| `05_casoreal.png` | Caso real: Sistema Web |
| `05_casorealexplicacionporrecorridos.png` | Explicacion de recorridos |
| `05_casorealrecorridosdelsistemaweb.png` | Recorridos del sistema web |

---

## Uso de Inteligencia Artificial

Durante el desarrollo de esta practica se utilizo **Copilot** como herramienta de apoyo de Inteligencia Artificial para:

- Analizar la estructura del repositorio base.
- Comprender los requerimientos de la tarea.
- Apoyar en la combinacion y organizacion del codigo C++ en un unico archivo `main.cpp`.
- Apoyar en la combinacion y organizacion del codigo Java en un unico archivo `Main.java`.
- Verificar que el orden de cada recorrido estuviera claro y correctamente implementado.
- Revisar que los comentarios del codigo fueran claros y explicaran correctamente el funcionamiento de cada recorrido.
- Un gran apoyo por parte de Copilot en la generacion de sugerencias, organizacion del codigo y correccion de errores durante el desarrollo de la tarea.

> El codigo fue revisado, compilado y ejecutado personalmente para verificar su correcto funcionamiento antes de ser subido al repositorio.

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

## Conclusiones

- Los recorridos DFS (Inorden, Preorden, Postorden) y BFS tienen propositos distintos: Inorden es ideal para listar datos ordenados, mientras que BFS permite visualizar la jerarquia del arbol nivel por nivel.
- La implementacion en C++ y Java demuestra que la logica de los recorridos es independiente del lenguaje, variando unicamente la sintaxis y el manejo de memoria.
- Al aplicar los recorridos a un caso real de sistema web, se evidencia que los arboles binarios son estructuras eficientes para organizar, navegar y procesar modulos de software jerarquico.

## Recomendaciones

- Liberar la memoria dinamica en C++ al finalizar el programa usando funciones postorden de eliminacion, ya que cada `new Nodo` sin su correspondiente `delete` genera fugas de memoria.
- Ampliar la practica implementando operaciones de busqueda y eliminacion de nodos en el BST, para reforzar el dominio completo de la estructura mas alla de los recorridos.
- Documentar con capturas de pantalla cada recorrido ejecutado en consola y subirlas al repositorio GitHub, mejorando la presentacion de la rubrica.

---

## Rubrica (3 puntos)

| Criterio                              | Puntaje  |
|---------------------------------------|----------|
| Implementacion correcta de recorridos | 1 pt     |
| Uso correcto de recursividad y cola   | 0.5 pts  |
| Codigo comentado y organizado         | 0.5 pts  |
| Aplicacion al proyecto final          | 0.75 pts |
| Uso de GitHub e IA documentada        | 0.25 pts |

---

## Referencias bibliograficas

Shaw, J. (s.f.). *Binary trees: Discussing in-depth first traversals*. DEV Community. Disponible en: https://dev.to/jenshaw/binary-trees-discussing-in-depth-first-traversals-4a8n

EnjoyAlgorithms. (s.f.). *Binary tree traversals: Preorder, inorder, postorder*. Disponible en: https://www.enjoyalgorithms.com/blog/binary-tree-traversals-preorder-inorder-postorder

Tutoriales Programacion Ya. (s.f.). *Arboles binarios en C++ - Tema 5*. Disponible en: https://www.tutorialesprogramacionya.com/estructurasdedatos/arbolesbinariosc/tema5.html

Java Code Basics. (2013, marzo). *Arboles en Java: Recorrido preorden*. Disponible en: https://javacodebasics.blogspot.com/2013/03/arboles-en-java-recorrido-preorden.html

Ciberaula. (s.f.). *Exploracion de arboles en Java*. Disponible en: https://www.ciberaula.com/cursos/java/exploracion_arboles.php

Ciberaula. (s.f.). *Arboles en Java*. Disponible en: https://www.ciberaula.com/cursos/java/arboles_java.php#que-es
