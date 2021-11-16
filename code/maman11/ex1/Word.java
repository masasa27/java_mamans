package code.maman11.ex1;

public class Word {
    private final String _word;

    public Word(String word) {
        this._word = word;
    }

    public String getWord() {
        return this._word;
    }

    public String toString() {
        return this._word;
    }

    public int[] match(char a) {
        // this function returns matching character positions in the word

        int[] results = new int[this._word.length()];
        for (int i = 0; i < this._word.length(); i++) {
            if (this._word.charAt(i) == a) {
                results[i] = 1;
            } else {
                results[i] = 0;
            }
        }
        return results;
    }
}   
