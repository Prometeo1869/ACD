package mantenimientoCafes;

import java.util.Objects;

public class Cafe {

	String cafeNombre;
	int proveedor, ventas, total;
	float precio;
	
	public Cafe(String cafeNombre, int proveedor, float precio, int ventas, int total) {
		this.cafeNombre = cafeNombre;
		this.proveedor = proveedor;
		this.precio = precio;
		this.ventas = ventas;
		this.total = total;
	}
	
	public Cafe(String cafeNombre) {
		this.cafeNombre = cafeNombre;
		this.proveedor = 0;
		this.precio = 0;
		this.ventas = 0;
		this.total = 0;
	}
	
	public Cafe() {
		
	}

	public String getCafeNombre() {
		return cafeNombre;
	}

	public void setCafeNombre(String cafeNombre) {
		this.cafeNombre = cafeNombre;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}

	public int getVentas() {
		return ventas;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cafeNombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cafe other = (Cafe) obj;
		return Objects.equals(cafeNombre, other.cafeNombre); 
	}

	@Override
	public String toString() {
		return "Café [Nombre: " + cafeNombre + ", Proveedor: " + proveedor + ", Ventas: " + ventas + ", Total: " + total
				+ ", Precio: " + precio + "]\n";
	}
	
	
}
