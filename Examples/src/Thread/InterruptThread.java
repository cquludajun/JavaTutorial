package Thread;

/**
 * Created by ludajun on 5/6/16.
 * From this blog:  https://10kloc.wordpress.com/2013/03/03/java-multithreading-steeplechase-stopping-threads/
 */
public class InterruptThread {

    class ThreadInSleep extends Thread {
        @Override
        public void run() {
            try {
                Thread.sleep(Long.MAX_VALUE);
            } catch (InterruptedException e) {
                System.out.println("Detected interruption on the current thread.");
                return;
            }
            System.out.println("Exit Normally, but it is impossible!");
        }
    }

    private void testBlockingThreadReceivingInterruption() {
        ThreadInSleep threadInSleep = new ThreadInSleep();
        threadInSleep.start();
        try {
            System.out.println("wait 5 seconds and then try to stop the test thread...");
            Thread.sleep(5000);
        } catch (InterruptedException e) {}
        System.out.println("Interrupt the test thread...");
        threadInSleep.interrupt();
        System.out.println("The thread in test should stop sleeping and throws InterruptedException!");
    }

    public static void main(String[] args) {
        InterruptThread example = new InterruptThread();
        example.testBlockingThreadReceivingInterruption();
    }
}
