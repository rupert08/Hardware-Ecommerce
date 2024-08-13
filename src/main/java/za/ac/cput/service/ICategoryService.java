package za.ac.cput.service;

import za.ac.cput.domain.Category;

import java.util.Set;

public interface ICategoryService extends IService<Category, Long> {
    Set<Category> getAll();
}