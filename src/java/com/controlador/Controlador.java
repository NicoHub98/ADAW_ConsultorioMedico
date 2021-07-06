/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.modelo.*;
import java.io.InputStream;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

@MultipartConfig
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String forward = "/catalogo.jsp";
        RequestDispatcher rd;
        Consultas consultas = new Consultas();
        
        
        ArrayList<Medico> listaMedico = new ArrayList<Medico>();
        try {
            String esp = request.getParameter("accion");
        
        switch(esp){
            
            case "todo":
                
                listaMedico = consultas.leer();

                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
            
                //Enviar el request a la página jsp
                
                forward = "/catalogo.jsp";
                break;
                
            case "verIndividual":
                
                int verInd = Integer.parseInt(request.getParameter("id"));
                
                listaMedico = consultas.leerIndividualById(verInd);
                
                request.setAttribute("ListaMedicos", listaMedico);
                
                forward = "/catalogo_individual.jsp";
                
                
                break;
                
            case "clinicaGeneral":
                
                listaMedico = consultas.leerIndividual("clinica General");
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
            
                //Enviar el request a la página jsp
                
                forward = "/catalogo.jsp";
                
                break;
                
            case "gastroenterologia":
                
                listaMedico = consultas.leerIndividual("gastroenterologia");
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
            
                //Enviar el request a la página jsp
                
                forward = "/catalogo.jsp";
                
                break;
                
            case "cardiologia":
                
                listaMedico = consultas.leerIndividual("cardiologia");
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
            
                //Enviar el request a la página jsp
                
                forward = "/catalogo.jsp";
                
                break;
                
            case "pediatria":
                
                listaMedico = consultas.leerIndividual("pediatria");
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
            
                //Enviar el request a la página jsp
                
                forward = "/catalogo.jsp";
                
                break;
                
            case "oncologia":
                
                listaMedico = consultas.leerIndividual("oncología");
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
            
                //Enviar el request a la página jsp
                
                forward = "/catalogo.jsp";
                
                break;
                
            case "opcAdmin":
                
                listaMedico = consultas.leer();
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
                
                //Enviar el request a la página jsp
                
                forward = "/opcAdmin.jsp";
                
                break;
                
            case "actualizar":
                
                int espAct = Integer.parseInt(request.getParameter("id"));
                
                listaMedico = consultas.leerIndividualById(espAct);
                
                request.setAttribute("ListaMedicos", listaMedico);
                
                forward = "/actualizar.jsp";
                
                break;
                
            case "actualizando":
                
                Medico medicoAct = new Medico();
                Part part = request.getPart("file");
                InputStream inputStream = part.getInputStream();
                medicoAct.setImagen(inputStream);
                medicoAct.setId(Integer.parseInt(request.getParameter("id")));
                medicoAct.setNombre(request.getParameter("nombre"));
                medicoAct.setApellido(request.getParameter("apellido"));
                medicoAct.setEspecialidad(request.getParameter("especialidad"));
                medicoAct.setdAtencion(request.getParameter("dAtencion"));
                medicoAct.setHorario(request.getParameter("horario"));
                
                
                if(part.getSize() == 0){
                    consultas.actualizarSinImagen(medicoAct);
                }else{
                    consultas.actualizar(medicoAct);
                }
                
                listaMedico = consultas.leer();
                
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
                
                forward="/opcAdmin.jsp";
                
                break;
                
            case "agregar":
                
                Medico medico = new Medico();
                medico.setNombre(request.getParameter("nombre"));
                medico.setApellido(request.getParameter("apellido"));
                medico.setEspecialidad(request.getParameter("especialidad"));
                medico.setdAtencion(request.getParameter("dAtencion"));
                medico.setHorario(request.getParameter("horario"));
                
                Part part2 = request.getPart("file");
                InputStream inputstream  = part2.getInputStream();
                medico.setImagen(inputstream);
                
                consultas.registrar(medico);
                
                listaMedico = consultas.leer();
                //Agregar la lista de medicos al request
                request.setAttribute("ListaMedicos", listaMedico);
                forward="/opcAdmin.jsp";
                break;
                
            case "eliminar":
                
                int idElim = Integer.parseInt(request.getParameter("id"));
                
                consultas.eliminar(idElim);
                listaMedico = consultas.leer();
                request.setAttribute("ListaMedicos", listaMedico);
                forward="/opcAdmin.jsp";
                
                break;
                
            default:
                listaMedico = consultas.leer();
                request.setAttribute("ListaMedicos", listaMedico);
                forward="/opcAdmin.jsp";
                break;
            
        }
        rd = request.getRequestDispatcher(forward);
        rd.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        out.println("<p>Get</p>");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();
        out.println("<p>Post</p>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
