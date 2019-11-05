# Calendario escolar 
![Portada](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Encabezado.jpg)

# Definición del problema. Requisitos funcionales.

Nuestra aplicación consistirá en un entorno que englobará calendarios en función de la cantidad de cursos que le darán uso a la app. También estaría la opción de añadir calendarios propios de las asignaturas del curso. En éstos, los profesores podrán añadir a los días lo siguiente: tareas, exámenes, trabajos, excursiones, días en los que el profesor o profesora no va a asistir por x cuestión, etcétera. Los alumnos, por otro lado, podrán visualizar los cambios que realicen los profesores al momento. Habrá una opción de correo/chat para preguntar dudas o proponer algún cambio.

# Análisis de requisitos funcionales: Casos de uso.

![Casos de uso](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Casos%20de%20uso.png)

## Anexo.

| Datos | Descripción. |
| -- | -- |
| Nombre | Enviar dudas y consultar respuestas. |
| ID | EnviarYConsultar |
| Descripción | Recogerá cuando un alumno pregunte dudas o preguntas al profesor que sea dueño del calendario. |
| Actores | Alumno |
| Precondicones | Ser alumno. |
| Curso normal | 1.- Iniciar sesión como alumno. 2.- Ir a un apartado llamado "Enviar dudas y consultar". 3.- Clickar en él. 4.- Se abre una nueva ventana con un apartado para escribir la duda y un botón para enviarla. |
| Postcondicionales | La duda le llega al profesor correspondiente. |
| Alternativas/Exepciones | Si se envía una duda en blanco, saltará una excepcion que dice que no se puede enviar una duda en blanco. |


| Datos | Descripción. |
| -- | -- |
| Nombre | Consultar y responder dudas. |
| ID |ConsultarResponder |
| Descripción | Visualizar las preguntas recibidas por los alumnos y poder responderlas. |
| Actores | Profesor |
| Precondicones | Ser profesor. |
| Curso normal | 1.- Iniciar como profesor. 2.- Ir a una pestaña con el nombre "Enviar dudas y consultar". 3.- Acceder a una de ellas, abrirla y responder. |
| Postcondicionales | La respuesta del profesor le llegará al alumno. |
| Alternativas/Exepciones | Si se envía la respuesta en blanco, saltará una excepción que dice que no se puede enviar ésta en blanco. |


| Datos | Descripción. |
| -- | -- |
| Nombre | Ver tareas más próximas. |
| ID | TareasProximas |
| Descripción | Muestra en una lista las tareas próximas en un margen de 7 días. |
| Actores | Alumno y profesor. |
| Precondicones | El profesor tiene que haber propuesto tareas. |
| Curso normal | 1.- Iniciar sesión. 2.- Visualizar el apartado con las tareas de los próximos 7 días. |
| Postcondicionales | El alumno y el profesor quedan informados de las tareas a realizar. |
| Alternativas/Exepciones | Si no hay tareas próximas, saldrá un mensaje (como alumno) diciendo: '¡Estás libre! Por ahora…' |

| Datos | Descripción. |
| -- | -- |
| Nombre | Enviar notificaciones. |
| ID | EnvioNotis |
| Descripción | El profesor podrá enviar notificaciones cuando quiera dictaminar algo importante a todos sus alumnos al instante. |
| Actores | Profesor. |
| Precondicones | Ser profesor. |
| Curso normal | 1.- Iniciar sesión como profesor. 2.- Pulsar un botón con el nombre "Notificar a todos". 3.- Escribir el título, contenido y enviarlo a todos sus alumnos. |
| Postcondicionales | Los alumnos recibirán una alerta con el mensaje del profesor. |
| Alternativas/Exepciones | Si se envía la notificación en blanco, salta una excepción que dice que no se puede enviar ésta en blanco. |

# Modelo de objetos del negocio

## Diagrama de clases 

![Diagrama de clases](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Diagrama%20de%20clases.png)

## Modelo entidad-relación

![Modelo entidad-relación](https://github.com/Ctrusan/proyectopsp-grupo4/blob/documentacion/Im%C3%A1genes/Modelo%20entidad-relaci%C3%B3n.png)
