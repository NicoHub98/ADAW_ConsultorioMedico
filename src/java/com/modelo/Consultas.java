package com.modelo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.http.HttpServletResponse;

public class Consultas extends Conexion {
    
    Connection con = getConexion();
    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    String sql = "";
    
    public ArrayList<Medico> leer(){
        
        ArrayList<Medico> listaMedico = new ArrayList<Medico>();
        
        sql = "select * from medico";
        
        try {
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String especialidad = rs.getString("especialidad");
                String dAtencion = rs.getString("dAtencion");
                String horario = rs.getString("horario");
                InputStream is = rs.getBinaryStream("imagen");
                
                Medico medico = new Medico(id, nombre, apellido, especialidad, dAtencion, horario);
                medico.setImagen(is);
                listaMedico.add(medico);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMedico;
    }
    
    public void leerImagen(int id, HttpServletResponse response){
        sql = "select * from medico where id=" + id;
        InputStream inputstream = null;
        OutputStream outputstream = null;
        BufferedInputStream bufferedinputstream= null;
        BufferedOutputStream bufferedoutputstream = null;
        response.setContentType("image/*");
            
        try {
            
            outputstream = response.getOutputStream();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            if(rs.next()){
                inputstream = rs.getBinaryStream("imagen");
            }
            
            bufferedinputstream = new BufferedInputStream(inputstream);
            bufferedoutputstream = new BufferedOutputStream(outputstream);
            int i = 0;
            while((i=bufferedinputstream.read())!=-1){
                bufferedoutputstream.write(i);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Medico> leerIndividual(String esp){
        
        ArrayList<Medico> listaMedico = new ArrayList<Medico>();
        
        sql = "select * from medico where especialidad=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, esp);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String especialidad = rs.getString("especialidad");
                String dAtencion = rs.getString("dAtencion");
                String horario = rs.getString("horario");
                
                Medico medico = new Medico(id, nombre, apellido, especialidad, dAtencion, horario);
                listaMedico.add(medico);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMedico;
        
    }
    
    public ArrayList<Medico> leerIndividualById(int id){
        
        ArrayList<Medico> listaMedico = new ArrayList<Medico>();
        
        sql = "select * from medico where id=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                int idLeida = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String especialidad = rs.getString("especialidad");
                String dAtencion = rs.getString("dAtencion");
                String horario = rs.getString("horario");
                
                Medico medico = new Medico(idLeida, nombre, apellido, especialidad, dAtencion, horario);
                listaMedico.add(medico);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaMedico;
        
    }
    
    public boolean registrar(Medico medico){
        
        sql = "insert into medico(nombre, apellido, especialidad, dAtencion, horario, imagen) values(?, ?, ?, ?, ?, ?)";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getEspecialidad());
            ps.setString(4, medico.getdAtencion());
            ps.setString(5, medico.getHorario());
            ps.setBlob(6, medico.getImagen());
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizar(Medico medico){
        
        sql = "update medico set nombre=?, apellido=?, especialidad=?, dAtencion=?, horario=?, imagen=? where id=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getEspecialidad());
            ps.setString(4, medico.getdAtencion());
            ps.setString(5, medico.getHorario());
            ps.setBlob(6, medico.getImagen());
            ps.setInt(7, medico.getId());
            
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean actualizarSinImagen(Medico medico){
        
        sql = "update medico set nombre=?, apellido=?, especialidad=?, dAtencion=?, horario=? where id=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setString(1, medico.getNombre());
            ps.setString(2, medico.getApellido());
            ps.setString(3, medico.getEspecialidad());
            ps.setString(4, medico.getdAtencion());
            ps.setString(5, medico.getHorario());
            ps.setInt(6, medico.getId());
            
            ps.executeUpdate();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
    public boolean eliminar(int id){
        
        sql = "delete from medico where id=?";
        
        try {
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }
    
}
