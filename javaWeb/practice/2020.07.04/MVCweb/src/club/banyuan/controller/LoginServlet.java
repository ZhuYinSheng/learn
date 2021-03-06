package club.banyuan.controller;

import club.banyuan.entity.User;
import club.banyuan.service.UserService;
import club.banyuan.service.impl.UserServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login.do")
public class LoginServlet extends HttpServlet {

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String loginName = request.getParameter("loginName");
    String password = request.getParameter("password");
    HttpSession session = request.getSession();


    //        调用service处理登录请求
    UserService userService = new UserServiceImpl();
    try {
      User user = userService.login(loginName,password);
      if(user.getLoginName()!=null){
        session.setAttribute("user",user);

        String loginNameCookie = request.getParameter("loginNameCookie");
        System.out.println(loginNameCookie);

        if("1".equals(loginNameCookie)){

        Cookie cookie = new Cookie("loginName",loginName);
        cookie.setMaxAge(3600);
        response.addCookie(cookie);
        }

        request.getRequestDispatcher("index.jsp").forward(request,response);
        return ;
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    if("".equals(loginName) || "".equals(password)){
      request.setAttribute("error","null");
    }else {
      request.setAttribute("error","error");
    }
    request.getRequestDispatcher("Login.jsp").forward(request,response);

  }

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response)
      throws ServletException, IOException {
    doPost(request,response);

  }
}
