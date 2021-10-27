package code.maman11.ex1;
public class GameBored {
    private StringBuilder _hidden_word;
    private Word _game_word;

    public GameBored(Word game_word){
        this._game_word = game_word;
        this._hidden_word = new StringBuilder("");

        // creating a hidden word
        for (int i = 0; i < game_word.get_word().length();i++)
        {
            if (this._game_word.get_word().charAt(i) != ' ')
            {
                this._hidden_word.append('_');
            }
            else
            {
                this._hidden_word.append(' ');
            }
        }
    
    }

    public void print_word() {
        System.out.println("your current status is:");
        System.out.println(this._hidden_word);
    }

    public void play_turn(String input_char){
        int[] char_actual_locations = this._game_word.match(input_char.charAt(0));
        for (int i=0; i < char_actual_locations.length; i++)
        {
            if (char_actual_locations[i] == 1){
                this._hidden_word.setCharAt(i, input_char.charAt(0));
            }
        }
    }
    public Boolean done(){
        return (this._hidden_word.toString().equals(this._game_word.get_word()));
    }
}

