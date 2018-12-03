package vista;

import control.GestorContador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PanelBotones extends JPanel implements ActionListener {

    private PanelImagen panelImagen;
    private int[] respuestasUsuario = new int[60];
    private JRadioButton[] seleccionTest;
    private JRadioButton[][] btnesPreguntasTest;
    private ButtonGroup grupoBtnes;

    public PanelBotones() {
        this.initComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < this.seleccionTest.length; i++) {
            if (this.seleccionTest[i].isSelected()) {
                this.seleccionTest[i].setText("(" + "*" + ")");
            } else {
                this.seleccionTest[i].setText("");
            }
        }
    }

    private void initComponents() {
        this.setLayout(new GridLayout(2, 4, 10, 10));
        this.grupoBtnes = new ButtonGroup();
        this.seleccionTest = new JRadioButton[8];
        this.btnesPreguntasTest = new JRadioButton[60][8];

        for (int i = 0; i < this.btnesPreguntasTest.length; i++) {
            for (int j = 0; j < this.btnesPreguntasTest[i].length; j++) {
                this.btnesPreguntasTest[i][j] = new JRadioButton(new ImageIcon("resources//packB" + (i + 1) + "//" + j + ".jpg"));

            }
        }
        cambiarBotones();
        this.seleccionTest[6].setVisible(false);
        this.seleccionTest[7].setVisible(false);
    }

    public JRadioButton[] getSeleccionTest() {
        return seleccionTest;
    }

    public void cambiarBotones() {
        for (int i = 0; i < 8; i++) {
            this.seleccionTest[i] = new JRadioButton(new ImageIcon("resources//packB" + GestorContador.getInstance().getContador() + "//b" + i + ".png"));
            this.grupoBtnes.add(this.seleccionTest[i]);
            this.seleccionTest[i].addActionListener(this);
            this.add(this.seleccionTest[i]);
        }
        validate();
    }
    
    public void removerBotones(){
        for (JRadioButton jRadioButton : this.seleccionTest) {
            this.remove(jRadioButton);
        }
    }

}
