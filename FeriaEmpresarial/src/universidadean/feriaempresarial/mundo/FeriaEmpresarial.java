/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id: FeriaEmpresarial.java 718 2008-10-03 21:07:55Z jua-gome $
 * Universidad Ean (Bogotá - Colombia)
 * Programa de Ingeniería de Sistemas
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Bloque de Estudios: Desarrollo de Software
 * Ejercicio: Feria Empresarial
 * Adaptado de: Proyecto CUPI2 - UNIANDES
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package universidadean.feriaempresarial.mundo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase que modela una feria empresarial
 */
public class FeriaEmpresarial {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Número mínimo de personas de la zona norte
     */
    public static final int MIN_PERSONAS_NORTE = 4;

    /**
     * Número máximo de personas de la zona norte
     */
    public static final int MAX_PERSONAS_NORTE = 8;

    /**
     * Número mínimo de personas de la zona sur
     */
    public static final int MIN_PERSONAS_SUR = 3;

    /**
     * Número máximo de personas de la zona sur
     */
    public static final int MAX_PERSONAS_SUR = 7;

    /**
     * Número mínimo de personas de la zona oriente
     */
    public static final int MIN_PERSONAS_ORIENTE = 7;

    /**
     * Número máximo de personas de la zona oriente
     */
    public static final int MAX_PERSONAS_ORIENTE = 13;

    /**
     * Número mínimo de personas de la zona oriente
     */
    public static final int MIN_PERSONAS_OCCIDENTE = 8;

    /**
     * Número máximo de personas de la zona oriente
     */
    public static final int MAX_PERSONAS_OCCIDENTE = 14;

    /**
     * Número mínimo de personas de la zona centro
     */
    public static final int MIN_PERSONAS_CENTRO = 6;

    /**
     * Número máximo de personas de la zona centro
     */
    public static final int MAX_PERSONAS_CENTRO = 12;

    /**
     * Número de puestos en la zona norte
     */
    public static final int NUM_PUESTOS_NORTE = 4;

    /**
     * Número de puestos en la zona sur
     */
    public static final int NUM_PUESTOS_SUR = 4;

    /**
     * Número de puestos en la zona oriente
     */
    public static final int NUM_PUESTOS_ORIENTE = 3;

    /**
     * Número de puestos en la zona occidente
     */
    public static final int NUM_PUESTOS_OCCIDENTE = 3;

    /**
     * Número de puestos en la zona centro
     */
    public static final int NUM_PUESTOS_CENTRO = 8;

    /**
     * Número máximo de personas asistentes para una empresa visitante
     */
    public static final int MAX_PERSONAS_ASISTENTES = 20;

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Colección de empresas de la feria
     */
    private ArrayList<Empresa> empresas;

    /**
     * Puestos de la feria
     */
    private Puesto[] puestos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Constructor de la feria empresarial<br>
     * <b>post </b> La lista de empresas fue inicializada vacía.<br>
     * El arreglo de puestos de la feria fue inicializado según el total de puestos<br>
     */
    public FeriaEmpresarial() {
        empresas = new ArrayList<>();
        puestos = new Puesto[NUM_PUESTOS_NORTE + NUM_PUESTOS_SUR + NUM_PUESTOS_ORIENTE + NUM_PUESTOS_OCCIDENTE + NUM_PUESTOS_CENTRO];
        crearPuestos();
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna las empresas de la feria<br>
     * <b>post: </b>Se han retornado las empresas de la feria. empresas != null<br>
     * @return Vector con las empresas de la feria
     */
    public ArrayList<Empresa> darEmpresas() {
        return empresas;
    }

    /**
     * Retorna los puestos de la feria<br>
     * <b>post: </b>Se retornaron los puestos de la feria<br>
     * @return Arreglo de puestos de la feria
     */
    public Puesto[] darPuestos() {
        return puestos;
    }

    /**
     * Ingresa una empresa visitante a la feria<br>
     * <b>pre: </b>La lista de empresas y los puestos han sido inicializados<br>
     * <b>post: </b>Se agregó una empresa asistente a la feria con los valores dados por parámetro<br>
     * El tipo de la empresa se ha inicializado como visitante<br>
     * @param nNombreEmpresa Es el nombre de la empresa. nNombreEmpresa != null,nNombreEmpresa != ""
     * @param nNumeroPersonasAsistentes Es el número de personas de la empresa asistentes a la feria. nNumeroPersonasAsistentes > 0
     * @throws Exception <br>
     *         1. Si ya existe una empresa con el nombre ingresado<br>
     *         2. Si el numero de personas asistentes excede el numero máximo de personas asistentes
     */
    public void ingresarEmpresaVisitante(String nNombreEmpresa, int nNumeroPersonasAsistentes) throws Exception {
        boolean encontrado = false;

        for (int i = 0; i < empresas.size(); i++) {
            Empresa empresa = empresas.get(i);
            if (empresa.darNombre().equals(nNombreEmpresa)) {
                encontrado = true;
            }
        }

        if (encontrado) {
            throw new Exception("La empresa ya existe");
        }

        if (nNumeroPersonasAsistentes > MAX_PERSONAS_ASISTENTES) {
            throw new Exception("Número de personas no permitido");
        }

        empresas.add(new Empresa(nNombreEmpresa, Empresa.VISITANTE, nNumeroPersonasAsistentes));
    }

    /**
     * Ingresa una empresa expositora a la feria y ocupa el puesto de la empresa<br>
     * <b>pre: </b>La lista de empresas y los puestos han sido inicializados<br>
     * <b>post: </b>Se ha adicionado una empresa expositora a la contenedora de empresas con los valores dados por parámetro<br>
     * El tipo de la empresa se ha inicializado como expositora<br>
     * Se ha ocupado el puesto indicado por parámetro<br>
     * @param nNombreEmpresa Es el nombre de la empresa. nNombreEmpresa != null,nNombreEmpresa != ""
     * @param nNumeroPersonasExpositoras Es el número de personas de la empresa expositora . nNumeroPersonasExpositoras > 0
     * @param zonaPuesto Es la zona donde se ubicará la empresa. zonaPuesto != null, zonaPuesto != ""
     * @param numeroPuesto Es el número del puesto sobre la zona. numeroPuesto > 0
     * @throws Exception <br>
     *         1. Si ya existe una empresa con el nombre ingresado <br>
     *         3. No existe el puesto escogido <br>
     *         4. Si el puesto escogido ya esta ocupado <br>
     *         5. Si el numero de personas expositoras no esta dentro del rango de personas permitidas en el puesto
     */
    public void ingresarEmpresaExpositora(String nNombreEmpresa, int nNumeroPersonasExpositoras, String zonaPuesto, int numeroPuesto) throws Exception {
        boolean encontrado = false;

        for (int i = 0; i < empresas.size(); i++) {
            Empresa empresa = empresas.get(i);
            if (empresa.darNombre().equals(nNombreEmpresa)) {
                encontrado = true;
            }
        }

        if (encontrado) {
            throw new Exception("La empresa ya existe");
        }

        if (zonaPuesto.equals(Puesto.ZONA_NORTE)) {
            if (nNumeroPersonasExpositoras < MIN_PERSONAS_NORTE || nNumeroPersonasExpositoras > MAX_PERSONAS_NORTE) {
                throw new Exception("Número de personas no permitidas para la zona");
            }

            if (numeroPuesto > NUM_PUESTOS_NORTE) {
                throw new Exception("El puesto no existe");
            }

            int posicion = numeroPuesto - 1;
            if (puestos[posicion].estaOcupado()) {
                throw new Exception("El puesto ya está ocupado");
            }

            puestos[posicion].ocuparPuesto(nNombreEmpresa);
        }
        else if (zonaPuesto.equals(Puesto.ZONA_ORIENTE)) {
            if (nNumeroPersonasExpositoras < MIN_PERSONAS_ORIENTE || nNumeroPersonasExpositoras > MAX_PERSONAS_ORIENTE) {
                throw new Exception("Número de personas no permitidas para la zona");
            }

            if (numeroPuesto > NUM_PUESTOS_ORIENTE) {
                throw new Exception("El puesto no existe");
            }

            int posicion = numeroPuesto - 1 + NUM_PUESTOS_NORTE;
            if (puestos[posicion].estaOcupado()) {
                throw new Exception("El puesto ya esta ocupado");
            }

            puestos[posicion].ocuparPuesto(nNombreEmpresa);
        }
        else if (zonaPuesto.equals(Puesto.ZONA_SUR)) {
            if (nNumeroPersonasExpositoras < MIN_PERSONAS_SUR || nNumeroPersonasExpositoras > MAX_PERSONAS_SUR) {
                throw new Exception("Número de personas no permitidas para la zona");
            }

            if (numeroPuesto > NUM_PUESTOS_SUR) {
                throw new Exception("El puesto no existe");
            }

            int posicion = numeroPuesto - 1 + NUM_PUESTOS_NORTE + NUM_PUESTOS_ORIENTE;
            if (puestos[posicion].estaOcupado()) {
                throw new Exception("El puesto ya esta ocupado");
            }

            puestos[posicion].ocuparPuesto(nNombreEmpresa);
        }
        else if (zonaPuesto.equals(Puesto.ZONA_OCCIDENTE)) {
            if (nNumeroPersonasExpositoras < MIN_PERSONAS_OCCIDENTE || nNumeroPersonasExpositoras > MAX_PERSONAS_OCCIDENTE) {
                throw new Exception("Número de personas no permitidas para la zona");
            }

            if (numeroPuesto > NUM_PUESTOS_OCCIDENTE) {
                throw new Exception("El puesto no existe");
            }

            int posicion = numeroPuesto - 1 + NUM_PUESTOS_NORTE + NUM_PUESTOS_ORIENTE + NUM_PUESTOS_SUR;
            if (puestos[posicion].estaOcupado()) {
                throw new Exception("El puesto ya esta ocupado");
            }

            puestos[posicion].ocuparPuesto(nNombreEmpresa);
        }
        else if (zonaPuesto.equals(Puesto.ZONA_CENTRO)) {
            if (nNumeroPersonasExpositoras < MIN_PERSONAS_CENTRO || nNumeroPersonasExpositoras > MAX_PERSONAS_CENTRO) {
                throw new Exception("Número de personas no permitidas para la zona");
            }

            if (numeroPuesto > NUM_PUESTOS_CENTRO) {
                throw new Exception("El puesto no existe");
            }

            int posicion = numeroPuesto - 1 + NUM_PUESTOS_NORTE + NUM_PUESTOS_ORIENTE + NUM_PUESTOS_SUR + NUM_PUESTOS_OCCIDENTE;
            if (puestos[posicion].estaOcupado()) {
                throw new Exception("El puesto ya esta ocupado");
            }

            puestos[posicion].ocuparPuesto(nNombreEmpresa);

        }
        else {
            throw new Exception("Zona no permitida");
        }

        empresas.add(new Empresa(nNombreEmpresa, Empresa.EXPOSITORA, nNumeroPersonasExpositoras));
    }

    /**
     * Desocupa un puesto dado el nombre de la empresa por parámetro<br>
     * <b>pre: </b>La lista de empresas y los puestos han sido inicializados<br>
     * <b>post: </b>Se desocupó el puesto que ocupaba la empresa<br>
     * El estado del puesto que ocupaba ha sido inicializado en disponible<br>
     * La empresa cuyo nombre ha sido dado por parámetro ha sido eliminada de la lista de empresas<br>
     * @param nNombreEmpresa Es el nombre de la empresa. nNombreEmpresa != null,nNombreEmpresa != ""
     * @throws Exception <br>
     *         1. Si no existe una empresa con el nombre ingresado <br>
     *         2. Si la empresa no tiene un puesto ocupado
     */
    public void desocuparPuesto(String nNombreEmpresa) throws Exception {
        boolean encontrado = false;
        boolean ocupaPuesto = false;
        Empresa empresaBorrar = null;
        for (int i = 0; i < empresas.size(); i++) {
            Empresa empresa = empresas.get(i);
            if (empresa.darNombre().equals(nNombreEmpresa)) {
                encontrado = true;
                empresaBorrar = empresa;
            }
        }

        if (!encontrado) {
            throw new Exception("La empresa no existe");
        }

        int posicion = 0;
        for (int i = 0; i < puestos.length; i++) {
            Puesto puesto = puestos[i];
            if (puesto.estaOcupado() && puesto.darNombreEmpresa().equals(nNombreEmpresa)) {
                ocupaPuesto = true;
                posicion = i;
            }
        }

        if (!ocupaPuesto) {
            throw new Exception("La empresa no tiene puesto asignado, es una empresa visitante");
        }

        puestos[posicion].desocuparPuesto();
        empresas.remove(empresaBorrar);
    }

    /**
     * Retorna el porcentaje de ocupación de puestos<br>
     * <b>pre: </b>Los puestos han sido inicializados<br>
     * <b>post: </b>Se retornó el porcentaje de puestos ocupados<br>
     * @return Porcentaje de ocupación de puestos<br>
     */
    public double porcentajeOcupacion() {
        int numPuestosOcupados = 0;
        int totalPuestos = puestos.length;
        double porcentaje = 0;

        for (Puesto puesto : puestos) {
            if (puesto.estaOcupado()) {
                numPuestosOcupados++;
            }
        }

        porcentaje = (double) numPuestosOcupados / totalPuestos;
        porcentaje = porcentaje * 100;

        return porcentaje;
    }

    /**
     * Sugiere un puesto disponible dada una cantidad de expositores<br>
     * <b>pre: </b>Los puestos han sido inicializados<br>
     * <b>post: </b>Se retornó el puesto sugerido<br>
     * El puesto sugerido es aquel que primero puede albergar la cantidad de expositores y está disponible<br>
     * El recorrido por zonas se hace en el siguiente orden: Norte, Oriente, Sur, Occidente, Centro.
     * @param numeroExpositores > 0
     * @return Puesto sugerido para la cantidad de expositores. null si no hay puesto disponible que albergue a los expositores.
     */
    public Puesto sugerirPuesto(int numeroExpositores) {
        boolean encontro = false;
        Puesto puestoSugerido = null;
        for (int i = 0; i < puestos.length && !encontro; i++) {
            Puesto puesto = puestos[i];
            if (!puesto.estaOcupado()) {
                if (numeroExpositores <= puesto.darNumMaximoPersonas() && numeroExpositores >= puesto.darNumMinimoPersonas()) {
                    puestoSugerido = puesto;
                    encontro = true;
                }

            }
        }
        return puestoSugerido;
    }

    /**
     * Inicializa los puestos de la feria empresarial <br>
     * <b>pre: </b> El arreglo de puestos tiene tamaño NUM_PUESTOS_NORTE + NUM_PUESTOS_SUR + NUM_PUESTOS_ORIENTE + NUM_PUESTOS_OCCIDENTE + NUM_PUESTOS_CENTRO<br>
     * <b>post: </b> Los puestos han sido inicializados con sus valores de acuerdo a su zona de ubicación<br>
     * Los puestos se llenan en el siguiente orden por zonas: Norte, Oriente, Sur, Occidente, Centro. Cada zona se llena por número de puesto incrementálmente
     */
    private void crearPuestos() {
        int numPuesto = 1;
        String zona = Puesto.ZONA_NORTE;
        for (int i = 0; i < NUM_PUESTOS_NORTE; i++) {
            puestos[i] = new Puesto(numPuesto, zona, MIN_PERSONAS_NORTE, MAX_PERSONAS_NORTE);
            numPuesto++;
        }

        numPuesto = 1;
        zona = Puesto.ZONA_ORIENTE;
        for (int i = 0; i < NUM_PUESTOS_ORIENTE; i++) {
            puestos[i + NUM_PUESTOS_NORTE] = new Puesto(numPuesto, zona, MIN_PERSONAS_ORIENTE, MAX_PERSONAS_ORIENTE);
            numPuesto++;
        }

        numPuesto = 1;
        zona = Puesto.ZONA_SUR;
        for (int i = 0; i < NUM_PUESTOS_SUR; i++) {
            puestos[i + NUM_PUESTOS_NORTE + NUM_PUESTOS_ORIENTE] = new Puesto(numPuesto, zona, MIN_PERSONAS_SUR, MAX_PERSONAS_SUR);
            numPuesto++;
        }

        numPuesto = 1;
        zona = Puesto.ZONA_OCCIDENTE;
        for (int i = 0; i < NUM_PUESTOS_OCCIDENTE; i++) {
            puestos[i + NUM_PUESTOS_NORTE + NUM_PUESTOS_ORIENTE + NUM_PUESTOS_SUR] = new Puesto(numPuesto, zona, MIN_PERSONAS_OCCIDENTE, MAX_PERSONAS_OCCIDENTE);
            numPuesto++;
        }

        numPuesto = 1;
        zona = Puesto.ZONA_CENTRO;
        for (int i = 0; i < NUM_PUESTOS_CENTRO; i++) {
            puestos[i + NUM_PUESTOS_NORTE + NUM_PUESTOS_ORIENTE + NUM_PUESTOS_SUR + NUM_PUESTOS_OCCIDENTE] = new Puesto(numPuesto, zona, MIN_PERSONAS_CENTRO, MAX_PERSONAS_CENTRO);
            numPuesto++;
        }
    }

    // -----------------------------------------------------------------
    // Puntos de Extensión
    // -----------------------------------------------------------------

    /**
     * Método encargado de mostrar la zona con mas expositores
     * @return zona con mas expositores
     */
    public String metodo1() {
    	
    	//lista que se encarga de guardar los datos de todas las zonas
    	ArrayList<PuestoZonaDTO> PuestosExp = new ArrayList<PuestoZonaDTO>();
    	
    	//declaracion de DTOs encargados de almacenar los expositores por zona
    	PuestoZonaDTO NumExpZcentro = new PuestoZonaDTO();
    	NumExpZcentro.setNumExp(0);
    	PuestoZonaDTO NumExpZnorte = new PuestoZonaDTO();
    	NumExpZnorte.setNumExp(0);
    	PuestoZonaDTO NumExpZoccidente = new PuestoZonaDTO();
    	NumExpZoccidente.setNumExp(0);
    	PuestoZonaDTO NumExpZoriente = new PuestoZonaDTO();
    	NumExpZoriente.setNumExp(0);
    	PuestoZonaDTO NumExpZsur = new PuestoZonaDTO();
    	NumExpZsur.setNumExp(0);
    	
    	/*se recorren los puestos y al ocupado se le valida que sea por una empresa expositora para llenar
    	los datos de los DTOs*/
    	for (Puesto puesto : puestos) {
    		if (puesto.estaOcupado()) {
    			for(Empresa empresa: empresas) {
    				if(empresa.darTipo().equals(Empresa.EXPOSITORA)) {
    					if(empresa.darNombre().equals(puesto.darNombreEmpresa())){
    						if(puesto.darZona().equals(EnumZona.ZONA_CENTRO)) {
    		                	 NumExpZcentro.setNumExp(
    		                			 NumExpZcentro.getNumExp() + empresa.darNumeroPersonasAsistentes());
    		                	 NumExpZcentro.setZona(EnumZona.ZONA_CENTRO);
    		                 }else if(puesto.darZona().equals(EnumZona.ZONA_NORTE)) {
    		                	 NumExpZnorte.setNumExp(
    		                			 NumExpZnorte.getNumExp() + empresa.darNumeroPersonasAsistentes());
    		                	 NumExpZcentro.setZona(EnumZona.ZONA_NORTE);
    		                 }else if(puesto.darZona().equals(EnumZona.ZONA_OCCIDENTE)) {
    		                	 NumExpZoccidente.setNumExp(
    		                			 NumExpZoccidente.getNumExp() + empresa.darNumeroPersonasAsistentes());
    		                	 NumExpZcentro.setZona(EnumZona.ZONA_OCCIDENTE);
    		                 }else if(puesto.darZona().equals(EnumZona.ZONA_ORIENTE)) {
    		                	 NumExpZoriente.setNumExp(
    		                			 NumExpZoriente.getNumExp() + empresa.darNumeroPersonasAsistentes());
    		                	 NumExpZcentro.setZona(EnumZona.ZONA_ORIENTE);
    		                 }else if(puesto.darZona().equals(EnumZona.ZONA_SUR)) {
    		                	 NumExpZcentro.setNumExp(
    		                			 NumExpZcentro.getNumExp() + empresa.darNumeroPersonasAsistentes());
    		                	 NumExpZsur.setZona(EnumZona.ZONA_SUR);
    		                 
    		                 }			
    					}
    				}
    			}
            }
        }
    	
    	//Insercion datos a la lista de zonas con expositores
    	PuestosExp.add(NumExpZcentro);
    	PuestosExp.add(NumExpZnorte);    	
    	PuestosExp.add(NumExpZoccidente);
    	PuestosExp.add(NumExpZoriente);
    	PuestosExp.add(NumExpZsur);

    	//Variable que almacena los datos de la zona con más expositores
    	PuestoZonaDTO MayorCantExp = new PuestoZonaDTO();
    	MayorCantExp.setNumExp(0);
    	
    	/*se recorre la lista de zonas con expositores y se va 
    	reemplazando la variable con mayor expoxitores*/
    	
    	for(PuestoZonaDTO puestoZona: PuestosExp) {
    		if(puestoZona.getNumExp() > MayorCantExp.getNumExp()){
    			MayorCantExp.setNumExp(puestoZona.getNumExp());
    			MayorCantExp.setZona(puestoZona.getZona());
    			
    		} 
    	}

    	//imprimir resultado en pantalla
        return "Respuesta 1: La zona con mayor número de expositores "
        		+ "es la zona " + MayorCantExp.getZona() + " con " + MayorCantExp.getNumExp() 
        		+ " expositores";

    }

    /**
     * Método para la extensión2
     * @return respuesta2
     */
    public String metodo2() {
    	 int numPuestosOcupados = 0;
         int totalPuestos = puestos.length;
         double porcentaje = 0;

         for (Puesto puesto : puestos) {
             if (puesto.estaOcupado()) {
                 numPuestosOcupados++;
             }
         }

         porcentaje = (double) numPuestosOcupados / totalPuestos;
         porcentaje = porcentaje * 100;

        return "Respuesta 2";
    }

}