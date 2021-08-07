/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelEmpresas.java  $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Bloque de Estudios: Desarrollo de Software
 * Ejercicio: Feria Empresarial
 * Adaptado de: Proyecto CUPI2 - UNIANDES
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Panel donde se listan las empresas de la feria
 */

/**
 * Panel donde se listan las empresas de la feria
 */
package universidadean.feriaempresarial.interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import universidadean.feriaempresarial.mundo.Empresa;
import universidadean.feriaempresarial.mundo.FeriaEmpresarial;

/**
 * Panel que muestra la información de las empresas
 */
public class PanelEmpresas extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante con los nombres de las columnas de la tabla de empresas visitantes
     */
    public static final String[] NOMBRE_COLUMNAS_EMPRESAS_VISITANTES = {"Nombre", "Asistentes"};

    /**
     * Constante con los nombres de las columnas de la tabla de empresas expositoras
     */
    public static final String[] NOMBRE_COLUMNAS_EMPRESAS_EXPOSITORAS = {"Nombre", "Expositores"};

    /**
     * Comando ingresar nueva empresa visitante
     */
    public static final String NUEVA_EMPRESA_VISITANTE = "Nueva empresa visitante";

    /**
     * Comando ingresar nueva empresa expositora
     */
    public static final String NUEVA_EMPRESA_EXPOSITORA = "Nueva empresa expositora";

    /**
     * Comando desocupar puesto
     */
    public static final String DESOCUPAR_PUESTO = "Desocupar puesto";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Ventana principal de la interfaz
     */
    private InterfazFeriaEmpresarial principal;

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Tabla que muestra la información de las empresas visitantes
     */
    private JTable tablaEmpresasVisitantes;

    /**
     * Tabla que muestra la información de las empresas expositoras
     */
    private JTable tablaEmpresasExpositoras;

    /**
     * Modelo para visualizar la información en la tabla de visitantes
     */
    private DefaultTableModel modelVisitantes;

    /**
     * Modelo para visualizar la información en la tabla de expositores
     */
    private DefaultTableModel modelExpositores;

    /**
     * Botón ingresar nueva empresa visitante
     */
    private JButton botonEmpresaVisitante;

    /**
     * Botón ingresar nueva empresa expositora
     */
    private JButton botonEmpresaExpositora;

    /**
     * Botón desocupar puesto
     */
    private JButton botonDesocuparPuesto;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con las empresas
     */
    public PanelEmpresas(InterfazFeriaEmpresarial nPrincipal, FeriaEmpresarial nFeriaEmpresarial) {
        principal = nPrincipal;

        setLayout(new GridLayout(2, 1));
        setBackground(Color.WHITE);

        // Empresas visitantes
        JPanel panelVisitantes = new JPanel();
        panelVisitantes.setBorder(new TitledBorder("Empresas Visitantes"));
        panelVisitantes.setLayout(new BorderLayout());
        modelVisitantes = new DefaultTableModel(NOMBRE_COLUMNAS_EMPRESAS_VISITANTES, 0);
        tablaEmpresasVisitantes = new JTable(modelVisitantes);
        tablaEmpresasVisitantes.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollSuperior = new JScrollPane();
        scrollSuperior.setViewportView(tablaEmpresasVisitantes);
        scrollSuperior.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollSuperior.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        botonEmpresaVisitante = new JButton("Ingresar empresa visitante");
        botonEmpresaVisitante.setActionCommand(NUEVA_EMPRESA_VISITANTE);
        botonEmpresaVisitante.addActionListener(this);
        panelVisitantes.add(botonEmpresaVisitante, BorderLayout.SOUTH);
        panelVisitantes.add(scrollSuperior, BorderLayout.CENTER);

        // Empresas expositoras
        JPanel panelExpositoras = new JPanel();
        panelExpositoras.setBorder(new TitledBorder("Empresas Expositoras"));
        panelExpositoras.setLayout(new BorderLayout());
        modelExpositores = new DefaultTableModel(NOMBRE_COLUMNAS_EMPRESAS_EXPOSITORAS, 0);
        tablaEmpresasExpositoras = new JTable(modelExpositores);
        tablaEmpresasExpositoras.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        JScrollPane scrollInferior = new JScrollPane();
        scrollInferior.setViewportView(tablaEmpresasExpositoras);
        scrollInferior.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollInferior.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        botonEmpresaExpositora = new JButton("Ingresar empresa expositora");
        botonEmpresaExpositora.setActionCommand(NUEVA_EMPRESA_EXPOSITORA);
        botonEmpresaExpositora.addActionListener(this);

        botonDesocuparPuesto = new JButton("Desocupar puesto");
        botonDesocuparPuesto.setActionCommand(DESOCUPAR_PUESTO);
        botonDesocuparPuesto.addActionListener(this);

        panelExpositoras.add(scrollInferior, BorderLayout.CENTER);
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(2, 1));

        panelBotones.add(botonEmpresaExpositora);
        panelBotones.add(botonDesocuparPuesto);

        panelExpositoras.add(panelBotones, BorderLayout.SOUTH);

        add(panelVisitantes, BorderLayout.NORTH);
        add(panelExpositoras, BorderLayout.CENTER);

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Actualiza la visualización de las empresas
     */
    public void actualizar(ArrayList<Empresa> empresas) {
        modelVisitantes = new DefaultTableModel(NOMBRE_COLUMNAS_EMPRESAS_VISITANTES, 0);
        tablaEmpresasVisitantes.setModel(modelVisitantes);
        String[] columna;
        for (int i = 0; i < empresas.size(); i++) {
            Empresa empresa = empresas.get(i);
            if (empresa.darTipo().equals(Empresa.VISITANTE)) {
                columna = new String[2];
                columna[0] = empresa.darNombre();
                columna[1] = Integer.toString(empresa.darNumeroPersonasAsistentes());

                modelVisitantes.addRow(columna);
            }
        }

        modelExpositores = new DefaultTableModel(NOMBRE_COLUMNAS_EMPRESAS_EXPOSITORAS, 0);
        tablaEmpresasExpositoras.setModel(modelExpositores);
        for (int i = 0; i < empresas.size(); i++) {
            Empresa empresa = empresas.get(i);
            if (empresa.darTipo().equals(Empresa.EXPOSITORA)) {
                columna = new String[2];
                columna[0] = empresa.darNombre();
                columna[1] = Integer.toString(empresa.darNumeroPersonasAsistentes());

                modelExpositores.addRow(columna);
            }
        }
    }

    /**
     * Manejo de los eventos de los botones
     * @param e Acción que generó el evento.
     */
    public void actionPerformed(ActionEvent e) {
        String evento = e.getActionCommand();
        if (evento.equals(NUEVA_EMPRESA_EXPOSITORA)) {
            principal.ingresarNuevaEmpresaExpositora();
        }
        else if (evento.equals(NUEVA_EMPRESA_VISITANTE)) {
            principal.ingresarNuevaEmpresaVisitante();
        }
        else if (evento.equals(DESOCUPAR_PUESTO)) {
            try {
                String nNombreEmpresa = (String) modelExpositores.getValueAt(tablaEmpresasExpositoras.getSelectedRow(), 0);
                principal.desocuparPuesto(nNombreEmpresa);
            }
            catch (ArrayIndexOutOfBoundsException e2) {
                JOptionPane.showMessageDialog(this, "Debe seleccionar una empresa expositora", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
