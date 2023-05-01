import java.util.concurrent.TimeUnit;

public class MiRunnable implements Runnable{
    private  String parametro;
    private String nombre;

    public MiRunnable(String parametro) {
        this.parametro = parametro;
        this.nombre = nombre;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    @Override
    public void run() {
        while (!"terminar".equals(parametro)) {
            mostrarInformacion();
            pausarUnSegundo();
        }
        mostrarInformacion();
    }

    public static void pausarUnSegundo(){
        try{
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    private void mostrarInformacion(){
        System.out.println("Hilo: "+ nombre + "\t| Parametro: " + parametro);
    }

    public static void main(String[] args) {
        MiRunnable runnable1 = new MiRunnable("Uno");
        MiRunnable runnable2 = new MiRunnable("Dos");

        Thread t1 = new Thread(runnable1);
        t1.start();

        Thread t2 = new Thread(runnable2);
        t2.setDaemon(true);
        t2.start();

        MiRunnable.pausarUnSegundo();
        runnable1.setParametro("terminar");
        System.out.println("FIN DEL HILO");

    }

}
