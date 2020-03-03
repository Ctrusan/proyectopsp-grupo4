package servidores;

public class ObtieneFichero {

    byte [] contenidoFichero;

    public ObtieneFichero(byte [] contenidoFichero) {

        this.contenidoFichero = contenidoFichero;
    }

    public byte[] getContenidoFichero() {

        return contenidoFichero;
    }
}
