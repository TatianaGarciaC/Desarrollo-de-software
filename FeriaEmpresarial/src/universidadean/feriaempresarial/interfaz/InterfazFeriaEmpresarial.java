/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: InterfazFeriaEmpresarial.java  $
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

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Esta es la ventana principal de la aplicación.
 */
public class InterfazFeriaEmpresarial extends JFrame {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Clase principal del mundo
     */
    private FeriaEmpresarial feriaEmpresarial;

    // -----------------------------------------------------------------
    // Atributos de la interfaz
    // -----------------------------------------------------------------

    /**
     * Panel que representa los puestos de la feria
     */
    private PanelPuestos panelPuestos;

    /**
     * Panel que lista las empresas de la feria
     */
    private PanelEmpresas panelEmpresas;

    /**
     * Panel con las extensiones
     */
    private PanelExtension panelExtension;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la interfaz
     */
    public InterfazFeriaEmpresarial() {
        // Crea la clase principal
        feriaEmpresarial = new FeriaEmpresarial();

        // Construye la forma
        getContentPane().setLayout(new BorderLayout());
        setTitle("Feria Empresarial");
        setSize(800, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creación de los paneles aquí
        panelPuestos = new PanelPuestos(feriaEmpresarial.darPuestos());
        add(panelPuestos, BorderLayout.WEST);

        panelEmpresas = new PanelEmpresas(this, feriaEmpresarial);
        add(panelEmpresas, BorderLayout.CENTER);

        panelExtension = new PanelExtension(this);
        add(panelExtension, BorderLayout.SOUTH);

        // Centrar la ventana
        setLocationRelativeTo(null);
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Hace el manejo para el ingreso de una nueva empresa visitante
     */
    public void ingresarNuevaEmpresaVisitante() {
        DialogoEmpresaVisitante dialogo = new DialogoEmpresaVisitante(this, feriaEmpresarial);
        dialogo.setVisible(true);
        actualizar();
    }

    /**
     * Hace el manejo para el ingreso de una nueva empresa expositora
     */
    public void ingresarNuevaEmpresaExpositora() {
        DialogoEmpresaExpositora dialogo = new DialogoEmpresaExpositora(this, feriaEmpresarial);
        dialogo.setVisible(true);
        actualizar();
    }

    /**
     * Desocupa un puesto
     * @param nNombreEmpresa Nombre de la empresa que ocupa el puesto
     */
    public void desocuparPuesto(String nNombreEmpresa) {
        try {
            feriaEmpresarial.desocuparPuesto(nNombreEmpresa);
        }
        catch (Exception eFeria) {
            JOptionPane.showMessageDialog(this, eFeria.getMessage());
        }
        actualizar();
    }

    /**
     * Hace el manejo para sugerir un puesto
     */
    public void sugerirPuesto() {
        String sNumero = JOptionPane.showInputDialog(this, "Número de expositores", "Sugerir puesto", JOptionPane.QUESTION_MESSAGE);
        int numeroExpositores = 0;
        if (sNumero != null && sNumero != "") {
            try {
                numeroExpositores = Integer.parseInt(sNumero);
            }
            catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
            }
            try {
                Puesto sugerido = feriaEmpresarial.sugerirPuesto(numeroExpositores);
                if (sugerido == null) {
                    JOptionPane.showMessageDialog(this, "No hay puestos disponibles para " + numeroExpositores + " expositores");
                }
                else {
                    JOptionPane.showMessageDialog(this, "El puesto sugerido es: \n " + sugerido.darZona() + ", número: " + (sugerido.darNumero()));
                }
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }

    /**
     * Muestra el porcentaje de ocupación de la feria
     */
    public void darPorcentajeOcupacion() {
        double porcentaje = feriaEmpresarial.porcentajeOcupacion();
        JOptionPane.showMessageDialog(this, "Porcentaje de ocupación: " + formatearValorReal(porcentaje) + "%", "Ocupación", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Actualiza la visualización de la interfaz <br>
     * <b>post: </b> Se actualiza la visualización.
     */
    private void actualizar() {
        panelPuestos.repintar(feriaEmpresarial.darPuestos());
        panelEmpresas.actualizar(feriaEmpresarial.darEmpresas());

    }

    /**
     * Formatea un valor numérico real para presentar en la interfaz <br>
     * @param valor El valor numérico a ser formateado
     * @return Cadena con el valor formateado con puntos y signos.
     */
    private String formatearValorReal(double valor) {
        DecimalFormat df = (DecimalFormat) NumberFormat.getInstance();
        df.applyPattern(" ##.##");
        df.setMinimumFractionDigits(1);
        return df.format(valor);
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método para la extensión 1
     */
    public void reqFuncOpcion1() {
        String resultado = feriaEmpresarial.metodo1();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Método para la extensión 2
     */
    public void reqFuncOpcion2() {
        String resultado = feriaEmpresarial.metodo2();
        JOptionPane.showMessageDialog(this, resultado, "Respuesta", JOptionPane.INFORMATION_MESSAGE);
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args
     */
    public static void main(String[] args) {

        InterfazFeriaEmpresarial interfaz = new InterfazFeriaEmpresarial();
        interfaz.setVisible(true);
    }

}