package logical;

import java.util.ArrayList;

import javax.swing.DefaultListModel;

public class TiendaQueso {

	private ArrayList<Queso> misQuesos;
	private ArrayList<Cliente> misCliente;
	private ArrayList<Factura> misfacturas;
	public static int codigo = 1;
	public static int codigoFactura = 1;
	public static TiendaQueso tienda = null;

	private TiendaQueso() {
		super();
		misQuesos = new ArrayList<>();
		misCliente = new ArrayList<>();
		misfacturas = new ArrayList<>();

	}

	public static TiendaQueso getInstance() {
		if (tienda == null) {
			tienda = new TiendaQueso();
		}
		return tienda;
	}

	public ArrayList<Queso> getMisQuesos() {
		return misQuesos;
	}

	public void setMisQuesos(ArrayList<Queso> misQuesos) {
		this.misQuesos = misQuesos;
	}

	public ArrayList<Cliente> getMisCliente() {
		return misCliente;
	}

	public void setMisCliente(ArrayList<Cliente> misCliente) {
		this.misCliente = misCliente;
	}

	public ArrayList<Factura> getMisfacturas() {
		return misfacturas;
	}

	public void setMisfacturas(ArrayList<Factura> misfacturas) {
		this.misfacturas = misfacturas;
		codigoFactura++;
	}

	public void insertarQueso(Queso queso) {
		misQuesos.add(queso);
		codigo++;

	}

	public ArrayList<Queso> mayorEsferico() {
		ArrayList<Queso> queso = new ArrayList<>();

		float volumen = 0;
		for (Factura factura : misfacturas) {
			for (Queso aux : factura.getMisQuesos()) {
				if (aux instanceof QuesoEsferico && aux.Volumen() > volumen) {
					volumen = aux.Volumen();
					queso.removeAll(queso);
					queso.add(aux);
				}
				if (aux instanceof QuesoEsferico && aux.Volumen() == volumen) {
					queso.add(aux);
				}
			}
		}
		return queso;
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

	public int totalQuesosVendidos() {
		return cantEsferico() + cantCilindrico() + cantCilindricoHueco();
	}

	public float mayorFactura() { // funcion mayor factura
		float mayor = 0;
		for (Factura factura : misfacturas) {
			if (factura.PrecioFactura() > mayor) {
				mayor = factura.PrecioFactura();
			}
		}
		return mayor;
	}

	public String mayorClienteCompra() {// Cliente que mas compra
		String aux = "";
		float mayor = 0;
		for (Factura factura : misfacturas) {
			if (factura.PrecioFactura() > mayor) {
				mayor = factura.PrecioFactura();
				aux = factura.getCliente().getCedula();
			}
		}
		return aux;
	}

	public Cliente clienteEcontrado(String cedula) {
		Cliente aux = null;
		boolean encontrado = false;
		for (Cliente cliente : misCliente) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				aux = cliente;
				encontrado = true;
			}
		}
		return aux;
	}

	public Cliente buscarClienteByCedula(String cedula) {
		Cliente aux = null;
		boolean encontrado = false;
		for (Cliente cliente : misCliente) {
			if (cliente.getCedula().equalsIgnoreCase(cedula)) {
				aux = cliente;
				encontrado = true;
			}
		}
		return aux;
	}

	public float dineroGenerado() {
		float total = 0;
		for (Factura factura : misfacturas) {
			total += factura.PrecioFactura();
		}
		return total;
	}

	public Queso buscarQueso(String codigo) {
		Queso chees = null;
		for (Queso aux : misQuesos) {
			if (aux.getCodigo().equalsIgnoreCase(codigo)) {
				chees = aux;
			}
		}
		return chees;
	}

	public void modificarQueso(Queso queso) {
		// TODO Auto-generated method stub

	}

	public void insertarFactura(Factura auxF) {
		misfacturas.add(auxF);
		codigoFactura++;
	}

	public int IndexQueso(String codigo) {

		boolean encontrado = false;
		int i = 0;
		int index = -1;

		while (!encontrado && i < misQuesos.size()) {
			if (misQuesos.get(i).getCodigo().equalsIgnoreCase(codigo)) {
				index = i;
				encontrado = true;
			}
			i++;
		}
		return index;
	}

}
