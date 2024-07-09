package cl.praxis.desafioproveedores.service;

import cl.praxis.desafioproveedores.model.SupplierDTO;

import java.util.List;

public interface SupplierService {

    public List<SupplierDTO> selectAllSuppliers();

    public SupplierDTO insertSupplier(SupplierDTO supplier);
}
