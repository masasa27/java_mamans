package code.maman11.ex1;

public class GameBored {
    private final StringBuilder hiddenWord;
    private final Word gameWord;

    public GameBored(Word gameWord) {
        this.gameWord = gameWord;
        this.hiddenWord = new StringBuilder();

        // creating a hidden word
        for (int i = 0; i < gameWord.getWord().length(); i++) {
            if (this.gameWord.getWord().charAt(i) != ' ') {
                this.hiddenWord.append('_');
            } else {
                this.hiddenWord.append(' ');
            }
        }

    }

    public void printWord() {
        System.out.println("your current status is:");
        System.out.println(this.hiddenWord);
    }

    public void playTurn(String inputChar) {
        int[] char_actual_locations = this.gameWord.match(inputChar.charAt(0));
        for (int i = 0; i < char_actual_locations.length; i++) {
            if (char_actual_locations[i] == 1) {
                this.hiddenWord.setCharAt(i, inputChar.charAt(0));
            }
        }
    }

    public Boolean done() {
        return (this.hiddenWord.toString().equals(this.gameWord.getWord()));
    }
}

