<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.controlador.*, com.modelo.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilos.css">
        <title>Clínica del Sol</title>
    </head>
<%
    ArrayList<Medico> listaMedicos = (ArrayList<Medico>) request.getAttribute("ListaMedicos");
    String prueba = (String) request.getAttribute("prueba");
%>
    <body>
        <div class="bodyImage"></div>
    <div class="contenedorTodo">
    <header>
        <h1><a class="a_h1" href="index.html">Clínica del Sol</a></h1>
        <h2>Sistema de Gestión de Turnos Médicos</h2>
    </header>
    <div class="contenedor_aside_section_esp">
        
        <section>
            <div style="overflow-x:auto;">
                <table class="tablaPrincipal">
                    <table class="tablaPrincipal">
                        <tr class="trPrincipal">
                            <td class="tdPrincipal">Avatar</td>
                            <td class="tdPrincipal">Apellido</td>
                            <td class="tdPrincipal">Nombre</td>
                            <td class="tdPrincipal">Especialidad</td>
                            <td class="tdPrincipal">Días de Atención</td>
                            <td class="tdPrincipal">Horario</td>
                        </tr>
                        <form action="Controlador" method="POST" enctype="multipart/form-data">
                        <% for(Medico tempMedico : listaMedicos) { %>
                        <tr class="trPrincipal">
                            <td class="tdPrincipal"><img src="ControladorIMG?id=<%=tempMedico.getId()%>"><input type="file" class="inputfile" name="file" id="file"><label for="file">Seleccionar archivo</label></td>
                            <td class="tdPrincipal"><input type="text" name="apellido" id="apellido" value="<%=tempMedico.getApellido()%>" required></td>
                            <td class="tdPrincipal"><input type="text" name="nombre" id="nombre" value="<%=tempMedico.getNombre() %>" required></td>
                            <td class="tdPrincipal">
                                <select name="especialidad" id="especialidad">
                                    <option selected hidden><%=tempMedico.getEspecialidad() %></option>
                                    <option value="Clinica General">Clinica General</option>
                                    <option value="Gastroenterologia">Gastroenterologia</option>
                                    <option value="Cardiologia">Cardiologia</option>
                                    <option value="Pediatria">Pediatria</option>
                                    <option value="Oncologia">Oncologia</option>
                                </select></td>
                            <td class="tdPrincipal"><input type="text" name="dAtencion" id="fechas" value="<%=tempMedico.getdAtencion() %>" required></td>
                            <td class="tdPrincipal"><input type="text" name="horario" id="horario" value="<%=tempMedico.getHorario() %>" required></td>
                            <td><input type="hidden" name="id" value="<%=tempMedico.getId()%>"></td>
                        </tr>
                        <%} %>
                        <tr class="trPincipal">
                            <td class="tdPrincipal tdAdmin" scolspan="2"><button class="formContactenos_button btnAdmin2">Confirmar</button></td>
                            <td><input type="hidden" name="accion" value="actualizando"></td>
                        </tr>
                        
                        </form>
                    </table>
                </table>
            </div>
        </section>
    </div>
    </body>
</html>