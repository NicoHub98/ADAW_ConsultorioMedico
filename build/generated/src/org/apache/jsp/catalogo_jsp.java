package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.*;
import com.controlador.*;
import com.modelo.*;

public final class catalogo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <link rel=\"stylesheet\" href=\"estilos.css\">\n");
      out.write("    <title>Clínica del Sol</title>\n");
      out.write("</head><!--\n");

    ArrayList<Medico> listaMedicos = (ArrayList<Medico>) request.getAttribute("ListaMedicos");

      out.write("-->\n");
      out.write("<body>\n");
      out.write("    <div class=\"bodyImage\"></div>\n");
      out.write("    <div class=\"contenedorTodo\">\n");
      out.write("        <header>\n");
      out.write("            <h1><a class=\"a_h1\" href=\"index.html\">Clínica del Sol</a></h1>\n");
      out.write("            <h2>Sistema de Gestión de Turnos Médicos</h2>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"contenedor_aside_section\">\n");
      out.write("            <aside class=\"aside\">\n");
      out.write("                <p class=\"aside_p\">Seleccione la Especialidad Médica</p>\n");
      out.write("                <div class=\"aside_contenedor_li\">\n");
      out.write("                    <li class=\"aside_li\"><a href=\"Controlador?accion=todo\">Catálogo</a></li>\n");
      out.write("                    <li class=\"aside_li\"><a href=\"Controlador?accion=clinicaGeneral\">Clínica General</a></li>\n");
      out.write("                    <li class=\"aside_li\"><a href=\"Controlador?accion=gastroenterologia\">Gastroenterología</a></li>\n");
      out.write("                    <li class=\"aside_li\"><a href=\"Controlador?accion=cardiologia\">Cardiología</a></li>\n");
      out.write("                    <li class=\"aside_li\"><a href=\"Controlador?accion=pediatria\">Pediatría</a></li>\n");
      out.write("                    <li class=\"aside_li\"><a href=\"Controlador?accion=oncologia\">Oncología</a></li>\n");
      out.write("                    <li class=\"aside_li\"><a href=\"contactenos.html\">Contáctenos</a></li>\n");
      out.write("                </div>\n");
      out.write("            </aside>\n");
      out.write("            <section>\n");
      out.write("                <div style=\"overflow-x:auto;\">\n");
      out.write("                    <table class=\"tablaPrincipal\">\n");
      out.write("                        <tr class=\"trPrincipal\">\n");
      out.write("                            <td class=\"tdPrincipal\">Avatar</td>\n");
      out.write("                            <td class=\"tdPrincipal\">Apellido</td>\n");
      out.write("                            <td class=\"tdPrincipal\">Nombre</td>\n");
      out.write("                            <td class=\"tdPrincipal\">Especialidad</td>\n");
      out.write("                            <td class=\"tdPrincipal\">Días de Atención</td>\n");
      out.write("                            <td class=\"tdPrincipal\">Horario</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 for(Medico tempMedico : listaMedicos) { 
      out.write("\n");
      out.write("                        <tr class=\"trPrincipal\">\n");
      out.write("                            <td class=\"tdPrincipal\">imagen</a></td>\n");
      out.write("                            <td class=\"tdPrincipal\">");
      out.print(tempMedico.getApellido() );
      out.write("</td>\n");
      out.write("                            <td class=\"tdPrincipal\">");
      out.print(tempMedico.getNombre() );
      out.write("</td>\n");
      out.write("                            <td class=\"tdPrincipal\">");
      out.print(tempMedico.getEspecialidad() );
      out.write("</td>\n");
      out.write("                            <td class=\"tdPrincipal\">");
      out.print(tempMedico.getdAtencion() );
      out.write("</td>\n");
      out.write("                            <td class=\"tdPrincipal\">");
      out.print(tempMedico.getHorario() );
      out.write("</td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
} 
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("            </section>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
