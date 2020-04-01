package proyecto.controlador;

public class UsuariosConectados {

private int cantidad=1;
private boolean disponible;


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
        while (cantidad>2) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        cantidad++;
        notifyAll();
    }


}
