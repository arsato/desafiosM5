package cl.praxis.startupv2.service;

import cl.praxis.startupv2.model.AddressDTO;

public interface IAddressService {

    AddressDTO saveAddress(AddressDTO address);
}
