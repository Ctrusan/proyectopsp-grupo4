# uCalendar

![Portada](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Calendario.jpg)

Este trabajo está realizado por **José Palacios Montes y Carlos Trujillo García** para la asignatura de **Programación de Servicios y Procesos**, curso 2019 - 2020. Este proyecto está bajo una licencia de *Creative Commons Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional*. 

![Licencia](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Licencia.png)

# Índice

[1. Definición del problema.](#1)
<br>
[2. Análisis de requisitos funcionales.](#2)
<br>
[3. Modelo de objetos de negocio](#3)
<br>
[4. Interfaz gráfica](#4)
<br>
[5. Diagramas de secuencia](#5)

<a name="1"></a>
# Definición del problema.

Nuestra aplicación consistirá en un entorno que englobará calendarios en función de la cantidad de cursos que le darán uso a la app. También estaría la opción de añadir calendarios propios de las asignaturas del curso. En éstos, los profesores podrán añadir a los días lo siguiente: tareas, exámenes, trabajos, excursiones, días en los que el profesor o profesora no va a asistir por x cuestión, etcétera. Los alumnos, por otro lado, podrán visualizar los cambios que realicen los profesores al momento. Habrá una opción de correo/chat para preguntar dudas o proponer algún cambio.

<a name="2"></a>
# Análisis de requisitos funcionales.

## Casos de uso.

![Casos de uso](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Casos%20de%20uso%20modificado%202.png)

## Anexo.

| Sintaxis del método | Explicación |
| -- | -- |
| inciarSesion() | A la hora de iniciar sesión se comprobarán los datos introducidos en una base de datos que almacenará todos los usuarios (tanto alumnos como profesores) disponibles. Si el usuario existe y es correcta la contraseña se accederá a la aplicación por la vista "VistaCalendarioAlumno" si es alumno y si es profesor entrará en por la vista "VistaCalendarioProfesor". |
| verCalendario() | El usuario seleccionará unos de los calendarios disponibles y esto dará acceso al método en cuestión, por lo que abrirá la vista "VistaDelCalendario" mostrando los datos del calendario seleccionado previamente. |
| crearCalendario() | Solo se interactúa con este método habiendo entrado previamente como profesor a través del método "verCalendario". Una vez cumplido lo anterior, el método se activará pulsando un botón "Crear calendario" que abrirá una nueva vista llamada "VistaCrearCalendario", la cual tendremos que rellenar con los datos necesarios y confirmar para que se cree el nuevo calendario. |
| crearDuda() | Solo se interactúa con este método habiendo entrado previamente como alumno. Se debe de entrar en la vista de "VistaEnviarYConsultarDudas" a través de un botón "Dudas" y una vez dentro, al pulsar el botón "Crear", nos abrirá una nueva ventana con unos campos a rellenar para posteriormente enviar la duda creada. |
| enviarDuda() | Solo se interactúa con este método habiendo entrado previamente como alumno. Tras haber interactuado con el método "crearDuda" este método enviará la duda creada con el método anterior a una base de datos que almacenará todas las dudas existentes. |
| verDudas() | Se debe de entrar en la vista de "VerYEnviarDudas" a través de un botón "Dudas". Dependiendo de si has entrado previamente como alumno o profesor, se te llevará a una ventana u otra; si eres alumno se accederá a la vista "vistaEnviarYConsultarDudas()" mostrando una lista de las dudas existentes y al seleccionar una de ellas se mostrarán los datos de esa duda, si eres profesor se accede a la vista "vistaResponderDudas" mostrando en una lista las dudas enviadas por los alumnos. |
| verSiguienteDuda() | Solo se interactúa con este método habiendo entrado previamente como profesor a través del método "verDudas". Para utilizarlo previamente habrá que seleccionar una de las dudas de la lista y si pulsamos en el botón "Siguiente" se activará el método en cuestión y se actualizarán los datos con la siguiente duda en caso de que haya alguna. | 
|              | 3.- Se abre una nueva ventana con un apartado para escribir la duda y un botón para enviarla. |
|              | 4.- Enviar duda o pregunta.
| Postcondicionales | La duda le llega al profesor correspondiente. |
| Alternativas/Exepciones | Si se envía una duda en blanco, saltará una excepcion en el paso número 4 que dice que no se puede enviar una duda en blanco. |
 
<a name="3"></a>
# Modelo de objetos del negocio

<a name="3.1"></a>
## Diagrama de clases 

### Modelo

![Diagrama de clases Modelo](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/DC%20-%20Modelo.png)

### Vista

![Diagrama de clases Vista](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/DC%20-%20Vista.png)

### Controlador

![Diagrama de clases Controlador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/DC%20-%20Controlador.png)

<a name="3.2"></a>
## Modelo entidad-relación

![Modelo entidad-relación](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Modelo%20entidad-relaci%C3%B3n-modificado.png)

<a name="4"></a>
# Interfaz gráfica

## Iniciar sesión en uCalendar

![Iniciar sesión](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/InicioCalendario.PNG)

## Vista del profesor

![Vista del profesor](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/InterfazProfesor.PNG)

## Crear calendario

![Crear calendario](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/CrearCalendario.PNG)

## Vista del alumno

![Vista del alumno](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/VistaAlumno.PNG)

## Vista de calendario

![Vista calendario](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/VistaCalendario.PNG)

## Vista de envío de dudas

![Vista de dudas](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/VistaDudas2.PNG)

## Consultar dudas

![Consulta de dudas](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/VistaConsultaDudas.PNG)

<a name="5"></a>
# Diagramas de Secuencia

## Enviar duda

![DS - Enviar duda](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/DS%20-%20Enviar%20Dudas.png)
