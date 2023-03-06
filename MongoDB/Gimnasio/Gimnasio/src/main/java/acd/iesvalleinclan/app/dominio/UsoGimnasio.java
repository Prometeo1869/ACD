package acd.iesvalleinclan.app.dominio;
/**
 * Clase UsoGimansio con los mismos atributos que el documento "uso_gimnasio" de la base de datos "gimnasio"
 * 
 * @author Juan Cebrián
 *
 */
public class UsoGimnasio {
	String id, codsocio, codactiv, fecha;
	int horainicio, horafinal;
	
	//CONSTRUCTOR CON TODOS LOS ARGUMENTOS
	public UsoGimnasio(String id, String codsocio, String codactiv, int horainicio, int horafinal, String fecha) {
		super();
		this.id = id;
		this.codsocio = codsocio;
		this.codactiv = codactiv;
		this.horainicio = horainicio;
		this.horafinal = horafinal;
		this.fecha = fecha;
	}
	
	//CONSTRUCTOR VACIO
	public UsoGimnasio() {
		super();
	}

	//GETTER & SETTER
	public String getId() { return id;	}
	public void setId(String id) { this.id = id; }
	public String getCodsocio() { return codsocio;	}
	public void setCodsocio(String codsocio) {	this.codsocio = codsocio; }
	public String getCodactiv() { return codactiv;	}
	public void setCodactiv(String codactiv) {	this.codactiv = codactiv; }
	public int getHorainicio() { return horainicio; }
	public void setHorainicio(int horainicio) {	this.horainicio = horainicio; }
	public int getHorafinal() {	return horafinal; }
	public void setHorafinal(int horafinal) { this.horafinal = horafinal; }
	public String getFecha() { return fecha; }
	public void setFecha(String fecha) { this.fecha = fecha; }

	//TOSTRING
	@Override
	public String toString() {
		return "UsoGimnasio [id=" + id + ", codsocio=" + codsocio + ", codactiv=" + codactiv + ", horainicio="
				+ horainicio + ", horafinal=" + horafinal + ", fecha=" + fecha + "]";
	}

	
}
