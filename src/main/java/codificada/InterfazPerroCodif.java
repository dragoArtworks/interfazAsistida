
package codificada;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel esteban rivera gomez
 */
//programacion II
public class InterfazPerroCodif extends JFrame implements ActionListener{
    JLabel titulo,lema,perroGrand,perroMed,perroPeq,horas;
    JPanel header,subHeader;
    JTextField textGran,textMed,textPeq,textHoras;
    JButton enviar;
    
    public static void main(String[] args) {
        InterfazPerroCodif interfaz=new InterfazPerroCodif();
        
    }
    public InterfazPerroCodif() throws HeadlessException{
        setBounds(600,250, 500, 400);
       
        header = new JPanel(new GridBagLayout()) ;
        GridBagConstraints gbc = new GridBagConstraints();
        titulo=new JLabel("Cheems pet");
        titulo.setFont(new java.awt.Font("Monospaced", 1, 40));
        titulo.setForeground(new java.awt.Color(102, 68, 0));
        gbc.gridwidth = 1;
        gbc.weightx=1.0;
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        
        header.add(titulo,gbc);
        
        lema=new JLabel("Los mejores paseos de tu amigo canino");
        lema.setFont(new java.awt.Font("Monospaced", 0, 15));
        lema.setForeground(new java.awt.Color(102, 68, 0));
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        header.add(lema,gbc);
      
        perroGrand=new JLabel("Cuantos perros grandes desea agregar");
        perroGrand.setFont(new java.awt.Font("Monospaced", 1, 12));
        perroGrand.setForeground(new java.awt.Color(102, 68, 0));
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.gridx=0;
        gbc.gridy=2;
        header.add(perroGrand,gbc);
        
        textGran=new JTextField();
        textGran.setBackground(new java.awt.Color(235, 222, 194));
        gbc.gridx=2;
        gbc.gridy=2;
        gbc.anchor = GridBagConstraints.LINE_START; // Alinea el JTextField a la izquierda
        gbc.fill = GridBagConstraints.HORIZONTAL; // Permite que el JTextField se expanda horizontalmente
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        gbc.insets = new Insets(0, 0, 5, 5);
        header.add(textGran,gbc);
        
        perroMed=new JLabel("Cuantos perros medianos desea agregar?");
        perroMed.setFont(new java.awt.Font("Monospaced", 1, 12));
        perroMed.setForeground(new java.awt.Color(102, 68, 0));
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        header.add(perroMed,gbc);
        
        textMed=new JTextField();
        textMed.setBackground(new java.awt.Color(235, 222, 194));
        gbc.gridx=2;
        gbc.gridy=3;
        gbc.anchor = GridBagConstraints.LINE_START; 
        gbc.fill = GridBagConstraints.HORIZONTAL; 
        gbc.gridwidth = GridBagConstraints.REMAINDER; 
        gbc.insets = new Insets(0, 0, 5, 5);
        header.add(textMed,gbc);
        
        perroPeq=new JLabel("¿cuantos perros pequeños desea agregar?");
        perroPeq.setFont(new java.awt.Font("Monospaced", 1, 12));
        perroPeq.setForeground(new java.awt.Color(102, 68, 0));
        gbc.gridx=0;
        gbc.gridy=4;
        header.add(perroPeq,gbc);
        
        textPeq=new JTextField();
        textPeq.setBackground(new java.awt.Color(235, 222, 194));
        gbc.gridx=2;
        gbc.gridy=4;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets=new Insets(0,0,5,5);
        header.add(textPeq,gbc);
        
        horas=new JLabel("¿cuantos horas de paseo desea?");
        horas.setFont(new java.awt.Font("Monospaced", 1, 12));
        horas.setForeground(new java.awt.Color(102, 68, 0));
        gbc.gridx=0;
        gbc.gridy=5;
        header.add(horas,gbc);
        
        textHoras=new JTextField();
        textHoras.setBackground(new java.awt.Color(235, 222, 194));
        gbc.gridx=2;
        gbc.gridy=5;
        gbc.anchor=GridBagConstraints.LINE_START;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        gbc.gridwidth=GridBagConstraints.REMAINDER;
        gbc.insets=new Insets(0,0,5,5);
        header.add(textHoras,gbc);
        
        enviar = new JButton("enviar");
        enviar.setBackground(new java.awt.Color(159, 111, 16));
        enviar.setFont(new java.awt.Font("Monospaced", 1, 14)); 
        enviar.setForeground(new java.awt.Color(41, 31, 10));
        gbc.gridx=0;
        gbc.gridy=7;
        gbc.anchor=GridBagConstraints.CENTER;
        gbc.fill=GridBagConstraints.HORIZONTAL;
        enviar.addActionListener(this);
        header.add(enviar,gbc);
        
        

        setUndecorated(true);
        add(header);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action= e.getActionCommand();//obtenemos
        int horasPaseo=0;
        int grandes=0;
        int medianos=0;
        int pequenos=0;
        final int precioPeq=3000;
        final int precioMed=5000;
        final int precioGrand=10000;
        if(action.equals("enviar")){
            if(!textHoras.getText().matches("[0-9]+")||!textGran.getText().matches("[0-9]+")||!textMed.getText().matches("[0-9]+")||
                 !textPeq.getText().matches("[0-9]+")){ 
                JOptionPane.showMessageDialog(this, "no puedes ingresar letras");
            }else if(Integer.parseInt(textGran.getText())<0 ||Integer.parseInt(textGran.getText())>10 ||textGran.getText().equals("")){
                JOptionPane.showMessageDialog(this,"no puedes agregar mas de diez perros");
            }else if(Integer.parseInt(textMed.getText())<0 || Integer.parseInt(textMed.getText())>10||textMed.getText().equals("")){
                JOptionPane.showMessageDialog(this,"no puedes agregar mas de diez perros");
            }else if(Integer.parseInt(textPeq.getText())<0 || Integer.parseInt(textPeq.getText())>10||textPeq.getText().equals("")){
                JOptionPane.showMessageDialog(this,"no puedes agregar mas de diez perros");
            }else if(Integer.parseInt(textHoras.getText())<1 || Integer.parseInt(textHoras.getText())>12 ||textHoras.getText().equals("")){
                JOptionPane.showMessageDialog(this,"no ofrecemos paseos de mas de 12 horas ");
            }else if(Integer.parseInt(textGran.getText())==0&&Integer.parseInt(textMed.getText())==0&&Integer.parseInt(textPeq.getText())==0){
                JOptionPane.showMessageDialog(this, "no estas agregando ningun perro");
            }else{
            JOptionPane.showMessageDialog(this,"🐶perros agregados con exito🐶");
            horasPaseo=Integer.parseInt(textHoras.getText());
            grandes=Integer.parseInt(textGran.getText());
            medianos=Integer.parseInt(textMed.getText());
            pequenos=Integer.parseInt(textPeq.getText());
            textHoras.setText("");
            textGran.setText("");
            textMed.setText("");
            textPeq.setText("");
            int costo=(horasPaseo*grandes*precioGrand)+(horasPaseo*medianos*precioMed)+(horasPaseo*pequenos*precioPeq);
     
            if(grandes+medianos+pequenos>1){
                costo=(int)(costo-(costo*0.1));
            }
            JOptionPane:JOptionPane.showMessageDialog(this, "el costo total es de $"+ costo);
         }
       }    
        
        
    }
}
