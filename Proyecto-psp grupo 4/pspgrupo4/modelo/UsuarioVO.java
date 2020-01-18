package pspgrupo4.modelo;

public class UsuarioVO {

    String nombre;
    String contrasena;
    String tipo;

    public UsuarioVO() {

    }

    public UsuarioVO(String nombre, String contrasena, String tipo) {

        this.nombre = nombre;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "UsuarioVO{" +
                "nombre='" + nombre + '\'' +
                ", contrasena='" + contrasena + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}
