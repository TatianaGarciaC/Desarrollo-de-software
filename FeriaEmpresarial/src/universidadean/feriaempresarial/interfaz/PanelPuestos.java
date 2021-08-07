/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: PanelPuestos.java $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Bloque de Estudios: Desarrollo de Software
 * Ejercicio: Feria Empresarial
 * Adaptado de: Proyecto CUPI2 - UNIANDES
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * <p>
 * Panel que representa la feria con sus puestos
 */

/**
 * Panel que representa la feria con sus puestos
 */
package universidadean.feriaempresarial.interfaz;

import universidadean.feriaempresarial.mundo.FeriaEmpresarial;
import universidadean.feriaempresarial.mundo.Puesto;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

/**
 * Panel que representa un puesto
 */
public class PanelPuestos extends JPanel {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    // -----------------------------------------------------------------
    // Atributos de interfaz
    // -----------------------------------------------------------------

    /**
     * Panel puestos norte
     */
    private JPanel panelNorte;

    /**
     * Panel puestos oriente
     */
    private JPanel panelOriente;

    /**
     * Panel puestos sur
     */
    private JPanel panelSur;

    /**
     * Panel puestos occidente
     */
    private JPanel panelOccidente;

    /**
     * Panel puestos centro
     */
    private JPanel panelCentro;

    /**
     * Etiquetas norte
     */
    private JLabel[] etiquetasNorte;

    /**
     * Etiquetas oriente
     */
    private JLabel[] etiquetasOriente;

    /**
     * Etiquetas sur
     */
    private JLabel[] etiquetasSur;

    /**
     * Etiquetas occidente
     */
    private JLabel[] etiquetasOccidente;

    /**
     * Etiquetas centro
     */
    private JLabel[] etiquetasCentro;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel con los puestos
     * @param puestos Son los puestos de la feria empresarial
     */
    public PanelPuestos(Puesto[] puestos) {
        int numPuestoZona = 0;
        setPreferredSize(new Dimension(500, 300));
        GridBagLayout gbPrincipal = new GridBagLayout();
        setLayout(gbPrincipal);
        GridBagConstraints gbcPrincipal = new GridBagConstraints();
        setBorder(new TitledBorder(""));

        panelNorte = new JPanel();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.gridwidth = 1;
        panelNorte.setLayout(new GridBagLayout());
        numPuestoZona = FeriaEmpresarial.NUM_PUESTOS_NORTE;
        panelNorte.setBackground(Color.WHITE);
        panelNorte.setPreferredSize(new Dimension(50 * numPuestoZona, 30));
        etiquetasNorte = new JLabel[numPuestoZona];
        for (int i = 0; i < numPuestoZona; i++) {
            etiquetasNorte[i] = new JLabel(i + 1 + "");
            etiquetasNorte[i].setBackground(Color.GREEN);
            etiquetasNorte[i].setPreferredSize(new Dimension(50, 30));
            etiquetasNorte[i].setBorder(new LineBorder(Color.BLACK));
            etiquetasNorte[i].setOpaque(true);
            etiquetasNorte[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.gridx = i;
            panelNorte.add(etiquetasNorte[i], gbc);
        }

        panelOriente = new JPanel();
        panelOriente.setLayout(new GridBagLayout());
        numPuestoZona = FeriaEmpresarial.NUM_PUESTOS_ORIENTE;
        panelOriente.setBackground(Color.WHITE);
        panelOriente.setPreferredSize(new Dimension(30, 60 * numPuestoZona));
        etiquetasOriente = new JLabel[numPuestoZona];
        gbc.gridx = 0;
        for (int i = 0; i < numPuestoZona; i++) {
            etiquetasOriente[i] = new JLabel(i + 1 + "");
            etiquetasOriente[i].setBackground(Color.GREEN);
            etiquetasOriente[i].setPreferredSize(new Dimension(30, 60));
            etiquetasOriente[i].setBorder(new LineBorder(Color.BLACK));
            etiquetasOriente[i].setOpaque(true);
            etiquetasOriente[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.gridy = i;
            panelOriente.add(etiquetasOriente[i], gbc);
        }

        panelSur = new JPanel();
        panelSur.setLayout(new GridBagLayout());
        numPuestoZona = FeriaEmpresarial.NUM_PUESTOS_SUR;
        panelSur.setBackground(Color.WHITE);
        panelSur.setPreferredSize(new Dimension(50 * numPuestoZona, 30));
        etiquetasSur = new JLabel[numPuestoZona];
        gbc.gridy = 0;
        for (int i = 0; i < numPuestoZona; i++) {
            etiquetasSur[i] = new JLabel(i + 1 + "");
            etiquetasSur[i].setBackground(Color.GREEN);
            etiquetasSur[i].setPreferredSize(new Dimension(50, 30));
            etiquetasSur[i].setBorder(new LineBorder(Color.BLACK));
            etiquetasSur[i].setOpaque(true);
            etiquetasSur[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.gridx = i;
            panelSur.add(etiquetasSur[i], gbc);
        }

        panelOccidente = new JPanel();
        panelOccidente.setLayout(new GridBagLayout());
        numPuestoZona = FeriaEmpresarial.NUM_PUESTOS_OCCIDENTE;
        panelOccidente.setBackground(Color.WHITE);
        panelOccidente.setPreferredSize(new Dimension(30, 60 * numPuestoZona));
        etiquetasOccidente = new JLabel[numPuestoZona];
        gbc.gridx = 0;
        for (int i = 0; i < numPuestoZona; i++) {
            etiquetasOccidente[i] = new JLabel(i + 1 + "");
            etiquetasOccidente[i].setBackground(Color.GREEN);
            etiquetasOccidente[i].setPreferredSize(new Dimension(30, 60));
            etiquetasOccidente[i].setBorder(new LineBorder(Color.BLACK));
            etiquetasOccidente[i].setOpaque(true);
            etiquetasOccidente[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            gbc.gridy = i;
            panelOccidente.add(etiquetasOccidente[i], gbc);
        }

        panelCentro = new JPanel();
        panelCentro.setLayout(new GridBagLayout());
        numPuestoZona = FeriaEmpresarial.NUM_PUESTOS_CENTRO;
        panelCentro.setBackground(Color.WHITE);
        panelCentro.setPreferredSize(new Dimension(50 * numPuestoZona / 2, 30 * 2));
        etiquetasCentro = new JLabel[numPuestoZona];
        gbc.gridy = 0;
        for (int i = 0; i < numPuestoZona; i++) {
            if (i >= numPuestoZona / 2) {
                gbc.gridy = 1;
                gbc.gridx = i - numPuestoZona / 2;
            }
            else {
                gbc.gridx = i;
            }

            etiquetasCentro[i] = new JLabel(i + 1 + "");
            etiquetasCentro[i].setBackground(Color.GREEN);
            etiquetasCentro[i].setOpaque(true);
            etiquetasCentro[i].setPreferredSize(new Dimension(50, 30));
            etiquetasCentro[i].setBorder(new LineBorder(Color.BLACK));
            etiquetasCentro[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            panelCentro.add(etiquetasCentro[i], gbc);
        }

        gbcPrincipal.gridheight = 4;
        gbcPrincipal.gridwidth = 1;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.gridx = 0;
        gbcPrincipal.insets = new Insets(0, 0, 0, 30);
        gbPrincipal.setConstraints(panelOccidente, gbcPrincipal);
        add(panelOccidente);

        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridx = 1;
        gbcPrincipal.insets = new Insets(0, 0, 30, 0);
        gbPrincipal.setConstraints(panelNorte, gbcPrincipal);
        add(panelNorte);

        gbcPrincipal.gridheight = 2;
        gbcPrincipal.gridy = 1;
        gbcPrincipal.gridx = 1;
        gbcPrincipal.insets = new Insets(0, 0, 0, 0);
        gbPrincipal.setConstraints(panelCentro, gbcPrincipal);
        add(panelCentro);

        gbcPrincipal.gridheight = 1;
        gbcPrincipal.gridy = 3;
        gbcPrincipal.insets = new Insets(30, 0, 0, 0);
        gbPrincipal.setConstraints(panelSur, gbcPrincipal);
        add(panelSur);

        gbcPrincipal.gridheight = 4;
        gbcPrincipal.gridy = 0;
        gbcPrincipal.gridx = 2;
        gbcPrincipal.insets = new Insets(0, 30, 0, 0);
        gbPrincipal.setConstraints(panelOriente, gbcPrincipal);
        add(panelOriente);

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Repinta los puestos de la feria
     */
    public void repintar(Puesto[] puestos) {
        int inicio = 0;
        for (int i = 0; i < FeriaEmpresarial.NUM_PUESTOS_NORTE; i++) {
            etiquetasNorte[i].setBackground(darColorPuesto(puestos[i + inicio]));
        }

        inicio = FeriaEmpresarial.NUM_PUESTOS_NORTE;
        for (int i = 0; i < FeriaEmpresarial.NUM_PUESTOS_ORIENTE; i++) {
            etiquetasOriente[i].setBackground(darColorPuesto(puestos[i + inicio]));
        }

        inicio += FeriaEmpresarial.NUM_PUESTOS_ORIENTE;
        for (int i = 0; i < FeriaEmpresarial.NUM_PUESTOS_SUR; i++) {
            etiquetasSur[i].setBackground(darColorPuesto(puestos[i + inicio]));
        }

        inicio += FeriaEmpresarial.NUM_PUESTOS_SUR;
        for (int i = 0; i < FeriaEmpresarial.NUM_PUESTOS_OCCIDENTE; i++) {
            etiquetasOccidente[i].setBackground(darColorPuesto(puestos[i + inicio]));
        }

        inicio += FeriaEmpresarial.NUM_PUESTOS_OCCIDENTE;
        for (int i = 0; i < FeriaEmpresarial.NUM_PUESTOS_CENTRO; i++) {
            etiquetasCentro[i].setBackground(darColorPuesto(puestos[i + inicio]));
        }

    }

    /**
     * Retorna el color del puesto según su estado
     * @param p Puesto que se va a pintar
     * @return Color verde si el puesto esta libre o rojo de lo contrario
     */
    private Color darColorPuesto(Puesto p) {
        Color color = Color.GREEN;
        if (p.estaOcupado()) {
            color = Color.RED;
        }
        return color;

    }

    /**
     * Este método se encarga de pintar el panel y sus componentes, haciendo que haya una imagen en el fondo
     * @param g Es la superficie del panel
     */
    public void paintComponent(Graphics g) {
        ImageIcon icon = new ImageIcon("./data/imagenes/plano.jpg");
        g.drawImage(icon.getImage(), 0, 0, null);
        setOpaque(false);
        super.paintComponent(g);
    }

}
