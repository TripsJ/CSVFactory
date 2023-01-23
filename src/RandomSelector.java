import java.util.ArrayList;
import java.util.Random;

public class RandomSelector {
    public Object randomElement(ArrayList<String> list){
        Random generator = new Random();
        int index = generator.nextInt(list.size());
        return list.get(index);

    }

    public int randomNumber(int max){
        Random generator = new Random();
        return generator.nextInt(max);
    }
}
