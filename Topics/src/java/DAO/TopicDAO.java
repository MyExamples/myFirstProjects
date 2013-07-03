package DAO;

import java.sql.SQLException;
import java.util.Collection;
import logic.Topics;

/**
 *
 * @author Julia
 */
public interface TopicDAO {
    
    public void addTopic(Topics topic) throws SQLException;
    public Collection getAllTopics();
    public Topics getTopicById(Long topic_id) throws SQLException;
}
