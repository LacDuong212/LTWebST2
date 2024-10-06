package LD01.services.impl;

import java.util.List;

import LD01.dao.ICategoryDao;
import LD01.dao.impl.CategoryDaoImpl;
import LD01.models.CategoryModel;
import LD01.services.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{

	public ICategoryDao cateDao = new CategoryDaoImpl();
	
	@Override
	public List<CategoryModel> findAll() {
		return cateDao.findAll();
	}

	@Override
	public CategoryModel findById(int id) {
		return cateDao.findById(id);
	}

	@Override
	public CategoryModel findName(String name) {
		return cateDao.findName(name);
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		return cateDao.searchByName(keyword);
	}

	@Override
	public void insert(CategoryModel category) {
		CategoryModel cate = this.findName(category.getCategoryname());
		if(cate == null) {
			cateDao.insert(category);
		}
	}

	@Override
	public void update(CategoryModel category) {
		CategoryModel cate = this.findById(category.getCategoryid());
		if(cate != null) {
			cateDao.update(category);
		}
	}

	@Override
	public void delete(int id) {
		cateDao.delete(id);
	}

	@Override
	public void updateStatus(int id, int status) {
		cateDao.updateStatus(id, status);
	}

}
