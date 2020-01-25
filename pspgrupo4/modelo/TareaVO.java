package modelo;

import java.util.Date;

public class TareaVO {

    int codigo;
    String descripcion;
    String titulo;
    Date fechaLimite;

    public void TareaVO(int codigo, String titulo, String descripcion, Date fechaLimite) {

        this.codigo = codigo;
        this.descripcion = descripcion;
        this.titulo = titulo;
        this.fechaLimite = fechaLimite;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Date getFechaLimite() { return fechaLimite; }
    public void setFechaLimite(Date fechaLimite) { this.fechaLimite = fechaLimite; }
}
