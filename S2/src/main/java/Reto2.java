import java.util.concurrent.TimeUnit;

public class Reto2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <= 10; i++) {
            System.out.println("Hilo1: " + i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static class Hilo2 implements Runnable{
        @Override
        public void run() {
            while(true){
                System.out.println("Hilo2: Sigo en ejecución...");
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {

        Thread hilo1 = new Thread(new Reto2());
        hilo1.start();

        Thread hilo2= new Thread(new Hilo2());
        hilo2.setDaemon(true);
        hilo2.start();
    }
}