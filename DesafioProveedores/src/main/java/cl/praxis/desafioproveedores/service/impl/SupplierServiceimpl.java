package cl.praxis.desafioproveedores.service.impl;

import cl.praxis.desafioproveedores.dao.SupplierDAO;
import cl.praxis.desafioproveedores.dao.impl.SupplierDAOimpl;
import cl.praxis.desafioproveedores.model.SupplierDTO;
import cl.praxis.desafioproveedores.service.SupplierService;

import java.util.List;

public class SupplierServiceimpl implements SupplierService {

    private final SupplierDAO supplierDAO;

    public SupplierServiceimpl() {
        this.supplierDAO = new SupplierDAOimpl();
    }
    @Override
    public List<SupplierDTO> selectAllSuppliers() {
        return supplierDAO.selectAllSuppliers();
    }

    @Override
    public SupplierDTO insertSupplier(SupplierDTO supplier) {
        return supplierDAO.insertSupplier(supplier);
    }
}
