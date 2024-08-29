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
@WebServlet(name = "User_Registration", urlPatterns = {"/User_Registration"})
public class User_Registration extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Gson gson = new Gson();
        User user = gson.fromJson(request.getReader(), User.class);

        HashMap<String, User> userMap = (HashMap<String, User>) request.getServletContext().getAttribute("userMap");
        
        JsonObject jsonObject1 = new JsonObject();
        
        if (userMap.containsKey(user.getMobile())) {
            jsonObject1.addProperty("msg", "error1");
        } else {
            userMap.put(user.getMobile(), user);
            jsonObject1.addProperty("msg","success");
        }
        
        response.setContentType("application/json");
        System.out.println(gson.toJson(jsonObject1));
        response.getWriter().write(gson.toJson(jsonObject1));
    }

}
