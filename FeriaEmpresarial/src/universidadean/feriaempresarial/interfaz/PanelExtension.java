/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelExtension.java  $
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

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel de manejo de extensiones
 */
public class PanelExtension extends JPanel implements ActionListener {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Comando desocupar puesto
     */
    private static final String BUSCAR_PUESTO = "Buscar puesto";

    /**
     * Porcentaje de ocupación
     */
    private static final String PORCENTAJE_OCUPACION = "Porcentaje ocupación";

    /**
     * Comando Opción 1
     */
    private static final String OPCION_1 = "OPCION_1";

    /**
     * Comando Opción 2
     */
    private static final String OPCION_2 = "OPCION_2";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la aplicación
     */
    private InterfazFeriaEmpresarial principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Botón sugerir puesto
     */
    private JButton btnSugerirPuesto;

    /**
     * Botón ocupación
     */
    private JButton btnOcupacion;

    /**
     * Botón Opción 1
     */
    private JButton btnOpcion1;

    /**
     * Botón Opción 2
     */
    private JButton btnOpcion2;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor del panel
     * @param ventana Ventana principal
     */
    public PanelExtension(InterfazFeriaEmpresarial ventana) {
        principal = ventana;

        setBorder(new TitledBorder("Opciones"));
        setLayout(new GridLayout(1, 4));

        btnSugerirPuesto = new JButton("Sugerir puesto");
        btnSugerirPuesto.setActionCommand(BUSCAR_PUESTO);
        btnSugerirPuesto.addActionListener(this);
        add(btnSugerirPuesto);

        btnOcupacion = new JButton("Ocupación");
        btnOcupacion.setActionCommand(PORCENTAJE_OCUPACION);
        btnOcupacion.addActionListener(this);
        add(btnOcupacion);

        // Botón opción 1
        btnOpcion1 = new JButton("Opción 1");
        btnOpcion1.setActionCommand(OPCION_1);
        btnOpcion1.addActionListener(this);
        add(btnOpcion1);

        // Botón opción 2
        btnOpcion2 = new JButton("Opción 2");
        btnOpcion2.setActionCommand(OPCION_2);
        btnOpcion2.addActionListener(this);
        add(btnOpcion2);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(ActionEvent e) {
        if (OPCION_1.equals(e.getActionCommand())) {
            principal.reqFuncOpcion1();
        }
        else if (OPCION_2.equals(e.getActionCommand())) {
            principal.reqFuncOpcion2();
        }
        else if (BUSCAR_PUESTO.equals(e.getActionCommand())) {
            principal.sugerirPuesto();
        }
        else if (PORCENTAJE_OCUPACION.equals(e.getActionCommand())) {
            principal.darPorcentajeOcupacion();
        }
    }

}
