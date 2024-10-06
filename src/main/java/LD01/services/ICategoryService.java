package LD01.services;

import java.util.List;

import LD01.models.CategoryModel;

public interface ICategoryService {
	
	List<CategoryModel> findAll();
	CategoryModel findById(int id);
	CategoryModel findName(String name);
	List<CategoryModel> searchByName(String keyword);
	void insert(CategoryModel category);
	void update(CategoryModel category);
	void delete(int id);
	void updateStatus(int id, int status);
	
}
