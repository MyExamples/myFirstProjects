package forum.storage;

import java.util.ArrayList;
import logic.Topics;

/**
 *
 * @author Julia
 */
public class Topic {
    
    private ArrayList<Topics> listTopics = new ArrayList<Topics>();

    public ArrayList<Topics> getListTopics() {
        return listTopics;
    }

    public void setListTopics(ArrayList<Topics> listTopics) {
        this.listTopics = listTopics;
    }
    
    
}
