package logical;

public class QuesoCilindricoH extends QuesoCilindrico {

	private float radioI;
	
	public QuesoCilindricoH(String codigo, float precioB, float precioU, int radioE, float longitud,float radioI) {
		super(codigo, precioB, precioU, radioE, longitud);
		this.radioI = radioI;
	}
	
	public float getRadioI() {
		return radioI;
	}

	public void setRadioI(float radioI) {
		this.radioI = radioI;
	}

	public float AreaBase() {
		return (float)((Math.pow(radieExt, 2)- Math.pow(radioI, 2))*Math.PI); 

	}

}
