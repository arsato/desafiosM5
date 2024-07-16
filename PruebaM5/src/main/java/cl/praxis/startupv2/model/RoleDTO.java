package cl.praxis.startupv2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO {

    private int id;
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
