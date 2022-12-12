package clases;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Paises espanya = new Paises(1, "España");
		Paises holanda = new Paises(2, "Holanda");
		Paises portugal = new Paises(3, "Portugal");
		
		Jugadores j1 = new Jugadores(1, "Paco", espanya);
		Jugadores j2= new Jugadores(2, "Van Gaal", holanda);
		Jugadores j3 = new Jugadores(3, "Pablinho", portugal);
		Jugadores j4 = new Jugadores(4, "Miguel", espanya);
		Jugadores j5 = new Jugadores(5, "Lukas", holanda);
		Jugadores j6 = new Jugadores(6, "Cristiano", portugal);
		
		ODB odb = ODBFactory.open("neodatis.test");
		
		//Almacenamos objetos
		odb.store(j1);
		odb.store(j2);
		odb.store(j3);
		odb.store(j4);
		odb.store(j5);
		odb.store(j6);
		//recuperamos todos los objetos
		Objects<Jugadores> objects = odb.getObjects(Jugadores.class);
		
		System.out.println(objects.size()+ " Jugadores");
		int i=1;
		//visualizar los objetos
		while (objects.hasNext()) {
		Jugadores jug = objects.next();
		System.out.println( (i++) + " \t: " + jug.getNombre() + "*");
		}
		odb.close();
		
		
		
	}

}
