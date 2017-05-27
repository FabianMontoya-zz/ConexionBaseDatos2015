package conexionbasedatos2015;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Inicio extends JFrame implements ActionListener{
    
    JButton B1,B2,B3;
    JLabel LTitulo;
    
    public Inicio(){
        setLayout(null);
        botones();
        titulo();
    }
    
    public void botones(){
        JButton B1 = new JButton ("Insertar");
        B1.setBounds(10,120,90,25);
        add(B1);
    }
    
    public void titulo(){
        
    }
    
    public static void main(String[] args) {
        JFrame app = new Inicio();
        app.setSize(400, 400);
        app.setVisible(true);
        app.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
