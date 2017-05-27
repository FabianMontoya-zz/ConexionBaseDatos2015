package conexionbasedatos2015;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class insertarMysql extends JFrame implements ActionListener {

    Statement s;
    Connection conexion;
    String Nombre,Apellido;
    JLabel LMensaje,LNombre,LApellido;
    JTextField TNombre, TApellido;
    JButton Insertar, Finalizar;
    public insertarMysql() {
        setLayout(null);
        Etiquetas();
        CajasTexto();
        Botones();
    }
    
    public void conexion(String Nombres,String Apellidos) {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "");
            s = conexion.createStatement();
            System.out.println(Nombres+" "+Apellidos);
            s.execute("insert into persona values(id,'"+Nombres+"', '"+Apellidos+"')");
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void Etiquetas(){
        LMensaje=new JLabel("INSERCION DE DATOS");
        LMensaje.setBounds(50,20,300,20);
        add(LMensaje);        
        LNombre=new JLabel("Nombre: ");
        LNombre.setBounds(10,50,100,20);
        add(LNombre);
        LApellido=new JLabel("Apellido: ");
        LApellido.setBounds(10,80,100,20);
        add(LApellido);
    }
    public void CajasTexto(){
        TNombre=new JTextField();
        TNombre.setBounds(120,50,100,20);
        add(TNombre);
        TApellido=new JTextField();
        TApellido.setBounds(120,80,100,20);
        add(TApellido);
        
    }
    public void Botones(){
        Insertar=new JButton("Insertar");
        Insertar.setBounds(10,120,100,20);
        Insertar.addActionListener(this);
        add(Insertar);
        Finalizar=new JButton("Finalizar");
        Finalizar.setBounds(120,120,100,20);
        Finalizar.addActionListener(this);
        add(Finalizar);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource()==Insertar){
           Nombre=TNombre.getText();
           Apellido=TApellido.getText();
           conexion(Nombre,Apellido);
       }
       if(e.getSource()==Finalizar){
           System.exit(0);
       }
    }

    public static void main(String[] args) {
        JFrame app = new insertarMysql();
        app.setSize(400, 400);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
