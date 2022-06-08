package com.example.adminmodel.filterdemo;

import com.example.adminmodel.entity.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        boolean havePermission = false;
        if(session.getAttribute("currentAccount") !=null) {
            Account account = (Account) session.getAttribute("currentAccount");
            System.out.println("Hello user:" + account.getUsename());
            if(account.getRoleId() ==2 ){
                havePermission = true;
            }
        }
        if (havePermission){
            chain.doFilter(httpServletRequest, httpServletResponse);
        }else{
            httpServletResponse.getWriter().println("Permission denied!");
        }

    }
}
