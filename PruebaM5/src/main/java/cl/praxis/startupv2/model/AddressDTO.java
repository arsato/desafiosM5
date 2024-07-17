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

}
