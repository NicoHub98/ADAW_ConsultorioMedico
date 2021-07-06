<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.controlador.*, com.modelo.*"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
        <!--<meta charset="utf-8">-->
        <link rel="stylesheet" href="estilos.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
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
                <a href="" class="opcAdmin">Opciones de Administrador</a>
            </header>
            <div class="contenedor_aside_section">
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
                                <td class="tdPrincipal tdOpc">Actualizar / Eliminar</td>
                            </tr>
                            <% for(Medico tempMedico : listaMedicos) { %>
                        <tr class="trPrincipal">
                            <td class="tdPrincipal"><img src="ControladorIMG?id=<%=tempMedico.getId()%>"></td>
                            <!--<td class="tdPrincipal">imagen</a></td>-->
                            <td class="tdPrincipal"><%=tempMedico.getApellido() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getNombre() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getEspecialidad() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getdAtencion() %></td>
                            <td class="tdPrincipal"><%=tempMedico.getHorario() %></td>
                            <td class="tdPrincipal tdOpc">
                                <a href="Controlador?accion=actualizar&id=<%=tempMedico.getId()%>">
                                    <img class="icono" src="Img/outline_update_black_24dp.png" alt="Actualizar">
                                </a>
                                <a href='Controlador?accion=eliminar&id=<%=tempMedico.getId()%>' onclick="return confirm('¿Está seguro?');">
                                    <img class="icono" src="Img/outline_delete_black_24dp.png" alt="Eliminar">
                                </a>
                            </td>
                        </tr>
                        <%} %>
                        <form action="Controlador" method="POST" enctype="multipart/form-data">
                        <tr class="trPrincipal">
                            <td class="tdPrincipal"><input type="file" class="inputfile" name="file" id="file"><label for="file">Seleccionar archivo</label></td>
                                <td class="tdPrincipal"><input class="inputAgregar" type="text" name="nombre" id="nombre" placeholder="Nombre" required></td>
                                <td class="tdPrincipal"><input class="inputAgregar" type="text" name="apellido" id="apellido" placeholder="Apellido" required></td>
                                <td class="tdPrincipal"><select name="especialidad" id="especialidad">
                                        <option value="Clinica General">Clínica General</option>
                                        <option value="Gastroenterologia">Gastroenterología</option>
                                        <option value="Cardiologia">Cardiología</option>
                                        <option value="Pediatria">Pediatría</option>
                                        <option value="Oncologia">Oncología</option>
                                    </select></td>
                                <td class="tdPrincipal"><input class="inputAgregar" type="text" name="dAtencion" id="dAtencion" placeholder="Días atención" required></td>
                                <td class="tdPrincipal"><input class="inputAgregar" type="text" name="horario" id="horario" placeholder="Horario atención" required></td>
                                
                                <td class="tdPrincipal"><button class="formContactenos_button btnAdmin">Agregar</button></td>
                                <td><input type="hidden" name="accion" value="agregar"></td>
                        </tr>
                        </form>
                        </table>
                    </div>
                </section>
            </div>
        </div>
    </body>
</html>