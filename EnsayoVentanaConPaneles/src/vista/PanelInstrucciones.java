
package vista;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class PanelInstrucciones extends JPanel implements ActionListener{
    private Ventana ventana;
    private JButton btonInicar;
    private JLabel iconFondo;
   private PanelPreguntasTest panelPreguntasTest;
    public PanelInstrucciones() {
        initComponents();
    }
    
    private void initComponents(){
        this.iconFondo= new JLabel(new ImageIcon("resources//1.jpg"));
        this.btonInicar= new JButton("Iniciar Test");
        this.add(this.iconFondo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
                if (e.getSource() == this.btonInicar){
            Container ventana = this.getParent();
            this.panelPreguntasTest = new PanelPreguntasTest(ventana);
            ventana.remove(this);
            ventana.add(this.panelPreguntasTest);
            ventana.validate();
            
        }
    }
}
