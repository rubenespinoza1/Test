package vista;

import control.GestorContador;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelPreguntasTest extends JPanel implements ActionListener {

    private PanelBotones panelBotones;
    private PanelImagen panelImagen;
    private JButton botonSiguiente;
    private int contador;
    private Container ventana;

    public PanelPreguntasTest(Container ventana) {
        this.ventana = ventana;
        initComponents();
    }

    private void initComponents() {
        this.contador = GestorContador.getInstance().getContador();
        this.setLayout(new BorderLayout());
        this.panelBotones = new PanelBotones();
        this.panelImagen = new PanelImagen();
        this.botonSiguiente = new JButton("Siguiente");
        JPanel panelInferior = new JPanel(new BorderLayout());
        JPanel panelInferiorBtnSig = new JPanel(new FlowLayout());
        panelInferiorBtnSig.add(this.botonSiguiente);
        panelInferior.add(this.panelBotones, BorderLayout.CENTER);
        panelInferior.add(panelInferiorBtnSig, BorderLayout.PAGE_END);
        this.botonSiguiente.addActionListener(this);
        this.add(this.panelImagen, BorderLayout.NORTH);
        this.add(panelInferior, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == this.botonSiguiente) {
            for (int i = 0; i < this.panelBotones.getSeleccionTest().length; i++) {
                if (this.panelBotones.getSeleccionTest()[i].isSelected()) {
                    System.out.println("this.contador: " + this.contador);
                    this.panelImagen.removerTodo();
                    this.panelImagen.modificarPanel(this.contador);
                    this.panelBotones.cambiarBotones();
                    this.panelBotones.removerBotones();
                    this.contador++;
                    GestorContador.getInstance().setContador(this.contador);
                    
                    
                }
            }
        }
    }

}
