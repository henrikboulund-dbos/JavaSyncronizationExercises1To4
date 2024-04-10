package Exercise1;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListExample
{
    public static void main(String[] args) throws InterruptedException
    {
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();

        // Spawn multiple threads to add elements to the list simultaneously
        for (int i = 0; i < 5; i++)
        {
            new Thread(() -> {
                int randomNum = (int) (Math.random() * 100);
                list.add(randomNum);
            }).start();
        }

        // Wait for all threads to finish
        Thread.sleep(1000);

        // Print out the elements of the list
        for (Integer num : list)
        {
            System.out.println(num);
        }
    }
}
