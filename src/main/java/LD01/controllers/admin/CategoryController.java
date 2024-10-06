package LD01.controllers.admin;

import java.io.File;
import java.io.IOException;
import java.io.Serial;
import java.nio.file.Paths;
import java.util.List;

import LD01.models.CategoryModel;
import LD01.services.ICategoryService;
import LD01.services.impl.CategoryServiceImpl;

import static LD01.utils.Constant.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5 * 5)
@WebServlet(urlPatterns = {"/admin/categories", "/admin/category/add",
        "/admin/category/insert", "/admin/category/edit", "/admin/category/update",
        "/admin/category/delete", "/admin/category/search"})
public class CategoryController extends HttpServlet {

    @Serial
    private static final long serialVersionUID = 1L;
    public ICategoryService cateService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("categories")) {
            List<CategoryModel> list = cateService.findAll();
            req.setAttribute("listcate", list);
            req.getRequestDispatcher("/views/admin/category-list.jsp").forward(req, resp);
        } else if (url.contains("add")) {
            req.getRequestDispatcher("/views/admin/category-add.jsp").forward(req, resp);
        } else if (url.contains("edit")) {
            int id = Integer.parseInt(req.getParameter("id"));

            CategoryModel category = cateService.findById(id);

            req.setAttribute("cate", category);

            req.getRequestDispatcher("/views/admin/category-edit.jsp").forward(req, resp);
        } else if (url.contains("delete")) {
            String id = req.getParameter("id");
            cateService.delete(Integer.parseInt(id));
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url = req.getRequestURI();
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");

        if (url.contains("insert")) {
            CategoryModel category = new CategoryModel();
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);
            category.setCategoryname(categoryName);
            category.setStatus(statuss);
            String fname = "";
            String uploadPath = DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part filePart = req.getPart("image");
                if (filePart.getSize() > 0) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    // Chang file name
                    int index = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + fileExtension;
                    // Upload file
                    filePart.write(uploadPath + "/" + fname);
                    // Write file name to data
                    category.setImage(fname);
                } else {
                    category.setImage("avata.png");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            cateService.insert(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        } else if (url.contains("update")) {
            int categoryid = Integer.parseInt(req.getParameter("categoryid"));
            String categoryName = req.getParameter("categoryname");
            String status = req.getParameter("status");
            int statuss = Integer.parseInt(status);
            CategoryModel category = new CategoryModel();
            category.setCategoryid(categoryid);
            category.setCategoryname(categoryName);
            category.setStatus(statuss);
            // Save old image
            CategoryModel cateold = cateService.findById(categoryid);
            String fileold = cateold.getImage();
            // Image processing
            String fname = "";
            String uploadPath = DIR;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            try {
                Part filePart = req.getPart("image");
                if (filePart.getSize() > 0) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                    // Chang file name
                    int index = fileName.lastIndexOf(".");
                    String fileExtension = fileName.substring(index + 1);
                    fname = System.currentTimeMillis() + "." + fileExtension;
                    // Upload file
                    filePart.write(uploadPath + "/" + fname);
                    // Write file name to data
                    category.setImage(fname);
                } else {
                    category.setImage(fileold);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            cateService.update(category);
            resp.sendRedirect(req.getContextPath() + "/admin/categories");
        }
    }
}
