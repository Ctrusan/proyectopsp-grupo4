package modelo;

public class DudaVO {

    int codigo;
    String titulo;
    String contenido;

    public void DudaVO() {

    }

    public void DudaVO(int codigo, String titulo, String contenido) {

        this.codigo = codigo;
        this.titulo = titulo;
        this.contenido = contenido;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
}
