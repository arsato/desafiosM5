package cl.praxis.desafioproveedores.dao;

import cl.praxis.desafioproveedores.model.SupplierDTO;

import java.util.List;

public interface SupplierDAO {

    public List<SupplierDTO> selectAllSuppliers();

    public SupplierDTO insertSupplier(SupplierDTO supplier);

}
