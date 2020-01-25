package modelo;

public class CalendarioVO {

    int codigo;
    String nombre;
    String contenido;

    public void CalendarioVO() {

    }

    public void CalendarioVO(int codigo, String nombre, String contenido) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.contenido = contenido;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}
