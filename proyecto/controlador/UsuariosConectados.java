package proyecto.controlador;

public class UsuariosConectados {

private int cantidad=1;



    public synchronized int get() {
        while (cantidad<=1)
        {
            try {
                wait();
            }
            catch (InterruptedException e) {	}
        }
        notifyAll();

        return cantidad;
    }

    public synchronized void put() {
        while (cantidad>4) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        cantidad++;
        notifyAll();
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad-1;
    }
}
