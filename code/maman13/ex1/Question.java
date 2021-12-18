package code.maman13.ex1;

import java.util.Random;

public class Question {
    String question;
    Answer []answer = new Answer[4];
    int index = 0;

    public Question(String question)
    {
        this.question = question;
    }
    
    public void addAnswer(Answer answer)
    {
        this.answer[this.index++] = answer;
    
    }

    public Answer[] getAnswers()
    {
        this.shuffleArray(this.answer);
        return this.answer;
    }

    public void shuffleArray(Answer[] ar) {
        Random random = new Random();
        // shuffling a giving array

        for (int i = ar.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            Answer a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }
}
