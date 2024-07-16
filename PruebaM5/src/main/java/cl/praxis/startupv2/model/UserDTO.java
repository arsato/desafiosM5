package cl.praxis.startupv2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int carId;
    private AddressDTO address;
    private RoleDTO role;
    private CarDTO car;

    public UserDTO(String email, String nick, String name, String password, int weight, int carId, AddressDTO address, RoleDTO role) {
        this.email = email;
        this.nick = nick;
        this.name = name;
        this.password = password;
        this.weight = weight;
        this.carId = carId;
        this.address = address;
        this.role = role;
    }

}