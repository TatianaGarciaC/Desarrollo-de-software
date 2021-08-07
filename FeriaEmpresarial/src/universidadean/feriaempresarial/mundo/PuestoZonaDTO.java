package universidadean.feriaempresarial.mundo;

import java.io.Serializable;

public class PuestoZonaDTO implements Serializable{
	
	/**
	 * Tatiana.Garcia
	 */
	
	private static final long serialVersionUID = 1L;
	
	
	private String Zona;
	private Integer NumExp;
	
	public String getZona() {
		return Zona;
	}
	public void setZona(String zona) {
		Zona = zona;
	}
	public Integer getNumExp() {
		return NumExp;
	}
	public void setNumExp(Integer numExp) {
		NumExp = numExp;
	}
	
}
