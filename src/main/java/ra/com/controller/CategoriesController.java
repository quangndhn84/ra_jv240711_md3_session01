package ra.com.controller;

import ra.com.entity.Categories;
import ra.com.service.CategoriesService;
import ra.com.service.imp.CategoriesServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CategoriesController", value = "/CategoriesController")
public class CategoriesController extends HttpServlet {
    //tiêm 1 instance của CategoriesService
    private CategoriesService categoriesService;

    public CategoriesController() {
        categoriesService = new CategoriesServiceImp();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1. Lấy tham số action trong request
        String action = request.getParameter("action");
        if (action.equals("findAll")) {
            //2. Gọi sang service
            List<Categories> listCategories = categoriesService.findAll();
            //3. add listCategories vào request
            request.setAttribute("listCategories", listCategories);
            //4. Chuyển request và response sang trang categories.jsp
            request.getRequestDispatcher("/views/categories.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}