/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author prabu
 */
@WebServlet(name = "User_Login", urlPatterns = {"/User_Login"})
public class User_Login extends HttpServlet{
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Gson gson = new Gson();
        User requestUser = gson.fromJson(request.getReader(),User.class);

        HashMap<String, User> userMap = (HashMap<String, User>) request.getServletContext().getAttribute("userMap");
JsonObject jsonObject = new JsonObject();
        if (userMap.containsKey(requestUser.getMobile())) {

                User user = userMap.get(requestUser.getMobile());
                
            if (user.getPassword().equals(requestUser.getPassword())) {

                request.getSession().setAttribute("user",user);
                jsonObject.addProperty("msg","success");
                
            } else {
                jsonObject.addProperty("msg","error2");
            }

        } else {
            jsonObject.addProperty("msg","error2");
        }

        response.setContentType("application/json");
        response.getWriter().write(gson.toJson(jsonObject));
    }

}

