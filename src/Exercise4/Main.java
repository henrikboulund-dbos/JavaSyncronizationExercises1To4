package Exercise4;

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        Counter counter = new Counter();

        // Spawn multiple threads to increment and decrement the counter
        Thread[] threads = new Thread[10];
        for (int i = 0; i < threads.length; i++)
        {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                {
                    counter.increment();
                    counter.decrement();
                }
            });
            threads[i].start();
        }

        // Wait for all threads to finish execution
        for (Thread thread : threads)
        {
            thread.join();
        }

        // Print the final count
        System.out.println("Final count: " + counter.getCount());
    }
}
