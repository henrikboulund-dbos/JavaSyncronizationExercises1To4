package Exercise3;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample
{
    public static void main(String[] args)
    {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>(5);

        // Spawn multiple producer threads
        for (int i = 0; i < 3; i++)
        {
            new Thread(() -> {
                try
                {
                    String data = "Data";
                    queue.put(data);
                    System.out.println(Thread.currentThread().getName() + " produced: " + data);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }).start();
        }

        // Spawn multiple consumer threads
        for (int i = 0; i < 2; i++)
        {
            new Thread(() -> {
                try
                {
                    String data = queue.take();
                    System.out.println(Thread.currentThread().getName() + " consumed: " + data);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
