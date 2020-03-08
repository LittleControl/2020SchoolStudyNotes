public class ThreadTest {
    public static void main(String[] args) {
        ThreadOne to = new ThreadOne();
        ThreadTwo tt = new ThreadTwo();
        to.start();
        tt.start();
        for (int i = 0; i <10 ; i++) {
            System.out.println("Three");
        }
    }
}

class ThreadOne extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("one");
        }
    }
}

class ThreadTwo extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("two");
        }
    }
}
