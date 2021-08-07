/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: DialogoEmpresaVisitante.java  $
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Dialogo donde se muestran las opciones para ingresar una nueva empresa visitante
 */
public class DialogoEmpresaVisitante extends JDialog implements ActionListener {
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

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Etiqueta nombre de la empresa
     */
    private JLabel etiquetaNombre;

    /**
     * Etiqueta número de visitantes
     */
    private JLabel etiquetaNumeroVisitantes;

    /**
     * Campo de texto nombre de la empresa
     */
    private JTextField txtNombre;

    /**
     * Campo de texto número de visitantes
     */
    private JTextField txtNumeroVisitantes;

    /**
     * Botón aceptar
     */
    private JButton btnAceptar;

    /**
     * Botón cancelar
     */
    private JButton btnCancelar;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Feria Empresarial
     */
    private FeriaEmpresarial feriaEmpresarial;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param nPrincipal Es la ventana principal de la aplicación
     * @param nFeriaEmpresarial Es la feria empresarial de la aplicación
     */
    public DialogoEmpresaVisitante(InterfazFeriaEmpresarial nPrincipal, FeriaEmpresarial nFeriaEmpresarial) {
        super(nPrincipal, true);
        feriaEmpresarial = nFeriaEmpresarial;
        setTitle("Nueva empresa visitante");
        setResizable(false);
        setLayout(new BorderLayout());

        etiquetaNombre = new JLabel("Nombre");
        etiquetaNumeroVisitantes = new JLabel("Número visitantes");

        txtNombre = new JTextField();
        txtNumeroVisitantes = new JTextField();

        btnAceptar = new JButton("Aceptar");
        btnAceptar.setActionCommand(ACEPTAR);
        btnAceptar.addActionListener(this);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setActionCommand(CANCELAR);
        btnCancelar.addActionListener(this);

        JPanel informacion = new JPanel();
        informacion.setLayout(new GridLayout(3, 2));
        informacion.setPreferredSize(new Dimension(220, 90));

        informacion.add(etiquetaNombre);
        informacion.add(txtNombre);
        informacion.add(etiquetaNumeroVisitantes);
        informacion.add(txtNumeroVisitantes);
        informacion.add(btnAceptar);
        informacion.add(btnCancelar);

        add(informacion, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento
     */
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals(ACEPTAR)) {
            String nombre = txtNombre.getText();
            int numPersonas = 0;
            if (nombre != null && !nombre.equals("")) {
                try {
                    numPersonas = Integer.parseInt(txtNumeroVisitantes.getText());
                }
                catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(this, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                try {
                    feriaEmpresarial.ingresarEmpresaVisitante(nombre, numPersonas);
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
    }
}
