package LD01.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import LD01.configs.DBConnectionSQL;
import LD01.dao.ICategoryDao;
import LD01.models.CategoryModel;

public class CategoryDaoImpl implements ICategoryDao{
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM [Category]";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImage(rs.getString("image"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findById(int id) {
		String sql = "SELECT * FROM Category WHERE categoryid=?";
		CategoryModel category = new CategoryModel();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImage(rs.getString("image"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public CategoryModel findName(String name) {
		String sql = "SELECT * FROM Category WHERE categoryname=?";
		CategoryModel category = new CategoryModel();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while (rs.next()) {
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImage(rs.getString("image"));
				category.setStatus(rs.getInt("status"));
				return category;
			}
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<CategoryModel> searchByName(String keyword) {
		String sql = "SELECT * FROM Category categoryname like ?";
		List<CategoryModel> list = new ArrayList<>();
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + keyword + "%");
			rs = ps.executeQuery();
			while (rs.next()) {
				CategoryModel category = new CategoryModel();
				category.setCategoryid(rs.getInt("categoryid"));
				category.setCategoryname(rs.getString("categoryname"));
				category.setImage(rs.getString("image"));
				category.setStatus(rs.getInt("status"));
				list.add(category);
			}
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void insert(CategoryModel category) {
		String sql = "INSERT INTO Category(categoryname, image, status) VALUES (?,  ?, ?)";
		
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.executeQuery();
			
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(CategoryModel category) {
		String sql = "UPDATE Category SET categoryname=? , image=? , status=? WHERE categoryid=?";
		
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, category.getCategoryname());
			ps.setString(2, category.getImage());
			ps.setInt(3, category.getStatus());
			ps.setInt(4, category.getCategoryid());
			ps.executeQuery();
			
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Category WHERE categoryid=?";
		
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeQuery();
			
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateStatus(int id, int status) {
		String sql = "UPDATE Category SET status=? WHERE categoryid=?";
		
		try {
			conn = new DBConnectionSQL().getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setInt(2, status);
			ps.executeQuery();
			
			conn.close();
			ps.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
