package ro.utcn.sd.cata.stackoverflow.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
//@Entity
//@Table(name = "tag")
@AllArgsConstructor
@RequiredArgsConstructor
public class Tag {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name = "name")
    private String name;

    public Tag(String name){
        this.name = name;
    }
}
