package za.ac.cput.service;

import za.ac.cput.domain.Admin;

import java.util.Set;

public interface IAdminService extends IService<Admin, Long>{
    Set<Admin> getAll();
}
