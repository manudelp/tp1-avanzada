package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {
    // Declaramos las variables correctamente dentro de la clase
    private JPanel panelBotones;
    private JButton btnAlta, btnBaja, btnModificacion;
    private JTable tablaDatos;
    private DefaultTableModel modeloTabla;
    private JScrollPane scrollPane;

    public VentanaPrincipal() {
        // Configuración de la ventana
        setTitle("Gestión Universitaria");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Inicialización de componentes
        initComponentes();
    }

    private void initComponentes() {
        // Creamos el panel antes de agregarlo
        panelBotones = new JPanel(new FlowLayout());

        // Inicializamos los botones
        btnAlta = new JButton("Alta");
        btnBaja = new JButton("Baja");
        btnModificacion = new JButton("Modificación");
        panelBotones.add(btnAlta); // Agregamos los botones al panel
        panelBotones.add(btnBaja);
        panelBotones.add(btnModificacion);
        add(panelBotones, BorderLayout.NORTH); // Agregamos el panel a la ventana

        // Tabla
        String[] columnas = {"ID", "Nombre", "Tipo", "Detalles"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaDatos = new JTable(modeloTabla);

        scrollPane = new JScrollPane(tablaDatos);
        add(scrollPane, BorderLayout.CENTER);

        // Accion del boton "Alta"
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirFormularioAlta();
            }
        });

        // Acción del botón "Baja"
        btnBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarFilaSeleccionada();
            }
        });

        btnModificacion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarFilaSeleccionada();
            }
        });
    }

    // AGREGAR ENTIDADES
    private void abrirFormularioAlta() {
        JDialog dialogo = new JDialog(this, "Agregar Entidad", true);
        dialogo.setSize(300, 250);
        dialogo.setLocationRelativeTo(this);
        dialogo.setLayout(new GridLayout(5, 2));

        // Componentes del formulario
        JLabel lblID = new JLabel("ID:");
        JTextField txtID = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        JTextField txtNombre = new JTextField();
        JLabel lblTipo = new JLabel("Tipo:");
        JTextField txtTipo = new JTextField();
        JLabel lblDetalles = new JLabel("Detalles:");
        JTextField txtDetalles = new JTextField();

        JButton btnGuardar = new JButton("Guardar");
        JButton btnCancelar = new JButton("Cancelar");

        // Agregar componentes al diálogo
        dialogo.add(lblID);
        dialogo.add(txtID);
        dialogo.add(lblNombre);
        dialogo.add(txtNombre);
        dialogo.add(lblTipo);
        dialogo.add(txtTipo);
        dialogo.add(lblDetalles);
        dialogo.add(txtDetalles);
        dialogo.add(btnGuardar);
        dialogo.add(btnCancelar);

        // Accion del boton guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = txtID.getText();
                String nombre = txtNombre.getText();
                String tipo = txtTipo.getText();
                String detalles = txtDetalles.getText();

                if (!id.isEmpty() && !nombre.isEmpty() && !tipo.isEmpty() && !detalles.isEmpty()) {
                    modeloTabla.addRow(new Object[]{id, nombre, tipo, detalles});
                    dialogo.dispose();
                } else {
                    JOptionPane.showMessageDialog(dialogo, "Todos los campos son obligatorios", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Accion del boton cancelar
        btnCancelar.addActionListener(e -> dialogo.dispose());

        // Mostrar el dialogo
        dialogo.setVisible(true);
    }

    // ELIMINAR FILAS
    private void eliminarFilaSeleccionada() {
        int filaSeleccionada = tablaDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Confirmacion antes de eliminar
            int confirmacion = JOptionPane.showConfirmDialog(
                    this,
                    "¿Estás seguro de que quieres eliminar esta fila?",
                    "Confirmar eliminación",
                    JOptionPane.YES_NO_OPTION
            );

            if (confirmacion == JOptionPane.YES_OPTION) {
                modeloTabla.removeRow(filaSeleccionada);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila para eliminar", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // MODIFICAR FILA SELECCIONADA
    private void modificarFilaSeleccionada() {
        int filaSeleccionada = tablaDatos.getSelectedRow();

        if (filaSeleccionada != -1) {
            // Obtener la informacion de la fila
            String id = tablaDatos.getValueAt(filaSeleccionada, 0).toString();
            String nombre = tablaDatos.getValueAt(filaSeleccionada, 1).toString();
            String tipo = tablaDatos.getValueAt(filaSeleccionada, 2).toString();
            String detalles = tablaDatos.getValueAt(filaSeleccionada, 3).toString();

            // Crear un dialogo de edicion
            JDialog dialogo = new JDialog(this, "Modificar Entidad", true);
            dialogo.setSize(300, 250);
            dialogo.setLayout(new GridLayout(5, 2));

            // Campos de entrada
            JTextField lblID = new JTextField(id);
            JTextField lblNombre = new JTextField(nombre);
            JTextField lblTipo = new JTextField(tipo);
            JTextField lblDetalles = new JTextField(detalles);

            // Boton de confirmacion
            JButton btnGuardar = new JButton("Guardar");

            btnGuardar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Actualizar los datos de la tabla
                    modeloTabla.setValueAt(lblID.getText(), filaSeleccionada, 0);
                    modeloTabla.setValueAt(lblNombre.getText(), filaSeleccionada, 1);
                    modeloTabla.setValueAt(lblTipo.getText(), filaSeleccionada, 2);
                    modeloTabla.setValueAt(lblDetalles.getText(), filaSeleccionada, 3);
                    dialogo.dispose();
                }
            });

            // Agregar componentes al diálogo
            dialogo.add(new JLabel("ID:"));
            dialogo.add(lblID);
            dialogo.add(new JLabel("Nombre:"));
            dialogo.add(lblNombre);
            dialogo.add(new JLabel("Tipo:"));
            dialogo.add(lblTipo);
            dialogo.add(new JLabel("Detalles:"));
            dialogo.add(lblDetalles);
            dialogo.add(btnGuardar);

            dialogo.setLocationRelativeTo(this);
            dialogo.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Debes seleccionar una fila para modificar la información", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });
    }
}
