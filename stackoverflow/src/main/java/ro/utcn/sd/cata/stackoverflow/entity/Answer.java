package ro.utcn.sd.cata.stackoverflow.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Entity
@AllArgsConstructor
@NoArgsConstructor
//@Table(name = "answer")
public class Answer {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name = "question_id")
    private Integer questionId;
    //@Column(name = "author_id")
    private Integer authorId;
    //@Column(name = "text")
    private String text;
   // @Column(name = "creation_date")
    private String creationDate;

    public Answer(int questionId, int authorId, String text, String creationDate){
        this.questionId = questionId;
        this.authorId = authorId;
        this.text = text;
        this.creationDate = creationDate;
    }

}
