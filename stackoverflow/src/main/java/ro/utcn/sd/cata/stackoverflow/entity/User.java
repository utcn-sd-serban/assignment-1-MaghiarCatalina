package ro.utcn.sd.cata.stackoverflow.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Entity
//@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    //@Column(name = "username")
    private String username;
    //@Column(name = "password")
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
