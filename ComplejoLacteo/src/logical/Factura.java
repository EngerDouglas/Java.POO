package logical;

import java.util.ArrayList;

public class Factura {
	 
	private String codigo;
	private ArrayList<Queso> misQuesos;
	private Cliente cliente;
	private static int generadorDeFactura = 1;
	
	
	public Factura(Cliente cliente,String codigo,ArrayList<Queso> misQuesos) {
		super();
		this.codigo = codigo;
		this.misQuesos = misQuesos;
		this.cliente = cliente;
	}


	public ArrayList<Queso> getMisQuesos() {
		return misQuesos;
	}



	public Cliente getCliente() {
		return cliente;
	}


    public float PrecioFactura(){
    	float precio = 0;
    	for (Queso queso : misQuesos) {
			precio+=queso.precioT();
		}
    	
    	return precio;
    	
    }


	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public void insertChs(Queso chs) {
		misQuesos.add(chs);
		
	}
	
	public int cantQuesos() {
		int total = 0;
		for(Queso aux: misQuesos) {
			total++;
		}
		return total;
	}
	
	public int cantEsferico() {
		int cant = 0;
		for (Queso aux : misQuesos) {
			if (aux instanceof QuesoEsferico) {
				cant++;
			}
		}
		return cant;
	}

	public int cantCilindrico() {
		int cant = 0;
		for (Queso aux : misQuesos) {
			if (aux instanceof QuesoCilindrico) {
				cant++;
			}
		}
		return cant;
	}

	public int cantCilindricoHueco() {
		int cant = 0;
		for (Queso aux : misQuesos) {
			if (aux instanceof QuesoCilindricoH) {
				cant++;
			}
		}
		return cant;
	}

	// precio de los diferentes quesos
	public float precioEsferico() {
		float cant = 0;
		for (Queso aux : misQuesos) {
			if (aux instanceof QuesoEsferico) {
				cant += aux.precioT();
			}
		}
		return cant;
	}

	public float precioCilindrico() {
		float cant = 0;
		for (Queso aux : misQuesos) {
			if (aux instanceof QuesoCilindrico) {
				cant += aux.precioT();
			}
		}
		return cant;
	}
	
	public float precioCilindricoHueco() {
		float cant = 0;
		for (Queso aux : misQuesos) {
			if (aux instanceof QuesoCilindricoH) {
				cant += aux.precioT();
			}
		}
		return cant;
	}

	
}
