package forum.storage;

import java.util.ArrayList;
import logic.Answers;

/**
 *
 * @author Julia
 */
public class Answer {

    private ArrayList<Answers> listAnswers = new ArrayList<Answers>();

    public ArrayList<Answers> getListAnswers() {
        return listAnswers;
    }

    public void setListAnswers(ArrayList<Answers> listAnswers) {
        this.listAnswers = listAnswers;
    }
    
    
}
