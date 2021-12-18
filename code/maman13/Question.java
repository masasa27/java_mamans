package code.maman13;

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
}
