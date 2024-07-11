package cl.praxis.desafioproveedores.service;

import cl.praxis.desafioproveedores.model.SupplierDTO;

import java.util.List;

public interface SupplierService {

    public SupplierDTO selectSupplierById(int id);

    public List<SupplierDTO> selectAllSuppliers();

    public SupplierDTO insertSupplier(SupplierDTO supplier);

    public SupplierDTO updateSupplier(SupplierDTO supplier);

    public boolean deleteSupplier(int id);
}
