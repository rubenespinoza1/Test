package vista;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelLogin extends JPanel implements ActionListener, MouseListener {
    
    private PanelInstrucciones panelIstrucciones;
    private JLabel imagenDeFondo;
    private JButton botonSiguiente;
    private JLabel labelNombre;
    private JLabel labelEdad;
    private JLabel condPsico;
    private JTextField campoNombre;
    private JTextField campoEdad;
    private ButtonGroup grupoBtn;
    private JRadioButton condSi;
    private JRadioButton condNo;

    public PanelLogin() {
        initComponets();
    }

    private void initComponets() {
        
        
        this.imagenDeFondo = new JLabel(new ImageIcon("resources//0.jpg"));
        this.botonSiguiente = new JButton("Siguiente");
        this.labelNombre = new JLabel("Nombre: ");
        this.labelEdad = new JLabel("Edad: ");
        this.condPsico = new JLabel("Posee alguna condicion psicologica?:");
        this.condSi = new JRadioButton("Si");
        this.condNo = new JRadioButton("No");
        this.campoNombre = new JTextField("Ejm :  Juan", 12);
        this.campoEdad = new JTextField("Ejm : 21", 12);
        this.grupoBtn = new ButtonGroup();
        this.grupoBtn.add(this.condSi);
        this.grupoBtn.add(this.condNo);

        this.labelNombre.setForeground(Color.white);
        this.condPsico.setForeground(Color.white);
        this.labelEdad.setForeground(Color.white);
        this.labelNombre.setBounds(205, 225, 250, 35);
        this.labelEdad.setBounds(205, 280, 250, 35);
        this.condPsico.setBounds(100, 340, 250, 35);
        this.campoNombre.setBounds(325, 225, 250, 35);
        this.campoEdad.setBounds(325, 280, 250, 35);
        this.condSi.setBounds(325, 350, 50, 15);
        this.condNo.setBounds(400, 350, 50, 15);
        this.botonSiguiente.setBounds(325, 450, 150, 35);

        this.imagenDeFondo.setLayout(null);
        this.imagenDeFondo.add(this.botonSiguiente);
        this.imagenDeFondo.add(this.campoEdad);
        this.imagenDeFondo.add(this.campoNombre);
        this.imagenDeFondo.add(this.condNo);
        this.imagenDeFondo.add(this.condPsico);
        this.imagenDeFondo.add(this.condSi);
        this.imagenDeFondo.add(this.labelEdad);
        this.imagenDeFondo.add(this.labelNombre);
        this.setPreferredSize(new Dimension(800, 600));
        this.botonSiguiente.addActionListener(this);
        this.campoNombre.addMouseListener(this);
        this.campoEdad.addMouseListener(this);
        this.add(this.imagenDeFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.botonSiguiente){
            Container ventana = this.getParent();
            this.panelIstrucciones = new PanelInstrucciones();
            ventana.remove(this);
            ventana.add(this.panelIstrucciones);
            ventana.validate();
            
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent() == this.campoNombre){
            this.campoNombre.setText("");
        }else if(e.getComponent() == this.campoEdad){
            this.campoEdad.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) { }

    @Override
    public void mouseExited(MouseEvent e) {}

}
