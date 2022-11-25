package xstream1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeerPersonas {
	public static void main(String[] args) throws IOException {
		XStream xstream = new XStream();
		xstream = new XStream(new DomDriver());
		xstream.alias("ListaPersonasMunicipio", ListaPersona.class);
		xstream.alias("DatosPersona", Cpersona.class);
		xstream.addImplicitCollection(ListaPersona.class, "lista");
		ListaPersona listadoTodas = (ListaPersona) xstream.fromXML(new FileInputStream("Personas.xml"));
		System.out.println("Número de Personas: " + listadoTodas.getListaPersonas().size());
		List<Cpersona> listaPersonas = new ArrayList<Cpersona>();
		listaPersonas = listadoTodas.getListaPersonas();
		Iterator iterador = listaPersonas.listIterator(); // iterador de los elementos
		while (iterador.hasNext()) {
			Cpersona p = (Cpersona) iterador.next(); // obtengo el elemento contenido
			System.out.println(
					"Nombre: " + p.getNombre() + ", apellido: " + p.getApellido() + ", teléfono: " + p.getTelefono());
		}
		System.out.println("Fin del listado");
	} // fin del main
} // fin de LeerPersonas