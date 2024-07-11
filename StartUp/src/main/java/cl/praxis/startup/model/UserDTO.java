package cl.praxis.startup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String email;
    private Timestamp createdAt;
    private String nick;
    private String name;
    private String password;
    private int weight;
    private Timestamp updatedAt;

    public UserDTO(String email, String nick, String name, String password, int weight) {
        this.email = email;
        this.nick = nick;
        this.name = name;
        this.password = password;
        this.weight = weight;
    }

}
