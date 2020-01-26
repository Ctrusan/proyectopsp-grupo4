package proyecto.modelo;

public class CalendarioVO {

    int codigo;
    String nombre;
    String contenido;


    public void CalendarioVO() {

    }

    public void CalendarioVO(String nombre, String contenido) {

        this.nombre = nombre;
        this.contenido = contenido;


    }


    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}
