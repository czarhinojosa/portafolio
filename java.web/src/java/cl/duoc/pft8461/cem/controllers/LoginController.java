/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.pft8461.cem.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Joe
 */

@Controller
@SessionAttributes
public class LoginController {
    
    public LoginController() {
    }
    
    /**
     * Método form, que carga el formulario de login
     * de la aplicación del Sistema CEM.
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = {"login.htm"}, method = RequestMethod.GET)
    public ModelAndView form(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("login");
        return mav;
    }
    
    /**
     * Método postLogin
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = {"postLogin.htm"}, method = RequestMethod.POST)
    public ModelAndView postLogin(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        // Users user = this.users.authenticate(request.getParameter("login"), request.getParameter("password"));
        
        mav.addObject("error", "Usuario o Contraseña no válidos.");

        mav.setViewName("login");
        return mav;
    }
    
    /**
     * Método logout
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = {"salir.htm"}, method = RequestMethod.GET)
    public void logout(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect("./login.htm");
    }
    
    /**
     * Método register
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = {"registrarse.htm"}, method = RequestMethod.GET)
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }
    
    /**
     * Método postRegister
     * 
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException 
     */
    @RequestMapping(value = {"registro.htm"}, method = RequestMethod.POST)
    public ModelAndView postRegister(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession();
        ModelAndView mav = new ModelAndView();
        
        mav.addObject("error", "Usuario o Contraseña no válidos.");

        mav.setViewName("register");
        return mav;
    }
    
}