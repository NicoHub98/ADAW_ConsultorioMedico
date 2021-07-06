<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*, com.controlador.*, com.modelo.*"%>
<html>
    <head>
        <meta charset="utf-8">
        <link rel="stylesheet" href="estilos.css">
        <title>Clínica del Sol</title>
        <script>
        function registrar(){
            alert("Turno registrado con éxito!");
        }
        </script>
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
                            <% for (Medico tempMedico : listaMedicos) {%>
                            <tr class="trPrincipal">
                                <td class="tdPrincipal" rowspan="6"><img class="img_individual" src="ControladorIMG?id=<%=tempMedico.getId()%>" alt="Gustavo Silva"></td>
                            </tr>
                            <tr class="trPrincipal">
                                <td class="tdPrincipal"><%=tempMedico.getNombre()%></td>
                            </tr>
                            <tr class="trPrincipal">
                                <td class="tdPrincipal"><%=tempMedico.getApellido()%></td>
                            </tr>
                            <tr class="trPrincipal">
                                <td class="tdPrincipal"><%=tempMedico.getEspecialidad()%></td>
                            </tr>
                            <tr class="trPrincipal">
                                <td class="tdPrincipal"><%=tempMedico.getdAtencion()%></td>
                            </tr>
                            <tr class="trPrincipal">
                                <td class="tdPrincipal"><%=tempMedico.getHorario()%></td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                        <div class="container_solicitaTurno">
                <fieldset>
                    <legend style="font-weight: bold;">Datos del Paciente</legend>
                    <form action="Controlador">
                    <table class="solicitaTurno_Tabla">
                        <tr class="solicitaTurno_tr">
                            <td class="solicitaTurno_td"><label for="apellido">Apellido:</label></td>
                            <td class="solicitaTurno_td"><input type="text" name="apellido" size="85"></td>
                        </tr>
                        <tr class="solicitaTurno_tr">
                            <td class="solicitaTurno_td"><label for="nombre">Nombre:</label></td>
                            <td class="solicitaTurno_td"><input type="text" name="nombre" size="85"></td>
                        </tr>
                        <tr class="solicitaTurno_tr">
                            <td class="solicitaTurno_td"><label for="dni">DNI:</label></td>
                            <td class="solicitaTurno_td"><input type="number" name="dni"></td>
                        </tr>
                        <tr class="solicitaTurno_tr">
                            <td class="solicitaTurno_td"><label for="email">Email:</label></td>
                            <td class="solicitaTurno_td"><input type="email" name="email" size="85"></td>
                        </tr>
                        <tr class="solicitaTurno_tr">
                            <td class="solicitaTurno_td"><label for="fecha">Fecha del turno:</label></td>
                            <td class="solicitaTurno_td"><input type="date" name="fecha"></td>
                        </tr>
                        <tr class="solicitaTurno_tr">
                            <td class="solicitaTurno_td"><label for="horario">Horario del turno:</label></td>
                            <td class="solicitaTurno_td"><input type="time" name="horario"></td>
                        </tr>
                        <tr>
                            <td><input onclick="registrar()" class="solicitaTurno_Boton" type="submit" value="Registrar Turno"></td>
                            <td style="text-align: right;"><input class="solicitaTurno_Boton" type="submit" value="Volver al Catálogo"></td>
                            <td><input type="hidden" name="accion" value="todo"></td>
                        </tr>
                    </table>
                </form>
                </fieldset>
            </div>
                </section>
            </div>
        </div>
    </body>
</html>