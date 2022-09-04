package com.example.adminmodel.controller.register;

import com.example.adminmodel.entity.Account;
import com.example.adminmodel.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String confirmPassword = req.getParameter("confirmPassword");
        String fullName = req.getParameter("fullName");
        Account account = Account.AccountBuilder.anAccount()
                .withUsername(username)
                .withEmail(email)
                .withPassword(password)
                .withConfirmPassword(confirmPassword)
                .withFullName(fullName)
                .build();
        if(!account.isValid()){
            req.getAttribute("accout", account);
            req.getAttribute("error",account.getErrors());
            req.getRequestDispatcher("user/register.jsp").forward(req,resp);
            return;
        }
        account = AccountService.register(account);


    }
}
