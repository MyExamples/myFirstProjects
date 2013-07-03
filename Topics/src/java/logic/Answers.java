package logic;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Julia
 */

@Entity
@Table(name = "Answers")
public class Answers implements Serializable{
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)//automatically generates id
    private Long id;//PK
    
    @Column(name= "answerName", length=264)//name column and its size
    private String answerName;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "idTopic")//name column
    private Topics idTopic;//FK idTopic

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public Topics getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(Topics idTopic) {
        this.idTopic = idTopic;
    }
    
    
}
