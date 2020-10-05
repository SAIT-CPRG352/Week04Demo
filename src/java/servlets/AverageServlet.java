/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author awarsyle
 */
public class AverageServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        ArrayList<Integer> numbers = (ArrayList<Integer>) session.getAttribute("numbers");
        if (numbers == null) {
            numbers = new ArrayList<>();
            session.setAttribute("numbers", numbers);
        }
        
        double average = numbers.stream().mapToDouble(x -> x).average().orElse(0.0);
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        ArrayList<Integer> numbers = (ArrayList<Integer>) session.getAttribute("numbers");
        
        String number = request.getParameter("number");
        int num = Integer.parseInt(number);
        numbers.add(num);
        
        double average = numbers.stream().mapToDouble(x -> x).average().orElse(0.0);
        request.setAttribute("average", average);
        
        getServletContext().getRequestDispatcher("/WEB-INF/average.jsp").forward(request, response);
    }
}
