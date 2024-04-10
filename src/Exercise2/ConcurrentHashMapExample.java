package Exercise2;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample
{
    public static void main(String[] args) throws InterruptedException
    {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();

        // Spawn multiple threads to increment values associated with keys simultaneously
        for (int i = 0; i < 5; i++)
        {
            new Thread(() -> {
                String key = "Key";
                map.compute(key, (k, v) -> (v == null) ? 1 : v + 1);
            }).start();
        }

        // Wait for all threads to finish
        Thread.sleep(1000);

        // Print out the contents of the map
        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
