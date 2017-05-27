package conexionbasedatos2015;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class ModificarMysql extends JFrame implements ActionListener {

    Statement s;
    Connection conexion;
    ResultSet rs;
    String Nombre, Apellido,id;
    JLabel LMensaje, LNombre, LApellido,Lid;
    JTextField Tid,TNombre, TApellido;
    JButton Consultar, Modificar, Finalizar;

    public ModificarMysql() {
        setLayout(null);
        Etiquetas();
        CajasTexto();
        Botones();
    }

    public void conexion(String id) {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "");
            s = conexion.createStatement();
            
            rs = s.executeQuery("select * from persona where id="+id+";");
            while (rs.next()) {
                Tid.setText(rs.getString("Id"));
                TNombre.setText(rs.getString(2));
                TApellido.setText(rs.getString(3));
            }
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void modificar(String ids, String Nombres,String Apellidos) {
        try {
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/pruebas", "root", "");
            s = conexion.createStatement();
            s.execute("update persona set Nombre='"+Nombres+"', Apellido='"+Apellidos+"' where id="+ids+";");
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }    
    
    public void Etiquetas() {
        LMensaje = new JLabel("CONSULTA DE DATOS");
        LMensaje.setBounds(50, 20, 300, 20);
        add(LMensaje);
        Lid = new JLabel("ID: ");
        Lid.setBounds(10, 50, 100, 20);
        add(Lid);
        LNombre = new JLabel("Nombre: ");
        LNombre.setBounds(10, 80, 100, 20);
        add(LNombre);
        LApellido = new JLabel("Apellido: ");
        LApellido.setBounds(10, 110, 100, 20);
        add(LApellido);
    }

    public void CajasTexto() {
        Tid = new JTextField();
        Tid.setBounds(120, 50, 100, 20);
        add(Tid);
        TNombre = new JTextField();
        TNombre.setBounds(120, 80, 100, 20);
        add(TNombre);
        TApellido = new JTextField();
        TApellido.setBounds(120, 110, 100, 20);
        add(TApellido);

    }

    public void Botones() {
        Consultar = new JButton("Consultar");
        Consultar.setBounds(10, 140, 100, 20);
        Consultar.addActionListener(this);
        add(Consultar);

        Modificar = new JButton("Modificar");
        Modificar.setBounds(120, 140, 100, 20);
        Modificar.addActionListener(this);
        add(Modificar);
        
        Finalizar = new JButton("Finalizar");
        Finalizar.setBounds(230, 140, 100, 20);
        Finalizar.addActionListener(this);
        add(Finalizar);        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Consultar) {
            id=Tid.getText();
            conexion(id);
        }
        if (e.getSource() == Modificar) {
            id=Tid.getText();
            Nombre=TNombre.getText();
            Apellido=TApellido.getText();            
            modificar(id, Nombre, Apellido);
        }
        if (e.getSource() == Finalizar) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        JFrame app = new ModificarMysql();
        app.setSize(400, 400);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
