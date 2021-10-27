package code.maman11.ex1;
import java.util.Random;

public class WordsDb {
    private Word[] _super_heros = new Word[4];

    public WordsDb() {
        System.out.println("about to create super heros");
        
        _super_heros[0] = new Word("superman");
        _super_heros[1] = new Word("wonder woman");
        _super_heros[2] = new Word("batman");
        _super_heros[3] = new Word("flash");
    }

    public Word generate_word()
    {
        // This function returns a random word out of the string DB

        Random rand = new Random();
        
        // choosing a random index in the DB list
        int chosen_random_value = rand.nextInt(this._super_heros.length);
        return this._super_heros[chosen_random_value];
    }
}
