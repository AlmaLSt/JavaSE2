import java.util.concurrent.TimeUnit;

public class Reto1 extends Thread {
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

    public static class Hilo2 extends Thread {

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

        Reto1 hilo1 = new Reto1();
        hilo1.start();

        Hilo2 hilo2= new Hilo2();
        hilo2.setDaemon(true);
        hilo2.start();
    }

}