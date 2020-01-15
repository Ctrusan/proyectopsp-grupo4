# uCalendar

![Portada](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Calendario.jpg)

Este trabajo está realizado por **José Palacios Montes y Carlos Trujillo García** para la asignatura de **Programación de Servicios y Procesos**, curso 2019 - 2020. Este proyecto está bajo una licencia de *Creative Commons Reconocimiento-NoComercial-CompartirIgual 4.0 Internacional*. 

![Licencia](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Licencia.png)

# Índice

[1. Requisitos funcionales.](#1)
<br>
[2. Casos de uso.](#2)
<br>
[3. Modelo de objetos de negocio](#3)
<br>
[4. Interfaz gráfica](#4)


<a name="1"></a>
# Definición del problema. Requisitos funcionales.

Nuestra aplicación consistirá en un entorno que englobará calendarios en función de la cantidad de cursos que le darán uso a la app. También estaría la opción de añadir calendarios propios de las asignaturas del curso. En éstos, los profesores podrán añadir a los días lo siguiente: tareas, exámenes, trabajos, excursiones, días en los que el profesor o profesora no va a asistir por x cuestión, etcétera. Los alumnos, por otro lado, podrán visualizar los cambios que realicen los profesores al momento. Habrá una opción de correo/chat para preguntar dudas o proponer algún cambio.

<a name="2"></a>
# Análisis de requisitos funcionales: Casos de uso.

![Casos de uso](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/CasosDeUsoModificado.png)

## Anexo.

| Datos | Descripción. |
| -- | -- |
| Nombre | Enviar dudas o preguntas. |
| ID | EnviarYConsultar |
| Descripción | Recogerá cuando un alumno pregunte dudas o preguntas al profesor que sea dueño del calendario. |
| Actores | Alumno |
| Precondicones | Ser alumno. |
| Curso normal | 1.- Iniciar sesión.|
|              | 2.- Seleccionar "Enviar dudas o preguntas".| 
|              | 3.- Se abre una nueva ventana con un apartado para escribir la duda y un botón para enviarla. |
|              | 4.- Enviar duda o pregunta.
| Postcondicionales | La duda le llega al profesor correspondiente. |
| Alternativas/Exepciones | Si se envía una duda en blanco, saltará una excepcion que dice que no se puede enviar una duda en blanco. |
 
![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Consultar y responder dudas. |
| ID |ConsultarResponder |
| Descripción | Visualizar las preguntas recibidas por los alumnos y poder responderlas. |
| Actores | Profesor |
| Precondicones | Ser profesor. |
| Curso normal | 1.- Iniciar sesión.|
|              | 2.- Seleccionar "Enviar dudas y consultar".|
|              | 3.- Seleccionar una y responder. |
| Postcondicionales | La respuesta del profesor le llegará al alumno. |
| Alternativas/Exepciones | Si se envía la respuesta en blanco, saltará una excepción que dice que no se puede enviar ésta en blanco. |

![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Ver tareas más próximas. |
| ID | TareasProximas |
| Descripción | Muestra en una lista las tareas próximas en un margen de 7 días. |
| Actores | Alumno. |
| Precondicones | El profesor tiene que haber propuesto tareas. |
| Curso normal | 1.- Iniciar sesión.|
|              | 2.- Visualizar el apartado con las tareas de los próximos 7 días (título de la tarea, asignatura correspondiente y fecha, con su correspondiente descripción). |
| Postcondicionales | El alumno y el profesor quedan informados de las tareas a realizar. |
| Alternativas/Exepciones | Si no hay tareas próximas, saldrá un mensaje diciendo: '¡Estás libre! Por ahora…' |

![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Enviar notificaciones. |
| ID | EnvioNotis |
| Descripción | El profesor podrá enviar notificaciones cuando quiera dictaminar algo importante a todos sus alumnos al instante. |
| Actores | Profesor. |
| Precondicones | Ser profesor. |
| Curso normal | 1.- Iniciar sesión.|
|              | 2.- Seleccionar "Notificar a todos".|
|              | 3.- Escribir el título y contenido de la notificación y enviarla a todos sus alumnos. |
| Postcondicionales | Los alumnos recibirán una alerta con el mensaje del profesor. |
| Alternativas/Exepciones | Si se envía la notificación en blanco, salta una excepción que dice que no se puede enviar ésta en blanco. |

![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Iniciar sesión. |
| ID | IniciarSesion |
| Descripción | Introduces el usuario y contraseña para acceder a los calendarios. |
| Actores | Alumno y profesor. |
| Precondicones | Tener una cuenta creada. |
| Curso normal | 1.- Iniciar la aplicación.|
|              | 2.- Introducir el nombre de usuario y contraseña. |
| Postcondicionales | El usuario o profesor entran en la aplicación. |
| Alternativas/Exepciones | Si la cuenta introducida no existe o el usuario se ha equivocado con sus datos, sale un mensaje diciendo "Nombre y/o contraseña erróneos". |

![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Leer calendario. |
| ID | LeerCalendar |
| Descripción | Te muestra en pantalla el calendario completo con todas la informacion necesaria que necesita saber el alumno o el profesor.(ej: exámenes, proyectos etc.). |
| Actores | Alumno y profesor. |
| Precondicones | Que el profesor haya creado el calendario. |
| Curso normal | 1.- Iniciar sesión.|
|              | 2.- Acceder a los calendarios disponibles y escoger uno. |
|              | 3.- Mostrar el calendario seleccionado y se visualizarán el título de las tareas que haya en éste con sus respecivas fechas. |
| Postcondicionales | El alumno y profesor quedan informados. |
| Alternativas/Exepciones | Si no hay ningún calendario creado, saldrá un mensaje diciendo que no hay un calendario creado y si quieres crear uno (si eres profesor); si eres alumno, saldrá un mensaje diciendo que deberás esperar. |

![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Modificar calendario. |
| ID | CambiarCalendar |
| Descripción | Nos permite agregar o quitar información a un calendario ya creado. |
| Actores | Profesor. |
| Precondicones | Iniciar sesión como profesor y tener mínimo un calendario creado. |
| Curso normal | 1.- Iniciar sesión. |
|              | 2.- Acceder al calendario que ha creado. |
|              | 3.- Seleccionar "Añadir", "Modificar" o "Eliminar". |
|              | 3.1.- Si pulsa "Añadir", tendrá que elegir una fecha y dentro de ésta, el nombre de la tarea y su descripción. |
|              | 3.2.- Si pulsa "Modificar", se mostrarán las tareas ya creadas y podrá cambiarlas ya sea su fecha, nombre y descripción. |
|              | 3.3.- Si pulsa "Eliminar", se mostrarán las tareas ya creadas y podrá eliminar la/s que desee. |
| Postcondicionales | El calendario se actualiza dependiendo de la acción realizada. |
| Alternativas/Exepciones | Si no hay un calendario creado, no podrá ni modificar ni eliminar; tendrá que crear el calendario previamente. |

![Separador](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Separador.png)

| Datos | Descripción. |
| -- | -- |
| Nombre | Crear calendario. |
| ID | CrearCalendar |
| Descripción | Poder crear más de un calendario, dependiendo de las materias impartidas. |
| Actores | Profesor. |
| Precondicones | Iniciar sesión como profesor. |
| Curso normal | 1.- Iniciar sesión. |
|              | 2.- Seleccionar "Crear nuevo calendario". |
|              | 3. Crear el calendario a partir de un nombre y de los alumnos cursantes de la asignatura. |
| Postcondicionales | El calendario se ha creado. |
| Alternativas/Exepciones | 1.- Si se pone un calendario sin título, saldrá una excepción diciendo que no puede estar en blanco.|
|              | 2.- Si se crea un calendario sin alumnos, saldrá una excepción diciendo que el calendario necesita al menos un alumno. |
|              |3.- Si crea un calendario con un nombre ya existente, saldrá una excepción diciendo que ya existe. |

<a name="3"></a>
# Modelo de objetos del negocio

<a name="3.1"></a>
## Diagrama de clases 

![Diagrama de clases](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Diagrama%20de%20clases%20modificado%202.png)

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
