package com.wangxingxing.HelloWorldWeb;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "userInfo", value = "/userInfo")
public class UserInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        resp.setCharacterEncoding("utf-8");

        PrintWriter out = resp.getWriter();
        User user = new User();
        user.id = UUID.randomUUID().toString();
        user.age = 18;
        user.name = "尼古拉斯赵四";
        user.sex = "男";
        user.address = "China";
        Gson gson = new Gson();
        String userJson = gson.toJson(user, User.class);
        System.out.println(userJson);
        out.write(userJson);
        out.close();
    }
}
