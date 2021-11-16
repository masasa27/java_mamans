package code.maman11.ex1;
import java.util.Random;

public class WordsDb {
    private final Word[] superHeroes = new Word[4];

    public WordsDb() {
        System.out.println("about to create super heros");
        
        superHeroes[0] = new Word("superman");
        superHeroes[1] = new Word("wonder woman");
        superHeroes[2] = new Word("batman");
        superHeroes[3] = new Word("flash");
    }

    public Word generate_word()
    {
        // This function returns a random word out of the string DB

        Random rand = new Random();
        
        // choosing a random index in the DB list
        int chosenRandomValue = rand.nextInt(this.superHeroes.length);
        return this.superHeroes[chosenRandomValue];
    }
}
