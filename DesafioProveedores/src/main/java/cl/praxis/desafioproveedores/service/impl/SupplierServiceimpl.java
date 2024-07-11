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
    public SupplierDTO selectSupplierById(int id) {
        return supplierDAO.selectSupplierById(id);
    }

    @Override
    public List<SupplierDTO> selectAllSuppliers() {
        return supplierDAO.selectAllSuppliers();
    }

    @Override
    public SupplierDTO insertSupplier(SupplierDTO supplier) {
        return supplierDAO.insertSupplier(supplier);
    }

    @Override
    public SupplierDTO updateSupplier(SupplierDTO supplier) {
        return supplierDAO.updateSupplier(supplier);
    }

    @Override
    public boolean deleteSupplier(int id) {
        return supplierDAO.deleteSupplier(id);
    }
}
