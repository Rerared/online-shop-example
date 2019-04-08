package com.study.onlineshop.web.servlet;

import com.study.onlineshop.entity.Product;
import com.study.onlineshop.service.ProductService;
import com.study.onlineshop.web.templater.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;

public class AddProductServlet extends HttpServlet {
    private ProductService productService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PageGenerator pageGenerator = PageGenerator.instance();

        HashMap<String, Object> parameters = new HashMap<>();

        String page = pageGenerator.getPage("add", parameters);
        response.getWriter().write(page);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        double price = Double.valueOf(request.getParameter("price"));
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        int id = productService.add(product);
        product.setId(id);
        response.sendRedirect("/products");
    }

    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

}
