package logical;

public class Cliente {
	private String cedula;
	private String nombre;
	private String dir;
	private String telefono;

	public Cliente(String cedula, String nombre, String dir, String telefono) {
		super();
		this.cedula = cedula;
		this.nombre = nombre;
		this.dir = dir;
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
