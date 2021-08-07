/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoEmpresaExpositora.java $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Bloque de Estudios: Desarrollo de Software
 * Ejercicio: Feria Empresarial
 * Adaptado de: Proyecto CUPI2 - UNIANDES
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package universidadean.feriaempresarial.interfaz;

import universidadean.feriaempresarial.mundo.FeriaEmpresarial;
import universidadean.feriaempresarial.mundo.Puesto;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialogo donde se muestran las opciones para ingresar una nueva empresa expositora
 */
public class DialogoEmpresaExpositora extends JDialog implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando aceptar
     */
    private static final String ACEPTAR = "Aceptar";

    /**
     * Comando cancelar
     */
    private static final String CANCELAR = "Cancelar";

    /**
     * Comando cambio de ubicación
     */
    private static final String CAMBIO_UBICACION = "Cambio ubicación";

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre de la empresa
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta número de expositores
     */
    private JLabel etiquetaNumeroExpositores;

    /**
     * Etiqueta ubicación del puesto
     */
    private JLabel etiquetaUbicacionPuesto;

    /**
     * Campo de texto nombre de la empresa
     */
    private JTextField txtNombre;

    /**
     * Campo de texto número de expositores
     */
    private JTextField txtNumeroExpositores;

    /**
     * Botón aceptar
     */
    private JButton btnAceptar;

    /**
     * Botón cancelar
     */
    private JButton btnCancelar;

    /**
     * Zona de ubicación
     */
    private JComboBox cboUbicacion;

    /**
     * Número de puesto
     */
    private JComboBox cboNumeroPuesto;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    private FeriaEmpresarial feriaEmpresarial;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del dialogo
     * @param nPrincipal Es la ventana principal de la aplicación
     * @param nFeriaEmpresarial Es la feria empresarial de la aplicación
     */
    public DialogoEmpresaExpositora(InterfazFeriaEmpresarial nPrincipal, FeriaEmpresarial nFeriaEmpresarial) {
        super(nPrincipal, true);
        feriaEmpresarial = nFeriaEmpresarial;
        setTitle("Nueva empresa expositora");
        setResizable(false);
        setLayout(new BorderLayout());

        etiquetaNombre = new JLabel("Nombre");
        etiquetaNombre.setPreferredSize(new Dimension(120, 20));
        etiquetaNumeroExpositores = new JLabel("Número expositores");
        etiquetaNumeroExpositores.setPreferredSize(new Dimension(120, 20));
        etiquetaUbicacionPuesto = new JLabel("Ubicación");
        etiquetaUbicacionPuesto.setPreferredSize(new Dimension(120, 30));

        txtNombre = new JTextField();
        txtNombre.setPreferredSize(new Dimension(200, 27));
        txtNumeroExpositores = new JTextField();
        txtNumeroExpositores.setPreferredSize(new Dimension(200, 27));

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(ACEPTAR);
        btnAceptar.addActionListener(this);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);

        cboNumeroPuesto = new JComboBox();
        cboNumeroPuesto.setPreferredSize(new Dimension(60, 27));

        cboUbicacion = new JComboBox();
        cboUbicacion.setPreferredSize(new Dimension(112, 27));
        cboUbicacion.setActionCommand(CAMBIO_UBICACION);
        cboUbicacion.addActionListener(this);
        cboUbicacion.addItem(Puesto.ZONA_CENTRO);
        cboUbicacion.addItem(Puesto.ZONA_NORTE);
        cboUbicacion.addItem(Puesto.ZONA_SUR);
        cboUbicacion.addItem(Puesto.ZONA_OCCIDENTE);
        cboUbicacion.addItem(Puesto.ZONA_ORIENTE);

        JPanel informacion = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        informacion.setLayout(new GridBagLayout());
        informacion.setPreferredSize(new Dimension(350, 150));

        gbc.gridx = 0;
        gbc.gridy = 0;
        informacion.add(etiquetaNombre, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        informacion.add(txtNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        informacion.add(etiquetaNumeroExpositores, gbc);

        gbc.gridx = 1;
        gbc.gridwidth = 2;
        informacion.add(txtNumeroExpositores, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        informacion.add(etiquetaUbicacionPuesto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        informacion.add(cboUbicacion, gbc);

        gbc.gridx = 2;
        informacion.add(cboNumeroPuesto, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        informacion.add(btnAceptar, gbc);

        gbc.gridx = 2;
        informacion.add(btnCancelar, gbc);

        add(informacion, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Recarga los puestos de la feria
     */
    private void recargarPuestos() {
        Puesto[] puestos = feriaEmpresarial.darPuestos();
        cboNumeroPuesto.removeAllItems();

        String ubicacion = (String) cboUbicacion.getSelectedItem();
        int inicio = 0;
        int cantidad = 0;
        if (ubicacion.equals(Puesto.ZONA_NORTE)) {
            inicio = 0;
            cantidad = FeriaEmpresarial.NUM_PUESTOS_NORTE;
        }
        else if (ubicacion.equals(Puesto.ZONA_ORIENTE)) {
            inicio = FeriaEmpresarial.NUM_PUESTOS_NORTE;
            cantidad = FeriaEmpresarial.NUM_PUESTOS_ORIENTE;
        }
        else if (ubicacion.equals(Puesto.ZONA_SUR)) {
            inicio = FeriaEmpresarial.NUM_PUESTOS_NORTE + FeriaEmpresarial.NUM_PUESTOS_ORIENTE;
            cantidad = FeriaEmpresarial.NUM_PUESTOS_SUR;
        }
        else if (ubicacion.equals(Puesto.ZONA_OCCIDENTE)) {
            inicio = FeriaEmpresarial.NUM_PUESTOS_NORTE + FeriaEmpresarial.NUM_PUESTOS_ORIENTE + FeriaEmpresarial.NUM_PUESTOS_SUR;
            cantidad = FeriaEmpresarial.NUM_PUESTOS_OCCIDENTE;
        }
        else {
            inicio = FeriaEmpresarial.NUM_PUESTOS_NORTE + FeriaEmpresarial.NUM_PUESTOS_ORIENTE + FeriaEmpresarial.NUM_PUESTOS_SUR + FeriaEmpresarial.NUM_PUESTOS_OCCIDENTE;
            cantidad = FeriaEmpresarial.NUM_PUESTOS_CENTRO;
        }
        for (int i = inicio; i < inicio + cantidad; i++) {
            if (!puestos[i].estaOcupado()) {
                cboNumeroPuesto.addItem(Integer.toString(puestos[i].darNumero()));

            }
        }
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(ACEPTAR)) {
            String nombre = txtNombre.getText();
            int numPersonas = 0;
            int numeroPuesto = 0;
            if (nombre != null && !nombre.equals("")) {
                try {
                    numPersonas = Integer.parseInt(txtNumeroExpositores.getText());
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    numeroPuesto = Integer.parseInt((String) cboNumeroPuesto.getSelectedItem());
                }
                catch (Exception eNumero) {
                    JOptionPane.showMessageDialog(this, "Debe seleccionar un puesto válido", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    String zonaPuesto = (String) cboUbicacion.getSelectedItem();
                    feriaEmpresarial.ingresarEmpresaExpositora(nombre, numPersonas, zonaPuesto, numeroPuesto);
                    dispose();
                }
                catch (Exception eFeria) {
                    JOptionPane.showMessageDialog(this, eFeria.getMessage());
                }
            }
            else {
                JOptionPane.showMessageDialog(this, "Debe ingresar el nombre de la empresa", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }
        else if (comando.equals(CANCELAR)) {
            dispose();
        }
        else if (comando.equals(CAMBIO_UBICACION)) {
            recargarPuestos();
        }
    }

}
