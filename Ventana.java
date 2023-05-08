package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;

public class Ventana extends JFrame {
    private JPanel panel1;
    private JButton boton1;
    private JLabel etiqueta1;
    private JPanel panel2;
    private JLabel etiqueta2;
    private JPanel panel3;
    private JComboBox<String> comboBoxPanel3;
    private JPanel panel4;
    private GridLayout layout;

    public Ventana(String title) throws HeadlessException {
        super(title);
        this.setSize(800, 600);
        layout = new GridLayout(2, 2);
        this.getContentPane().setLayout(layout);

        //panel1
        panel1 = new JPanel();

        panel1.setBackground(new Color(250, 224, 221));
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        boton1 = new JButton("Presioname!");
        panel1.add(boton1);
        etiqueta1 = new JLabel("....");
        panel1.add(etiqueta1);
        boton1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                etiqueta1.setText("Hola, presionaste el boton del panel");
            }
        });

        this.getContentPane().add(panel1, 0);

        //panel2
        String urlimagen = "https://static.wikia.nocookie.net/sonic/images/2/2c/SF_Sonic.png/revision/latest?cb=20221127233258&path-prefix=es";
        panel2 = new JPanel();

        panel2.setBackground(new Color(222,245,204));
        panel2.setLayout( new FlowLayout());
        //Cargar la imagen de internet

        try {
            URL url = new URL(urlimagen);
            Image imagen = ImageIO.read(url);
            ImageIcon imagenIcon = new ImageIcon(imagen);
            etiqueta2 = new JLabel(imagenIcon);
            panel2.add(etiqueta2);
            this.getContentPane().add(panel2,1);
        }catch (MalformedURLException me){
            System.out.println("url no valida");
        }catch (Exception e){
            System.out.println("Error al cargar la imagen");
        }

        //panel3
        panel3 = new JPanel();
        panel3.setBackground(new Color(231, 221, 250));

        panel3.setLayout(new FlowLayout(FlowLayout.RIGHT));
        String[] elementos = {"Opcion1, Opcion2, Opcion3, Opcion4"};
        comboBoxPanel3 = new JComboBox<>(elementos);
        comboBoxPanel3.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println(actionEvent.getSource().toString());
                System.out.println(comboBoxPanel3.getSelectedIndex());
            }
        });
        panel3.add(comboBoxPanel3);

        this.getContentPane().add(panel3,2);

        //panel4
        panel4 = new JPanel();

        panel4.setBackground(new Color(221, 237, 250));
        this.getContentPane().add(panel4,3);

        this.setVisible(true);
    }
}
