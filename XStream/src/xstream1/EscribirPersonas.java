package xstream1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class EscribirPersonas {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		File fichero = new File("listaPersonas.dat");
		FileInputStream filein = new FileInputStream(fichero); // flujo de entrada
		ObjectInputStream dataIS = new ObjectInputStream(filein); // conecta el flujo de bytes al flujo de datos
		System.out.println("Comienza el proceso de creación del fichero XML");
// creamos un objeto Lista de Personas
		ListaPersona listaper = new ListaPersona();
		try {
			while (true) { // lectura del fichero
				Cpersona persona = (Cpersona) dataIS.readObject(); // leer una persona
				listaper.add(persona); // añadir persona a la lista
			}
		} catch (EOFException eo) {
		}
		dataIS.close();
		try {
			XStream xstream = new XStream();
			xstream = new XStream(new DomDriver());
// cambiar de nombre a las etiquetas XML
			xstream.alias("ListaPersonasMunicipio", ListaPersona.class);
			xstream.alias("DatosPersona", Cpersona.class);
//quitar etiqueta lista (atributo de la clase ListaPersonas)
			xstream.addImplicitCollection(ListaPersona.class, "lista");
//Insertar los objetos en el XML
			xstream.toXML(listaper, new FileOutputStream("Personas.xml"));
			System.out.println("Creado fichero XML......");
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // fin del main
} // fin del EscribirPersonas