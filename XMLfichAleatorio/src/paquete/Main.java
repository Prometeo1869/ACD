package paquete;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		RandomAccessFile file = null;
		try {
			DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factoria.newDocumentBuilder();
			DOMImplementation implementacion = builder.getDOMImplementation();
			Document documento = implementacion.createDocument(null, "empleados", null);
			documento.setXmlVersion("1.0");
						
			file = new RandomAccessFile("archivoAccesoAleatorio.dat", "r");
			
			for (int i = 0; i*36 < file.length(); i++) {
				Element e_empleado = documento.createElement("empleado");
				Element e_id = documento.createElement("ID");
				Element e_apellido = documento.createElement("Apellido");
				Element e_departamento = documento.createElement("Departamento");
				Element e_salario = documento.createElement("Salario");
				file.seek(i*36);
				
				Empleado empleado = new Empleado();
				empleado.leerFichero(file);
				
				documento.getDocumentElement().appendChild(e_empleado);
				e_empleado.appendChild(e_id);
				e_id.setTextContent(String.valueOf(empleado.getId()));
				e_empleado.appendChild(e_apellido);
				e_apellido.setTextContent(empleado.getApellido());
				e_empleado.appendChild(e_departamento);
				e_departamento.setTextContent(String.valueOf(empleado.getDepartamento()));
				e_empleado.appendChild(e_salario);
				e_salario.setTextContent(String.valueOf(empleado.getSalario()));
			}
			Source origen = new DOMSource(documento);
			Result resultado = new StreamResult(new File("resultado.xml"));
			Result consola = new StreamResult(System.out);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			//indentado SI
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(origen, resultado);
			transformer.transform(origen, consola);
						
		} catch (FileNotFoundException e) {
			System.out.println("Error con el fichero");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	static void crearElements() {
		
	}

}