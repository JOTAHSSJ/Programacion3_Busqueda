import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmBusquedaGUI {
    private JPanel pGeneral;
    private JTextField txtElemento;
    private JButton agregarButton;
    private JButton eliminarButton;
    private JButton ordenarButton;
    private JButton buscarLinealButton;
    private JButton buscarInterpoladaButton;
    private JTextArea txtResultado;
    private JButton mostrarButton;
    private JButton buscarBinariaButton;

    Lista lista=new Lista();

    public FrmBusquedaGUI() {

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String input=txtElemento.getText();

                try {
                    int valor=Integer.parseInt(input);
                    lista.agregar(valor,txtResultado);
                    txtElemento.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error");

                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=txtElemento.getText();

                try {
                    int valor=Integer.parseInt(input);
                    lista.eliminar(valor,txtResultado);
                    txtElemento.setText("");
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error");

                }
            }
        });

        ordenarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.ordenarBurbuja(txtResultado);
                JOptionPane.showMessageDialog(null,"Ordenado");
            }

        });

        mostrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.mostrarLista(txtResultado);
            }
        });

        buscarLinealButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=txtElemento.getText();

                try{
                    int valor=Integer.parseInt(input);
                    int posicion= lista.busquedaLineal(valor,txtResultado);
                    if(posicion==-1){
                        JOptionPane.showMessageDialog(null,"Elemento no encontrado");
                    }else{
                        JOptionPane.showMessageDialog(null,"Elemento encontrado en la posicion: "+posicion);
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });

        buscarInterpoladaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=txtElemento.getText();

                try{
                    int valor=Integer.parseInt(input);
                    int posicion= lista.buscarInterpolada(valor,txtResultado);
                    if(posicion==-1){
                        JOptionPane.showMessageDialog(null,"Elemento no encontrado");
                    }else{
                        JOptionPane.showMessageDialog(null,"Elemento encontrado en la posicion: "+posicion);
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });

        buscarBinariaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input=txtElemento.getText();

                try{
                    int valor=Integer.parseInt(input);
                    int posicion= lista.buscarBinaria(valor,txtResultado);
                    if(posicion==-1){
                        JOptionPane.showMessageDialog(null,"Elemento no encontrado");
                    }else{
                        JOptionPane.showMessageDialog(null,"Elemento encontrado en la posicion: "+posicion);
                    }

                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("FrmBusquedaGUI");
        frame.setContentPane(new FrmBusquedaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
