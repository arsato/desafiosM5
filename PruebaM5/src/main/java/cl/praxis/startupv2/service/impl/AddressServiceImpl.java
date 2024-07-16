package cl.praxis.startupv2.service.impl;

import cl.praxis.startupv2.dao.impl.AddressDAOImpl;
import cl.praxis.startupv2.dao.IAddressDAO;
import cl.praxis.startupv2.model.AddressDTO;
import cl.praxis.startupv2.service.IAddressService;

public class AddressServiceImpl implements IAddressService {

    private final IAddressDAO addressDAO;

    public AddressServiceImpl() {
        this.addressDAO = new AddressDAOImpl();
    }

    @Override
    public AddressDTO saveAddress(AddressDTO address) {
        return addressDAO.addAddress(address);
    }
};
