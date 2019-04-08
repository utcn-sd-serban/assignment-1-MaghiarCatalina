package ro.utcn.sd.cata.stackoverflow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
//@Entity
@AllArgsConstructor
//@Table(name = "question")
public class Question {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name = "author")
    private Integer author;
    //@Column(name = "title")
    private String title;
    //@Column(name = "text")
    private String text;
    //@Column(name = "creation_date")
    private String creationDate;

    //@ManyToMany
    //@JoinTable(name = "question_tag" )
    private List<Tag> tag;

    //@OneToMany
    //@JoinColumn
    private List<Answer> answer;

    public Question(){
        this.tag = new ArrayList<>();
    }
    public Question(String title, String text, String creationDate,Integer author){
        this.author = author;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.tag = new ArrayList<>();
        this.answer = new ArrayList<>();
    }

    public Question(Integer id, String title, String text, String creationDate){
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.tag = new ArrayList<>();
        this.answer = new ArrayList<>();
    }

    public Question(Integer id,Integer author, String title, String text, String creationDate){
        this.id = id;
        this.title = title;
        this.text = text;
        this.creationDate = creationDate;
        this.author = author;
        this.tag = new ArrayList<>();
        this.answer = new ArrayList<>();
    }

}
