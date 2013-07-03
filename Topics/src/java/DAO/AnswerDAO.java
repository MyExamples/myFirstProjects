package DAO;

import java.sql.SQLException;
import java.util.Collection;
import logic.Answers;

/**
 *
 * @author Julia
 */
public interface AnswerDAO {
    
    public void addAnswer(Answers answer) throws SQLException;
    public Collection getAllAnswers();
    
}
