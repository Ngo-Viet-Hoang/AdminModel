//package com.example.adminmodel.controller.shoppingcart;
//
//import com.example.adminmodel.entity.Product;
//import com.example.adminmodel.entity.ShoppingCart;
//import com.example.adminmodel.model.MySqlProductModel;
//import com.example.adminmodel.model.ProductModel;
//import com.example.adminmodel.util.ShoppingCartHelper;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class AddCartServlet extends HttpServlet {
//    private ProductModel productModel;
//
//    public AddCartServlet(){
//        this.productModel = new MySqlProductModel();
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try{
//            Integer productId = Integer.parseInt(req.getParameter("productId"));
//            Integer quantity = Integer.parseInt(req.getParameter("quantity"));
//            Product product = productModel.findById(productId);
//            if(product == null){
//                resp.getWriter().println("Product is not found");
//                return;
//            }
//            if(quantity <=0) {
//                resp.getWriter().println("Invalid quantity!");
//                return;
//            }
//            ShoppingCartHelper shoppingCartHelper = new ShoppingCartHelper(req);
//            ShoppingCart shoppingCart = shoppingCartHelper.getCart();
//            ShoppingCart.add(product, quantity);
//            ShoppingCartHelper.saveCart(shoppingCart);
//            resp.sendRedirect("/shopping-cart/get");
//
//        }catch (Exception e){
//            resp.getWriter().println(e.getMessage());
//        }
//    }
//}
