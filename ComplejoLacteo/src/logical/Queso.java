package logical;

public abstract class Queso {
	protected String codigo;
	protected float precioB;
	protected float precioU;
	protected char estado;
	

	public Queso(String codigo, float precioB, float precioU) {
		super();
		this.codigo = codigo;
		this.precioB = precioB;
		this.precioU = precioU;
		this.estado = 'D';

	}

	public float getPrecioB() {
		return precioB;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setPrecioB(float precioB) {
		this.precioB = precioB;
	}

	public float getPrecioU() {
		return precioU;
	}

	public void setPrecioU(float precioU) {
		this.precioU = precioU;
	}


	public abstract float Volumen();

	
	public float precioT(){

		return (precioB+precioU) * Volumen();
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

}
