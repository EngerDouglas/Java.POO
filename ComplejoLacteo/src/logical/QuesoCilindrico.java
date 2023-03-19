package logical;

public class QuesoCilindrico extends Queso {

   protected float longitud;
   protected int radieExt;
	
	
	public QuesoCilindrico(String codigo, float precioB, float precioU, int radioE,float longitud) {
		super(codigo, precioB, precioU);
		this.longitud = longitud;
		this.radieExt = radioE;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	@Override
	public float Volumen() {
		float volumen = longitud*AreaBase(); 
		return volumen;
	}
	
	public float AreaBase(){
		return (float)(Math.pow(radieExt, 2)*Math.PI);
	}

	public int getRadieExt() {
		return radieExt;
	}

	public void setRadieExt(int radieExt) {
		this.radieExt = radieExt;
	}
	

}
