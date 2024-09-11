/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author jhona
 */
import Abstraccion.*;
import Implementador.color.*;
import Implementador.talla.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

public class PrendaGUI extends JFrame {
    private JComboBox<String> prendaCombo, colorCombo, tallaCombo;
    private JTextArea resultado;
    private JButton crearPrendaBtn;
    private ArrayList<Abstract_prenda> prendasCreadas;  // Lista para guardar las prendas creadas

    public PrendaGUI() {
        setTitle("Creador de Prendas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        prendasCreadas = new ArrayList<>();  // Inicializar el arreglo dinámico

        // Elementos para seleccionar prenda, color y talla
        prendaCombo = new JComboBox<>(new String[]{"Chaqueta", "Buzo", "Pantalón"});
        colorCombo = new JComboBox<>(new String[]{"Rojo", "Azul", "Amarillo"});
        tallaCombo = new JComboBox<>(new String[]{"S", "M", "L"});

        crearPrendaBtn = new JButton("Crear Prenda");
        resultado = new JTextArea(10, 30);
        resultado.setEditable(false);

        // Añadir componentes a la ventana
        add(new JLabel("Selecciona la prenda:"));
        add(prendaCombo);
        add(new JLabel("Selecciona el color:"));
        add(colorCombo);
        add(new JLabel("Selecciona la talla:"));
        add(tallaCombo);
        add(crearPrendaBtn);
        add(new JScrollPane(resultado));

        // Acción al presionar el botón
        crearPrendaBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                crearPrenda();
            }
        });
    }

    private void crearPrenda() {
        // Obtener selecciones
        String prendaSeleccionada = (String) prendaCombo.getSelectedItem();
        String colorSeleccionado = (String) colorCombo.getSelectedItem();
        String tallaSeleccionada = (String) tallaCombo.getSelectedItem();

        // Crear el objeto de prenda usando el patrón Bridge
        Abstract_prenda prenda = null;

        // Selección de color
        Seleccion_color color = null;
        switch (colorSeleccionado) {
            case "Rojo":
                color = new Rojo();
                break;
            case "Azul":
                color = new Azul();
                break;
            case "Amarillo":
                color = new Amarillo();
                break;
        }

        // Selección de talla
        Seleccion_talla talla = null;
        switch (tallaSeleccionada) {
            case "S":
                talla = new S();
                break;
            case "M":
                talla = new M();
                break;
            case "L":
                talla = new L();
                break;
        }

        // Crear la prenda seleccionada
        switch (prendaSeleccionada) {
            case "Chaqueta":
                prenda = new Chaqueta(color, talla);
                break;
            case "Buzo":
                prenda = new Buzo(color, talla);
                break;
            case "Pantalón":
                prenda = new Pantalon(color, talla);
                break;
        }

        // Añadir la prenda creada al ArrayList
        prendasCreadas.add(prenda);

        // Mostrar todas las prendas creadas
        mostrarPrendas();
    }

    // Método para mostrar todas las prendas guardadas en el arreglo
    private void mostrarPrendas() {
        resultado.setText("");  // Limpiar el área de texto
        for (Abstract_prenda prenda : prendasCreadas) {
            resultado.append(describirPrenda(prenda) + "\n");
        }
    }

    // Método para describir la prenda (reemplaza la función de 'prenda()')
    private String describirPrenda(Abstract_prenda prenda) {
        String descripcion = "";

        if (prenda instanceof Chaqueta) {
            descripcion = "...Chaqueta de color ";
        } else if (prenda instanceof Buzo) {
            descripcion = "...Buzo de color ";
        } else if (prenda instanceof Pantalon) {
            descripcion = "...Pantalón de color ";
        }

        // Añadir color y talla a la descripción
        descripcion += prenda.prenda();
        return descripcion;
    }

    public static void main(String[] args) {
        PrendaGUI gui = new PrendaGUI();
        gui.setVisible(true);
    }
}
