package cl.praxis.startupv2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDTO {

    private int id;
    private String name;
    private String imageUrl;

    public CarDTO(String name, String imageUrl) {
        this.name = name;
        this.imageUrl = imageUrl;
    }

}
