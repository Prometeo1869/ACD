package xstream1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListaPersona implements Serializable {

	List<Cpersona> listaPersonas = new ArrayList<>();
	
	public ListaPersona() {

	}

	public ListaPersona (List<Cpersona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	public List<Cpersona> getListaPersonas() {
		return listaPersonas;
	}

	public void setListaPersonas(List<Cpersona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}

	Cpersona getPersona(int indice) {
		return (this.listaPersonas.get(indice));
	}

	int buscar() {
		System.out.println("Nombre:");
		String nombre = new Scanner(System.in).nextLine();
		Cpersona aux = new Cpersona(nombre);
		int indice = this.listaPersonas.indexOf(aux);
		return indice;
	}

	void buscarTodos(Cpersona buscada) {
		
		System.out.println("Nombre:");
		int i = 0;
		for (Cpersona persona : listaPersonas) {
			if (persona.equals(buscada)) {
				if(i != 0) {
				System.out.println(persona.toString());
				}
				i++;
			}
		}
		if (i == 0) {
			System.out.println("No hay nadie con ese nombre");
		}
	}

	void mostrarTodos() {
		if (listaPersonas.size() == 0) {
			System.out.println("\nLa lista está vacia\n");
		} else {
			for (Cpersona persona : listaPersonas) {
				System.out.println(persona.toString());
			}
		}
	}

	void add(Cpersona nuevo) {
		this.listaPersonas.add(nuevo);
	}

	Cpersona borrarPersona(int indice) {
		return this.listaPersonas.remove(indice);
	}
}