package cl.praxis.startupv2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private int id;
    private String addressName;
    private String addressNumber;
    private int userId;

    public AddressDTO(String addressName, String addressNumber) {
        this.addressName = addressName;
        this.addressNumber = addressNumber;
    }
}
