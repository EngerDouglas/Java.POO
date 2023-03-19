package logical;

public class QuesoEsferico extends Queso {
    
	protected int radioE;
	
	public QuesoEsferico(String codigo,float precioB, float precioU, int radioE) {
		super(codigo, precioB, precioU);
		this.radioE = radioE;
	}
	
	public int getRadioE() {
		return radioE;
	}

	public void setRadioE(int radioE) {
		this.radioE = radioE;
	}

	@Override
	public float Volumen() {
		float volumen = (float)(4 * Math.pow(radioE, 3)*Math.PI)/3; 
		return volumen;

	}


}
