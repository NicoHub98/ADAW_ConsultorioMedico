<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="java.util.*, com.controlador.*, com.modelo.*"%>
<html>
    <head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="estilos.css">
    <title>Clínica del Sol</title>
</head>
<%
    ArrayList<Medico> listaMedicos = (ArrayList<Medico>) request.getAttribute("ListaMedicos");
%>
<body>
    <div class="bodyImage"></div>
    <div class="contenedorTodo">
        <header>
            <h1><a class="a_h1" href="index.html">Clínica del Sol</a></h1>
            <h2>Sistema de Gestión de Turnos Médicos</h2>
        </header>
        <div class="contenedor_aside_section">
            <aside class="aside">
                <p class="aside_p">Seleccione la Especialidad Médica</p>
                <div class="aside_contenedor_li">
                    <li class="aside_li"><a href="Controlador?accion=todo">Catálogo</a></li>
                    <li class="aside_li"><a href="Controlador?accion=clinicaGeneral">Clínica General</a></li>
                    <li class="aside_li"><a href="Controlador?accion=gastroenterologia">Gastroenterología</a></li>
                    <li class="aside_li"><a href="Controlador?accion=cardiologia">Cardiología</a></li>
                    <li class="aside_li"><a href="Controlador?accion=pediatria">Pediatría</a></li>
                    <li class="aside_li"><a href="Controlador?accion=oncologia">Oncología</a></li>
                    <li class="aside_li"><a href="contactenos.html">Contáctenos</a></li>
                </div>
            </aside>
            <section>
                <div style="overflow-x:auto;">
                    <table class="tablaPrincipal">
                        <tr class="trPrincipal">
                            <td class="tdPrincipal">Avatar</td>
                            <td class="tdPrincipal">Apellido</td>
                            <td class="tdPrincipal">Nombre</td>
                            <td class="tdPrincipal">Especialidad</td>
                            <td class="tdPrincipal">Días de Atención</td>
                            <td class="tdPrincipal">Horario</td>
                        </tr>
                        <% for(Medico tempMedico : listaMedicos) { %>
                        <tr class="trPrincipal">
                            <td class="tdPrincipal"><a href="Controlador?accion=verIndividual&id=<%=tempMedico.getId()%>"><img src="ControladorIMG?id=<%=tempMedico.getId()%>"></a></td>
                            <td class="tdPrincipal"><%=tempMedico.getApellido() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getNombre() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getEspecialidad() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getdAtencion() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getHorario() %></td>
                        </tr>
                        <%} %>
                    </table>
                </div>
            </section>
        </div>
    </div>
</body>
</html>
